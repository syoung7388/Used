package com.used.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.used.example.domain.Chat;
import com.used.example.service.ChatService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins="*", maxAge= 5000)
@RestController
@RequestMapping("/api/chat")
public class ChatController {
	
	@Autowired
	ChatService chatService;
	
	
	@PostMapping
	public ResponseEntity<?> CreateChat(@RequestBody Chat chat){
		
		chatService.CreateChat(chat);
		int ch_num = chat.getCh_num();
		
		
		return new ResponseEntity<>(ch_num, HttpStatus.OK);
		
		
	}
	

}
