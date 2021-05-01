package com.used.example.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.used.example.domain.User;
import com.used.example.domain.UserInfo;


@Mapper
public interface UserMapper {



	public void createUser(User user);

	public void createAuthority(User user);

	public List<GrantedAuthority> readAuthorities(String username);

	public User readUser(String username);

	public UserInfo readUser_token(String username);

	public Collection<? extends GrantedAuthority> readAuthorities_token(String username);

	public void UserEdit(User user);
//	public void AuthEdit(int u_num);

	public void UserDelete(String username);

	public Map<String, Integer> Check(User user);

	
	

}
