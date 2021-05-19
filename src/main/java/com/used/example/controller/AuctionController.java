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
import com.used.example.domain.MonthSum;
import com.used.example.domain.UserInfo;
import com.used.example.service.AuctionService;
import com.used.example.service.OfferService;
import com.used.example.service.ProductService;
import com.used.example.service.UserService;
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
	
	@Autowired
	UserService userService;
	
	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	

	
	

	
	
	private String token;
	
	
	@Secured({"ROLE_USER"})
	@PostMapping
	public ResponseEntity<?> CreateAuction(Auction auction, Product product, Picture picture, Address address, HttpServletRequest request) throws IOException{
	
		token = request.getHeader("access_token");
		
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(6, token.length());
		}
		String username = JwtUtils.getUserEmailFromToken(token);
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
		
		picture.setP_num(Pnum);
		productService.createPicture(picture);
							
		//logger.info("p_num:"+product.getP_num());
		//logger.info("product:"+product);
		
		return new ResponseEntity<>( "success", HttpStatus.OK);

	}
	
	
	@Secured({"ROLE_USER"})
	@GetMapping("/statistic")
	public ResponseEntity<?> SaleStatistic(HttpServletRequest request){
		String token= request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token= token.substring(6, token.length());
		}
		String username= JwtUtils.getUserEmailFromToken(token);
		
		Count count = auctionService.SaleCount(username);
		
		List<MonthSum> sum = auctionService.SaleSum(username);
		logger.info("sum:"+sum);
		
		Map<String, Object> map = new HashMap<>();
		
		
		List<String> month = new ArrayList<>();
		List<Long> total = new ArrayList<>();
		List<String> labels = new ArrayList<>();
		
		
		for(int i=0; i< sum.size(); i++) {
			month.add(sum.get(i).getMonth()+"월");
			total.add(sum.get(i).getTotal());
		}
		map.put("count", count);
		map.put("month", month);
		map.put("total", total);
		
		return new ResponseEntity<>( map, HttpStatus.OK);
		
	}
	
	
	@Secured({"ROLE_USER"})
	@GetMapping("/{sale}")
	public ResponseEntity<?> SaleList(HttpServletRequest request, @PathVariable("sale") int sale){
		
		String token= request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token= token.substring(6, token.length());
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
	@PutMapping
	public ResponseEntity<?> AucEdit(Auction auction, Picture picture,Address address, Product product, HttpServletRequest request) throws IOException{
		
		
		String token= request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token= token.substring(6, token.length());
		}
		String username= JwtUtils.getUserEmailFromToken(token);
		

		auction.setAddress(address);
		auction.setPro(product);
		auctionService.AucEdit(auction);
		
		
		if(picture.getPi_nums() != null) {
			productService.deletePicture(picture);// 삭제한사진들 삭제
		}
		
		int Pnum= product.getP_num();
		picture.setP_num(Pnum);
		productService.createPicture(picture);
		
		int a_num = auction.getA_num();
		Auction auc= auctionService.AucDetail(a_num);
			
			
		
		
		
		//logger.info("auc:"+auc);
		return new ResponseEntity<>(auc, HttpStatus.OK);
	}
	
	
	
	@Secured({"ROLE_USER"})
	@DeleteMapping("/{a_num}")
	public ResponseEntity<?> AucDelete(@PathVariable("a_num") int a_num, HttpServletRequest request){
		
		
		String token= request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token= token.substring(6, token.length());
		}
		String username= JwtUtils.getUserEmailFromToken(token);
		
		auctionService.AucDelete(a_num);
		
		return new ResponseEntity<>("success",HttpStatus.OK);
		
		
	}
	
	

	
	
	@Secured({"ROLE_USER"})
	@PutMapping("/step")
	public ResponseEntity<?> AucEnd(@RequestBody Auction auction,  HttpServletRequest request){
		
		int a_num = auction.getA_num();
		auctionService.AucStep(a_num);		
		token = request.getHeader("access_token");		
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(6, token.length());
		}
		String o_username = JwtUtils.getUserEmailFromToken(token);		
		Bid_request bid_r= new Bid_request();
		bid_r.setO_username(o_username);
		bid_r.setSale(2);
		List<Auction> bidlist =offerService.BidList(bid_r);
		return new ResponseEntity<> (bidlist, HttpStatus.OK);
		
	}
	

	
	
	
	


}
