package com.used.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.Chat;

@Mapper
public interface ChatMapper {

	public void CreateChat(Chat chat);

	public Chat ChatDetail(int a_num);

}
