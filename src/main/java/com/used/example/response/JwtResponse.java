package com.used.example.response;

import java.util.List;

public class JwtResponse {
	
	private String token;
	private String username; //email
	private String name; //별명
	private List<String> roles;
	private String type = "Bearer";
	
	
	
	public JwtResponse(String jwt, String u_username, String u_name, List<String> u_roles) {
		this.setToken(jwt);
		this.setUsername(u_username);
		this.setName(u_name);
		this.setRoles(u_roles);
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<String> getRoles() {
		return roles;
	}



	public void setRoles(List<String> roles) {
		this.roles = roles;
	}



	public String getType() {
		return type;
	}



	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", username=" + username + ", name=" + name + ", roles=" + roles
				+ ", type=" + type + "]";
	}
	
	


}
