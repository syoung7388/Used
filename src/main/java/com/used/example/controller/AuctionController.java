package com.used.example.controller;


import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.used.example.config.JwtUtils;
import com.used.example.domain.Address;
import com.used.example.domain.Auc_Pro;
import com.used.example.domain.Auction;
import com.used.example.domain.Bid_request;
import com.used.example.domain.Count;
import com.used.example.domain.Pagination;
import com.used.example.domain.Picture;
import com.used.example.domain.Product;
import com.used.example.service.AuctionService;
import com.used.example.service.OfferService;
import com.used.example.service.ProductService;
import com.used.example.utility.MakeThumbnail;

@CrossOrigin(origins="*", maxAge= 5000)
@RestController
@RequestMapping("/api/auction")
public class AuctionController {
	
	
	@Autowired
	AuctionService auctionService;
	
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OfferService offerService;
	
	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	

	
	
	private String token;
	
	
	
	@PostMapping
	public ResponseEntity<?> CreateAuction(Auction auction, Product product, Picture picture, Address address, HttpServletRequest request) throws IOException{
	
		token = request.getHeader("access_token");
		
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(7, token.length());
		}
		String username = JwtUtils.getUserEmailFromToken(token);
		
		
		
		if(username != null) {
			auction.setA_username(username);
			auctionService.CreateAuction(auction);
			int Anum = auction.getA_num();
			

			productService.createProduct(product);
			int Pnum = product.getP_num();
			
			
			Auc_Pro ap = new Auc_Pro();
			ap.setA_num(Anum);
			ap.setP_num(Pnum);
			
			auctionService.CreateAP(ap);
			
			address.setA_num(Anum);
			auctionService.CreateAddress(address);
			
			
			
			
			
			List<MultipartFile> imgList= picture.getImg();
			if(imgList != null) {
			List<String> pictureNames= new ArrayList<String>();
		        //String path="C:\\Users\\User\\Desktop\\workspace\\Used\\src\\usedf\\src\\assets\\";
				String path="C:\\Users\\l3\\Documents\\work2\\Used\\src\\usedf\\src\\assets\\";
				for(int i=0; i<imgList.size(); i++) {
					
					String filename= imgList.get(i).getOriginalFilename();
					String ext= filename.substring(filename.lastIndexOf(".")+1);
					File file= new File(path+ filename);			
					InputStream input = imgList.get(i).getInputStream();
					
					MakeThumbnail makeThumbnail = new MakeThumbnail();
					makeThumbnail.makeThumbnail(input, file,  ext);		
					
					pictureNames.add(filename);
				}
				
			
				picture.setP_num(Pnum);
				picture.setPictureNames(pictureNames);	
				productService.createPicture(picture);
			}
		
			
			
		}
				
		//logger.info("p_num:"+product.getP_num());
		//logger.info("product:"+product);
		
		return new ResponseEntity<>( "success", HttpStatus.OK);

	}
	
	
	@GetMapping("/sale")
	public ResponseEntity<?> SaleCount(HttpServletRequest request){
		String token= request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token= token.substring(7, token.length());
		}
		String username= JwtUtils.getUserEmailFromToken(token);
		
		Count count = auctionService.SaleCount(username);
		
		return new ResponseEntity<>(count, HttpStatus.OK);
		
	}
	

	@GetMapping("/sale/{sale}")
	public ResponseEntity<?> SaleList(HttpServletRequest request, @PathVariable("sale") int sale){
		
		String token= request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token= token.substring(7, token.length());
		}
		String username= JwtUtils.getUserEmailFromToken(token);
		Map<String,Object> map= new HashMap<>();
		
		Auction auction = new Auction();
		auction.setA_username(username);
		auction.setSale(sale);
		List<Auction> salelist = auctionService.SaleList(auction);

		return new ResponseEntity<>(salelist, HttpStatus.OK);
		
	}
	
	
	@Secured({"ROLE_USER"})
	@GetMapping("/{a_num}")
	public ResponseEntity<?> AucDetail(@PathVariable("a_num") int a_num, HttpServletRequest request){
		
		auctionService.Hits(a_num);

		token = request.getHeader("access_token");
		if(StringUtils.hasText(token)&& token.startsWith("Bearer")) {
			token = token.substring(7, token.length());
		}
		String username = JwtUtils.getUserEmailFromToken(token);
		if(username != null) {
			Auction aucdetail= auctionService.AucDetail(a_num);
			logger.info("aucdetail:"+aucdetail);
			return new ResponseEntity<>(aucdetail, HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>( HttpStatus.OK);
		}
		
		
		//logger.info("a_num:"+a_num);
		
	}
	
	@PutMapping
	public ResponseEntity<?> AucEdit(Auction auction, Picture picture,Address address, Product product, HttpServletRequest request) throws IOException{
		
		token = request.getHeader("access_token");		
		logger.info("token:"+token); // null
		
		
		auction.setAddress(address);
		auction.setPro(product);
		auctionService.AucEdit(auction);
		
		
		if(picture.getPi_nums() != null) {
			productService.deletePicture(picture);// 삭제한사진들 삭제
		}
		
		int Pnum= product.getP_num();
		List<MultipartFile> imgList= picture.getImg();
		if(imgList != null) {
			List<String> pictureNames= new ArrayList<String>();
	        String path="C:\\Users\\User\\Desktop\\workspace\\Used\\src\\usedf\\src\\assets\\";
			//String path="C:\\Users\\l3\\Documents\\work2\\Used\\src\\usedf\\src\\assets\\";
				for(int i=0; i<imgList.size(); i++) {
					
					String filename= imgList.get(i).getOriginalFilename();
					String ext= filename.substring(filename.lastIndexOf(".")+1);
					File file= new File(path+ filename);			
					InputStream input = imgList.get(i).getInputStream();
					
					MakeThumbnail makeThumbnail = new MakeThumbnail();
					makeThumbnail.makeThumbnail(input, file,  ext);		
					
					pictureNames.add(filename);
				}
				
				
				picture.setP_num(Pnum);
				picture.setPictureNames(pictureNames);	
				productService.createPicture(picture);
		}
				
			int a_num = auction.getA_num();
			Auction auc= auctionService.AucDetail(a_num);
			
			
		
		
		
			logger.info("auc:"+auc);
		return new ResponseEntity<>(auc, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{a_num}")
	public ResponseEntity<?> AucDelete(@PathVariable("a_num") int a_num){
		//logger.info("a_num:"+a_num);
		
		auctionService.AucDelete(a_num);
		
		
		
		return new ResponseEntity<>("success",HttpStatus.OK);
		
		
	}
	
	
	
	@GetMapping("/top")
	public ResponseEntity<?> TopList(@RequestParam("lat") String lat, @RequestParam("lon") String lon, @RequestParam("page") int page, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		Pagination pagination = new Pagination();
		
		map.put("lat", lat);
		map.put("lon", lon);
		map.put("limit", page*pagination.getPerpage());
		
		List<Auction> toplist= auctionService.TopList(map);
		
		Map<String, Object> topmap = new HashMap<>();
		
		topmap.put("toplist", toplist);
	
	
		
		
		if(page == 0) {
			
			map.put("listsort", 0);
			int count = auctionService.TotalCount(map);
			pagination = new Pagination(count, page);
			//logger.info("pagination:"+pagination );
			topmap.put("pagination", pagination);
			
		}

		//logger.info("topmap:"+ topmap);
		return new ResponseEntity<>( topmap, HttpStatus.OK);
		
	}
	
	@GetMapping("/industry")
	public ResponseEntity<?> IndustryList(@RequestParam("lat")String lat, @RequestParam("lon")String lon, @RequestParam("industry")String industry, @RequestParam("page") int page){
		
		
		Pagination pagination = new Pagination();
		Map<String ,Object> map = new HashMap<>();
		map.put("lat", lat);
		map.put("lon", lon);
		map.put("industry", industry);
		map.put("limit", page*pagination.getPerpage());
		List<Auction> industrylist = auctionService.IndustryList(map);
		
		
		Map<String ,Object> industrymap = new HashMap<>();
		industrymap.put("industrylist", industrylist);
		
		
		
		
		
		if(page == 0) {
			map.put("listsort", 1);
			int count = auctionService.TotalCount(map);
			pagination = new Pagination(count, page);
			industrymap.put("pagination", pagination);
			
		}
		
		
		
		
		
		
		logger.info("industrymap:"+ industrymap);

		return new ResponseEntity<>(industrymap, HttpStatus.OK);
	
	}
	
	@GetMapping("/kind")
	public ResponseEntity<?> KindList(@RequestParam("lat")String lat, @RequestParam("lon")String lon, @RequestParam("kind")String kind ,@RequestParam("page") int page ){
		Pagination pagination = new Pagination();
		Map<String ,Object> map = new HashMap<>();
		map.put("lat", lat);
		map.put("lon", lon);
		map.put("kind", kind);
		map.put("limit", page*pagination.getPerpage());
		List<Auction> kindlist = auctionService.KindList(map);
		
		
		Map<String ,Object> kindmap = new HashMap<>();
		kindmap.put("kindlist", kindlist);
		if(page == 0) {
			map.put("listsort", 2);
			int count = auctionService.TotalCount(map);
			pagination = new Pagination(count, page);
			kindmap.put("pagination", pagination);
			
		}
		logger.info("kindmap:"+ kindmap);

		return new ResponseEntity<>(kindmap, HttpStatus.OK);
	
	}
	
	@PutMapping("/step")
	public ResponseEntity<?> AucEnd(@RequestBody Auction auction,  HttpServletRequest request){
		
		int a_num = auction.getA_num();
		logger.info("a_num"+ a_num);
		
		
		auctionService.AucStep(a_num);
		
		token = request.getHeader("access_token");
		
		logger.info("token:"+token); // null
		
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(7, token.length());
		}
		
		
		String o_username = JwtUtils.getUserEmailFromToken(token);
		
		Bid_request bid_r= new Bid_request();
		bid_r.setO_username(o_username);
		bid_r.setSale(2);
		
		List<Auction> bidlist =offerService.BidList(bid_r);
		
		
		
		return new ResponseEntity<> (bidlist, HttpStatus.OK);
		
	}
	


}
