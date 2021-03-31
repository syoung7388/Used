package com.used.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.used.example.domain.User;
import com.used.example.service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController{
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    
    
    @Autowired
    UserService userService;
    
    
	//회원가입 인증 메세지 보내기
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
		user.setNumStr(numStr);
//		userService.certifiedPhoneNumber(phoneNumber, numStr);
		
		//ArrayList<User> list= new ArrayList<User>();
		//list.add(user);
		

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	//프론트에서 회원가입 정보 받아서 DB저장
	@PostMapping("/signup")
	public ResponseEntity<?> Signup(@RequestBody User user){
		
		String encodedPassword= new BCryptPasswordEncoder().encode(user.getPassword());
		//Q joinrequest란?
		user.setPassword(encodedPassword);
		user.setisAccountNonExpired(true);
		user.setisAccountNonLocked(true);
		user.setisCredentialsNonExpired(true);
		user.setisEnabled(true);
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
		
	    userService.createUser(user);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
		
	}
}
