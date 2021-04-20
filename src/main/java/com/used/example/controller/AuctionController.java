package com.used.example.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.used.example.domain.Auction;
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
	public ResponseEntity<?> CreateAuction(@RequestBody Auction auction){
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
