package com.used.example.domain;



public class WebSocket {
	
	private String username;
	private String content;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "WebSocket [username=" + username + ", content=" + content + "]";
	}
	

}
