package com.used.example.controller;


import java.io.IOException;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.annotation.Secured;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.used.example.config.JwtUtils;
import com.used.example.domain.Address;
import com.used.example.domain.Auc_Pro;
import com.used.example.domain.Auction;
import com.used.example.domain.DelayDate;
import com.used.example.domain.Picture;
import com.used.example.domain.Product;
import com.used.example.service.AuctionService;
import com.used.example.service.OfferService;
import com.used.example.service.ProductService;
import com.used.example.service.UserService;


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

		Map<String, Object> map = auctionService.SaleStatistic(username);
		
		
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
	
		
		Auction auction = new Auction();
		auction.setA_username(username);
		auction.setSale(sale);
		List<Auction> salelist = auctionService.SaleList(auction);
		return new ResponseEntity<>(salelist, HttpStatus.OK);
		
	}
	
	

	
	@Secured({"ROLE_USER"})
	@PutMapping
	public ResponseEntity<?> AucEdit(Auction auction, Picture picture,Address address, Product product, HttpServletRequest request) throws IOException{
		


		auction.setAddress(address);
		auction.setPro(product);
		
		auctionService.AucEdit(auction);
		
		
		if(picture.getPi_nums() != null) {
			productService.deletePicture(picture);// ?????????????????? ??????
		}
		
		int Pnum= product.getP_num();
		picture.setP_num(Pnum);
		productService.createPicture(picture);
		
		int a_num = auction.getA_num();
		Auction auction1= auctionService.AucDetail(a_num);
		//logger.info("auc:"+auc);
		return new ResponseEntity<>(auction1, HttpStatus.OK);
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
	@PutMapping("/delay")
	public ResponseEntity<?> AucDelay(@RequestBody DelayDate delaydate){
		
	
		Auction detail = auctionService.AucDelay(delaydate);
		
		return new ResponseEntity<>(detail,HttpStatus.OK );
	}
	

	

	
	

	

	
	
	
	


}
