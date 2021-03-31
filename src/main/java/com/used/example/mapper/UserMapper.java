package com.used.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.used.example.domain.User;


@Mapper
public interface UserMapper {

	public void createUser(User user);

}
