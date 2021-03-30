package com.used.example.controller;

import java.util.Random;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.used.example.domain.User;

import com.used.example.service.certificationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sms")
public class UserAPIController{
	

	certificationService certificationService= new certificationService();
	
	@ResponseBody 
	@PostMapping("/sendSMS")
	public ResponseEntity<?> sendSMS(@RequestBody User user ) {
		
		String phoneNumber= user.getPhone();
		Random rand= new Random();
		String numStr="";
		for(int i=0; i<4; i++) {
			String ran= Integer.toString(rand.nextInt(10));
			numStr += ran;
		}
		
		System.out.println("폰번호:"+ phoneNumber);
		System.out.println("인증번호:"+numStr);
//		certificationService.certifiedPhoneNumber(phoneNumber, numStr);
		
		return new ResponseEntity<>(numStr, HttpStatus.OK);
	}
}
