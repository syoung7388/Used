package com.used.example.controller;

import java.util.List;


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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.used.example.config.JwtUtils;
import com.used.example.domain.Auction;
import com.used.example.domain.Like;

import com.used.example.service.AuctionService;
import com.used.example.service.LikeService;




@CrossOrigin(origins="*", maxAge= 3600)
@RestController
@RequestMapping("/api/like")
public class LikeController {
	
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String token;
	
	@Autowired
	LikeService likeService;
	
	@Autowired
	AuctionService auctionService;
	
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@PostMapping
	public ResponseEntity<?> CreateLike(@RequestBody Like like, HttpServletRequest request){
		
		token = request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(6, token.length());
		}
		String l_username = JwtUtils.getUserEmailFromToken(token);
		like.setL_username(l_username);
		
		Auction auction=likeService.CreateLike(like);

		return new ResponseEntity<>( auction, HttpStatus.OK);
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@DeleteMapping("/{a_num}")
	public ResponseEntity<?> DeleteLike( @PathVariable("a_num") int a_num ,HttpServletRequest request){
		
		token = request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(6, token.length());
		}
		String l_username = JwtUtils.getUserEmailFromToken(token);
		
		Auction auction = likeService.DeleteLike(l_username, a_num);
	
		
		
		return new ResponseEntity<>( auction, HttpStatus.OK);
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/")
	public ResponseEntity<?> LikeList(HttpServletRequest request){
		
		token = request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(6, token.length());
		}
		String l_username = JwtUtils.getUserEmailFromToken(token);
		

		
		List<Auction> likelist =  likeService.LikeList(l_username);

		
		
		
		return new ResponseEntity<>(likelist, HttpStatus.OK);
	
		
		
		
		
	}


}
