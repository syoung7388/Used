package com.used.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.used.example.config.JwtUtils;
import com.used.example.domain.Auction;
import com.used.example.domain.Offer;
import com.used.example.domain.Payment;
import com.used.example.domain.Product;
import com.used.example.service.AuctionService;
import com.used.example.service.PaymentService;


@CrossOrigin(origins="*", maxAge= 3600)
@RestController
@RequestMapping("api/payment")
public class PaymentController {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String token;
	
	
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	AuctionService auctionService;
	
	
	
	
	@PostMapping
	public ResponseEntity<?> KakaoPay(@RequestBody Product product, Offer offer){
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	


}
