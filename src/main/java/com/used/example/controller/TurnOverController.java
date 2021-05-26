package com.used.example.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import com.used.example.domain.TurnOver;
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
		
		Date date = new Date();
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		String year = yearFormat.format(date);
		
		List<TurnOver> list = turnoverService.getTurnOverInfo(year);
		
		
		List<String> month = new ArrayList<>();
		List<Long> amount = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			month.add(list.get(i).getMonth() +"월");
			amount.add(list.get(i).getAmount());
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("month", month);
		map.put("amount", amount);
		logger.info("map"+map);
		
		return new ResponseEntity<>(map, HttpStatus.OK);
		
		
	}
	
	
	
}
