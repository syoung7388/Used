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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.used.example.domain.Pagination;
import com.used.example.domain.Picture;
import com.used.example.domain.Product;
import com.used.example.service.AuctionService;
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
		
			
			
		}
				
		//logger.info("p_num:"+product.getP_num());
		//logger.info("product:"+product);
		
		return new ResponseEntity<>( "success", HttpStatus.OK);

	}
	

	@GetMapping("/sale")
	public ResponseEntity<?> SaleList(HttpServletRequest request){
		
		String token= request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token= token.substring(7, token.length());
		}
		String username= JwtUtils.getUserEmailFromToken(token);
		Map<String,Object> map= new HashMap<>();
		
		Auction auction = new Auction();
		auction.setA_username(username);
		auction.setSale(0);
		List<Auction> salelist = auctionService.SaleList(auction);
		
		auction.setSale(1);
		List<Auction> soldlist= auctionService.SaleList(auction);
		
		map.put("salelist", salelist);
		map.put("soldlist", soldlist);
		
		
		logger.info("salelist:"+ salelist);
		return new ResponseEntity<>(map, HttpStatus.OK);
		
	}
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
	public ResponseEntity<?> AucEdit(Auction auction, Picture picture,Address address, Product product) throws IOException{
		
		
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
	
//	@GetMapping("/top/{lat}/{lon}")
//	public ResponseEntity<?> TopList(@PathVariable("lat") String lat, @PathVariable("lon") String lon){
//		
//		Address address= new Address();
//		address.setLat(lat);
//		address.setLon(lon);
//		
//		List<Auction> toplist= auctionService.TopList(address);
//		
//		logger.info("toplist:"+ toplist);
//		return new ResponseEntity<>(toplist, HttpStatus.OK);
//		
//	}
	
	
	@GetMapping("/top")
	public ResponseEntity<?> TopList(@RequestParam("lat") String lat, @RequestParam("lon") String lon, @RequestParam("page") int page){
		
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
			int count = auctionService.Count(map);
			pagination = new Pagination(count, page);
			logger.info("pagination:"+pagination );
			topmap.put("pagination", pagination);
			
		}

		logger.info("topmap:"+ topmap);
		return new ResponseEntity<>( topmap, HttpStatus.OK);
		
	}
	
	@GetMapping("/industry")
	public ResponseEntity<?> IndustryList(@RequestParam("lat")String lat, @RequestParam("lon")String lon, @RequestParam("industry")String industry){
		
		
		List<Auction> industryList = auctionService.IndustryList(lat, lon, industry);
		
		
		
		//logger.info("industryList:"+ industryList);

			return new ResponseEntity<>(industryList, HttpStatus.OK);
	
	}
	
	@GetMapping("/kind")
	public ResponseEntity<?> KindList(@RequestParam("lat")String lat, @RequestParam("lon")String lon, @RequestParam("kind")String kind){
		
		
		
		
		List<Auction> kindlist= auctionService.KindList(lat, lon, kind);
		//logger.info("kindlist:"+kindlist);
		return new ResponseEntity<>(kindlist, HttpStatus.OK);
	}
	


}
