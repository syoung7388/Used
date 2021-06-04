package com.used.example.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.used.example.domain.User;
import com.used.example.domain.UserInfo;

public interface UserService extends UserDetailsService {
	
	public void certifiedPhoneNumber(String phoneNumber, String cerNum);
	

	Collection<GrantedAuthority> getAuthorities(String username);

	public UserInfo readUser_token(String username);

	public Collection<? extends GrantedAuthority> readAuthorities_token(String username);

	public void UserEidt(User user);


	public void UserDelete(String username);

	public Map<String, Integer> Check(User user);

	public void SignUp(User user);



//	public void AuthEdit(User user);

}
