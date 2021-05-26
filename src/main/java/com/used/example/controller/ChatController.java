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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.used.example.config.JwtUtils;
import com.used.example.domain.Chat;
import com.used.example.domain.Message;
import com.used.example.service.ChatService;


@CrossOrigin(origins="*", maxAge= 5000)
@RestController
@RequestMapping("/api/chat")
public class ChatController {
	
	@Autowired
	ChatService chatService;
	
	
	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	private String token;
	
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PostMapping
	public ResponseEntity<?> CreateChat(@RequestBody Chat chat){
		
		chatService.CreateChat(chat);
		
		logger.info("chat"+chat);
		return new ResponseEntity<>(chat, HttpStatus.OK);
		
		
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping
	public ResponseEntity<?> ChatList(HttpServletRequest request){
		token = request.getHeader("access_token");
		
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(6, token.length());
		}
		String username = JwtUtils.getUserEmailFromToken(token);
		
		 List<Chat> list = chatService.ChatList(username);
		 
		 return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/{ch_num}")
	public ResponseEntity<?> MsgDetail(@PathVariable("ch_num") int ch_num, HttpServletRequest request){
		
		Chat chat = chatService.MsgDetail(ch_num);
		
		return new ResponseEntity<>(chat, HttpStatus.OK);
		
	}
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PostMapping("/msg")
	public ResponseEntity<?> CreateMessage(@RequestBody Message message, HttpServletRequest request){
		token = request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(6, token.length());
		}
		String username = JwtUtils.getUserEmailFromToken(token);
		message.setM_username(username);
		
		logger.info("message:"+message);
		
		chatService.CreateMessage(message);
		
		
		
		return new ResponseEntity<>("success", HttpStatus.OK);
		
	}
	
	

}
