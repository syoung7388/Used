package com.used.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.used.example.config.JwtUtils;
import com.used.example.domain.Product;
import com.used.example.service.PaymentService;


@CrossOrigin(origins="*", maxAge= 3600)
@RestController
@RequestMapping("api/payment")
public class PaymentController {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String token;
	
	
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/{p_num}")
	public ResponseEntity<?> PaymentDetail(@PathVariable("p_num")int p_num , HttpServletRequest request){
		
		token= request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer") ) {
			token = token.substring(7, token.length());
		}
		
		String username =JwtUtils.getUserEmailFromToken(token);
		
		if(username == null) {
			return new ResponseEntity<>("error",HttpStatus.OK);
		}else {
			
			
			Product product = paymentService.PaymentDetail(p_num);
			
			
			logger.info("product:"+product);
			
			
			
			
			
			
			
			//logger.info("p_num:"+p_num+"/username:"+username);
			return  new ResponseEntity<>(product, HttpStatus.OK);
			
		}
		
		
		
	}

}
