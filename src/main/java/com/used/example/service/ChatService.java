package com.used.example.service;

import java.util.List;

import com.used.example.domain.Chat;
import com.used.example.domain.Message;

public interface ChatService {

	public void CreateChat(Chat chat);

	public List<Chat> ChatList(String username);

	public Chat MsgDetail(int ch_num);

	public void CreateMessage(Message message);

	public Chat ChatDetail(String buyer, String seller);

}
