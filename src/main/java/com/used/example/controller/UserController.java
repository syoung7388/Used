package com.used.example.controller;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.core.userdetails.UserDetails;

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
    
    String token;

	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("/unpackToken")
	public ResponseEntity<?> unpackToken(HttpServletRequest request){
		
		
		token= request.getHeader("access_token");
		if(StringUtils.hasText(token)&& token.startsWith("Bearer")) {
			token= token.substring(6, token.length());
			logger.info(token);
		}
		String username= JwtUtils.getUserEmailFromToken(token);
		UserDetails userdetails = userService.loadUserByUsername(username);
		
		logger.info("userdetails"+userdetails);

	
		return new ResponseEntity<>(userdetails , HttpStatus.OK);
		
	}
	
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@PostMapping("/edit")
	public ResponseEntity<?> UserEdit(@RequestBody User user, HttpServletRequest request){	
	
		
		userService.UserEidt(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@ResponseBody
	@DeleteMapping("/{username}")
	public ResponseEntity<?> UserDelete(@PathVariable("username") String username, HttpServletRequest request){
		
		
		userService.UserDelete(username);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
		
	}
	
	
	
	
}
