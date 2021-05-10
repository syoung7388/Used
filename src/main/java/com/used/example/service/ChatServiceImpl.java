package com.used.example.service;

import java.util.List;

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

	@Override
	public List<Chat> ChatList(String username) {
		return chatMapper.ChatList(username);
		
	}

	@Override
	public Chat MsgDetail(int ch_num) {
		return chatMapper.MsgDetail(ch_num);
	}

}
