package com.used.example.controller;

import java.util.ArrayList;


import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.used.example.domain.User;
import com.used.example.domain.UserInfo;
import com.used.example.response.JwtResponse;
import com.used.example.service.UserService;
import com.used.example.config.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController{
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    
    
    @Autowired
    UserService userService;
    
    @Autowired
    JwtUtils jwtUtils;
    
    @Autowired
    AuthenticationManager authenticationManager;
    

 
    
    
    
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
	


		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> Signup(@RequestBody User user){
		
		String encodedPassword= new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.setisAccountNonExpired(true);
		user.setisAccountNonLocked(true);
		user.setisCredentialsNonExpired(true);
		user.setisEnabled(true);
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
		
	    userService.createUser(user);
	    userService.createAuthority(user);
	    
		
		return new ResponseEntity<>("success", HttpStatus.OK);
		
	}
	//로그인
	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody User user){
		logger.info("넘어온 값" +user);
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())); // AuthenticationManager 에 token 을 넘기면 UserDetailsService 가 받아 처리하도록 한다.

		SecurityContextHolder.getContext().setAuthentication(authentication);  // 실제 SecurityContext 에 authentication 정보를 등록한다.

		
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		user= (User) authentication.getPrincipal();
		logger.info("authentication.getPrincipal():"+ authentication.getPrincipal());
		logger.info("authentication.getPrincipal():"+ authentication.getPrincipal());
		
		List<String> roles= user.getAuthorities().stream()
								.map(item -> item.getAuthority())
								.collect(Collectors.toList());
		
		logger.debug("debug");
	    logger.info("info");
	    logger.error("error");



		
		return ResponseEntity.ok(new JwtResponse(jwt,
													user.getUsername(),
													user.getName(),
													roles));
	}
	
	//로그인으로 받은 토큰으로 정보 빼오기
	@GetMapping("/unpackToken")
	public ResponseEntity<?> unpackToken(HttpServletRequest request){
		
		String token= new String();
		token= request.getHeader("access_token");
		
		if(StringUtils.hasText(token)&& token.startsWith("Bearer")) {
			token= token.substring(7, token.length());
		}
		
		String username= JwtUtils.getUserEmailFromToken(token);
		
		UserInfo user= userService.readUser_token(username);
		
		user.setAuthorities(userService.readAuthorities_token(username));
		logger.info("readUser_token:"+user);
		
		return new ResponseEntity<>( user, HttpStatus.OK);
		
	}
	@PostMapping("/edit")
	public ResponseEntity<?> UserEdit(@RequestBody User user){
		
		userService.UserEidt(user);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	@ResponseBody
	@DeleteMapping("/delete/{username}")
	public ResponseEntity<?> UserDelete(@PathVariable("username") String username){
		
		
		userService.UserDelete(username);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
		
	}
	
	
	
	
}
