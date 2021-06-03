package com.used.example.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.used.example.service.TurnOverService;

@CrossOrigin(origins="*" , maxAge=3600)
@RestController
@RequestMapping("api/turnover")
public class TurnOverController {
	
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
		
	
	
	@Autowired
	TurnOverService turnoverService;

	
	@GetMapping
	public ResponseEntity<?> getTurnOverInfo(){
	
		Map<String, Object> map  = turnoverService.getTurnOverInfo();
		
		
		
		return new ResponseEntity<>(map, HttpStatus.OK);
		
		
	}
	
	
	
}
