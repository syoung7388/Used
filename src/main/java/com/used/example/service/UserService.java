package com.used.example.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.used.example.domain.User;

public interface UserService extends UserDetailsService {
	
	public void certifiedPhoneNumber(String phoneNumber, String cerNum);
	public void createUser(User user);

}
