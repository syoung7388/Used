package com.used.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.Chat;

@Mapper
public interface ChatMapper {

	public void CreateChat(Chat chat);

	public Chat ChatDetail(int a_num);

	public List<Chat> ChatList(String username);

	public Chat MsgDetail(int ch_num);



}
