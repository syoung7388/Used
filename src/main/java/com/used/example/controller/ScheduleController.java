package com.used.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.used.example.domain.Product;
import com.used.example.service.AuctionService;
import com.used.example.service.ProductService;






@Controller
public class ScheduleController {
	
	
	
	
	@Autowired
	AuctionService auctionService;
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	
	
	
	@Scheduled(cron = "0/10 * * * * *")
	public void AuctionEnd() {
		
		
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		String today = form.format(new Date());
		
		if(today != null) {
			
			auctionService.AuctionEnd(today);
			
			auctionService.createPayment();
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		

	}

}
