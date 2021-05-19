package com.used.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.used.example.domain.Chat;
import com.used.example.domain.Message;

@Mapper
public interface ChatMapper {

	public void CreateChat(Chat chat);

	public List<Chat> ChatList(String username);

	public Chat MsgDetail(int ch_num);

	public void CreateMessage(Message message);

	public Chat ChatDetail(@Param("buyer")String buyer,@Param("seller") String seller);



}
