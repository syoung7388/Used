package com.used.example.controller;


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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.used.example.config.JwtUtils;
import com.used.example.domain.Auction;
import com.used.example.domain.Product;
import com.used.example.service.AuctionService;

@CrossOrigin(origins="*", maxAge= 3600)
@RestController
@RequestMapping("/api/auction")
public class AuctionController {
	
	
	@Autowired
	AuctionService auctionService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String token;
	
	
	@PostMapping
	public ResponseEntity<?> CreateAuction(@RequestBody Auction auction, HttpServletRequest request){
		
		token= request.getHeader("access_token");
		if(StringUtils.hasText(token)&& token.startsWith("Bearer") ) {
			token = token.substring(7, token.length());
		}
		String participant = JwtUtils.getUserEmailFromToken(token);
		
		auction.setParticipant(participant);
		
		auctionService.CreateAuction(auction);
		
		return new ResponseEntity<>("success",HttpStatus.OK); 
	}
	
	@GetMapping
	public ResponseEntity<?> AuctionList(HttpServletRequest request){
		
		token = request.getHeader("access_token");
		
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(7, token.length());
		}
		
		
		String username = JwtUtils.getUserEmailFromToken(token);
		logger.info(username);
		
		Product product = new Product();
		product.setUsername(username);
		product.setSale("false");
	
		List<Product> bidinglist =auctionService.AuctionList(product);
		
		logger.info("bidinglist:"+bidinglist);
		//logger.info("product:"+product);
		
		product.setSale("true");
		List<Product> bidlist =auctionService.AuctionList(product);
		//logger.info("bidlist:"+bidlist);
		
		product.setSale("pay");
		List<Product> paylist = auctionService.AuctionList(product);
		
		
		
		
		Map<String, Object> map= new HashMap<>();
		map.put("bidinglist",bidinglist);
		map.put("bidlist", bidlist);
		map.put("paylist", paylist);
		
		logger.info("paylist"+paylist);
		
		
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/{p_num}")
	public ResponseEntity<?> AuctionDetail(@PathVariable("p_num") int p_num){
		
		
		Product product = auctionService.AuctionDetail(p_num);
		
		//logger.info("product:"+product);
		//logger.info("p_num:"+p_num);
		return new ResponseEntity<>(product , HttpStatus.OK);
	}
	
	@DeleteMapping("/{a_num}")
	public ResponseEntity<?> AuctionDelete(@PathVariable("a_num") int a_num){
		
		auctionService.AuctionDelete(a_num);
		return new ResponseEntity<>("success", HttpStatus.OK);
		
	}

}
