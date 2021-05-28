package com.used.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.used.example.domain.User;
import com.used.example.domain.UserInfo;
import com.used.example.mapper.UserMapper;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	//전화번호 문자인증
	@Override
	public void certifiedPhoneNumber(String phoneNumber, String cerNum) {
		
		String api_key= "NCS5GW8B7QDXQERY";
		String api_secret="FBJNABLR68IVRK5LM5JTBIP5MUMK9AVA";
		Message coolsms= new Message(api_key, api_secret);
		HashMap<String, String> params= new HashMap<String, String>();
		params.put("to", phoneNumber);
		params.put("from", "01083747388");
		params.put("type", "SMS");
		params.put("text", "[Used]인증문자는"+"["+cerNum+"]"+"입니다");
		params.put("app_version", "test app 1.2");
		
		
		try {
			JSONObject obj= (JSONObject)coolsms.send(params);
			System.out.println(obj.toString());
		}catch (CoolsmsException e) {
            System.out.println("문자인증오류:"+e.getMessage());
            System.out.println("문자인증오류:"+e.getCode());
		}
		
	}
		


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userMapper.readUser(username);
		user.setAuthorities(getAuthorities(username));
		System.out.println("UserServiceImpl_loadUserByUsername:"+user.getAuthorities());
		
		return user;
	}
	
	
	@Override
	public Collection<GrantedAuthority> getAuthorities(String username){
		List <GrantedAuthority> authorities= userMapper.readAuthorities(username);
		return authorities;
	}




	@Override
	public UserInfo readUser_token(String username) {
		return userMapper.readUser_token(username);
		
	}


	@Override
	public Collection<? extends GrantedAuthority> readAuthorities_token(String username) {
		
		return userMapper.readAuthorities_token(username);
	}


	@Override
	public void UserEidt(User user) {
		userMapper.UserEdit(user);
		
	}

//	@Override
//	public void AuthEdit(User user) {
//		userMapper.AuthEdit(user);
//		
//	}


	@Override
	public void UserDelete(String username) {
		userMapper.UserDelete(username);
		
	}


	@Override
	public Map<String, Integer> Check(User user) {
		return userMapper.Check(user);
	}



	@Override
	public void SignUp(User user) {
		

		
		
		String encodedPassword= new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.setisAccountNonExpired(true);
		user.setisAccountNonLocked(true);
		user.setisCredentialsNonExpired(true);
		user.setisEnabled(true);
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
		
	    userMapper.createUser(user);
	    userMapper.createAuthority(user);

	}


}
