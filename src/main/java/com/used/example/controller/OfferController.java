package com.used.example.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UserDetails;
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
import org.springframework.web.multipart.MultipartFile;


import com.used.example.config.JwtUtils;
import com.used.example.domain.Auction;
import com.used.example.domain.Bid_request;
import com.used.example.domain.Like;
import com.used.example.domain.Offer;
import com.used.example.domain.Picture;
import com.used.example.domain.Product;
import com.used.example.service.AuctionService;
import com.used.example.service.OfferService;
import com.used.example.service.PaymentService;
import com.used.example.service.ProductService;
import com.used.example.utility.MakeThumbnail;


@CrossOrigin(origins="*", maxAge =3600)
@RestController
@RequestMapping("/api/offer")
public class OfferController {
	
	///https://purumae.tistory.com/198 
	///https://dba.stackexchange.com/questions/33410/whats-the-difference-between-pointx-y-and-geomfromtextpointx-y
	
	@Autowired
	OfferService offerService;
	
	@Autowired
	AuctionService auctionService;
	
	@Autowired
	PaymentService paymentService;
	
	private final Logger logger= LoggerFactory.getLogger(this.getClass());

	private String token;
	
	
	
	
	
	@PostMapping
	public ResponseEntity<?> CreateOffer(@RequestBody Offer offer, HttpServletRequest request){
		
		token= request.getHeader("access_token");
		if(StringUtils.hasText(token)&& token.startsWith("Bearer") ) {
			token = token.substring(7, token.length());
		}
		String o_username = JwtUtils.getUserEmailFromToken(token);
		
		offer.setO_username(o_username);
		offerService.CreateOffer(offer);
		
		int a_num = offer.getA_num();
		Auction auction = auctionService.AucDetail(a_num);
		
		
		
		return new ResponseEntity<>(auction,HttpStatus.OK); 
	}
	
	
	@GetMapping
	public ResponseEntity<?> BidList(HttpServletRequest request){
		
		token = request.getHeader("access_token");
		
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(7, token.length());
		}
		
		
		String o_username = JwtUtils.getUserEmailFromToken(token);
		
		Bid_request bid_r= new Bid_request();
		bid_r.setO_username(o_username);
		bid_r.setSale(0);

		List<Auction> bidlist_ing =offerService.BidList(bid_r);
		
		
		
		
		
		bid_r.setSale(2);
		List<Auction> bidlist_end =offerService.BidList(bid_r);
		
		
		List<Auction> paylist = paymentService.PayList(o_username);
		
		
		Map<String, Object> map= new HashMap<>();
		map.put("bidlist_ing",bidlist_ing);
		map.put("bidlist_end", bidlist_end);
		map.put("paylist", paylist);
		

		//logger.info("paylist"+paylist);
		//logger.info("bidlist_ing:"+bidlist_ing);
		//logger.info("bidlist_end:"+bidlist_end);
		return new ResponseEntity<>( map, HttpStatus.OK);
	}
	
	@GetMapping("/{a_num}")
	public ResponseEntity<?> BidDetail(@PathVariable("a_num") int a_num){
		
		Auction auction = auctionService.AucDetail(a_num);
		logger.info("biddetail:"+auction);
		
		return new ResponseEntity<>(auction, HttpStatus.OK);
		
	}
	@DeleteMapping("/{o_num}/{a_num}")
	public ResponseEntity<?> DeleteOffer(@PathVariable("o_num") int o_num, @PathVariable("a_num") int a_num){
		
		offerService.DeleteOffer(o_num);
		Auction auction = auctionService.AucDetail(a_num);
		
		
		
		return new ResponseEntity<>(auction, HttpStatus.OK);
	}
	
	
	
	@Scheduled(cron="0/10 * * * * *")
	public void SelectOffer() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		String today = form.format(new Date());
		
//		if(today != null) {
//			logger.info(today);
//			
//			offerService.SelectOffer(today);
//		}
	}
	
	
	

}