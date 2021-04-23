package com.used.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.used.example.domain.Like;
import com.used.example.service.LikeService;



@CrossOrigin(origins="*", maxAge= 3600)
@RestController
@RequestMapping("/api/like")
public class LikeController {
	
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String token;
	
	@Autowired
	LikeService likeService;
	
	
	@PostMapping
	public ResponseEntity<?> CreateLike(@RequestBody Like like){

		likeService.CreateLike(like);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}


}
