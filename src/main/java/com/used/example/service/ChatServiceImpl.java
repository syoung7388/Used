package com.used.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Chat;
import com.used.example.mapper.ChatMapper;

@Service
public class ChatServiceImpl implements ChatService {
	
	
	
	@Autowired
	ChatMapper chatMapper;

	@Override
	public void CreateChat(Chat chat) {
		chatMapper.CreateChat(chat);
		
	}

	@Override
	public Chat ChatDetail(int a_num) {
		return chatMapper.ChatDetail(a_num);
	}

}
