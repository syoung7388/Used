package com.used.example.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.used.example.config.JwtUtils;
import com.used.example.domain.Auction;
import com.used.example.domain.Offer;
import com.used.example.domain.Offer_req;
import com.used.example.service.OfferService;
import com.used.example.service.ProcessService;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/process")
public class ProcessController {//숫자의 기준은 어떻게 a_sale이 변할 것 인가? =>  process/0: 지불을 안해서 다시 돌아가는 단계 & process/1: 입찰선택단계 	& 지불완료단계(PaymentController에서 바로 호출함) & process/3: 경매 완료 
	
	
	@Autowired
	ProcessService processService;
	@Autowired
	OfferService offerService;
	
	String token;
	
	
	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	
	
	@Secured({"ROLE_USER"})
	@PutMapping("/0")
	public ResponseEntity<?> SkipOffer(@RequestBody Offer offer){		
		List<Auction> list = processService.SkipOffer(offer);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	
	@Secured({"ROLE_USER"})
	@PutMapping("/1") 
	public ResponseEntity<?> SelectOffer(@RequestBody Offer offer){
		processService.SelectOffer(offer);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	
	
	@Secured({"ROLE_USER"})
	@PutMapping("/3")
	public ResponseEntity<?> AucEnd(@RequestBody Auction auction,  HttpServletRequest request){
		

		
		
		token = request.getHeader("access_token");		
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(6, token.length());
		}
		String o_username = JwtUtils.getUserEmailFromToken(token);
		
		List<Auction> list= processService.AucEnd(o_username ,auction.getA_num());
		
		logger.info("list:"+list);
		

		
		return new ResponseEntity<> (list, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	

}
