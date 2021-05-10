package com.used.example.domain;

public class Message {
	
	private int m_num;
	private int ch_num;
	private String m_username;
	private String content;
	private String time;
	
	
	
	
	
	public int getM_num() {
		return m_num;
	}





	public void setM_num(int m_num) {
		this.m_num = m_num;
	}





	public int getCh_num() {
		return ch_num;
	}





	public void setCh_num(int ch_num) {
		this.ch_num = ch_num;
	}





	public String getM_username() {
		return m_username;
	}





	public void setM_username(String m_username) {
		this.m_username = m_username;
	}





	public String getContent() {
		return content;
	}





	public void setContent(String content) {
		this.content = content;
	}





	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "Message [m_num=" + m_num + ", ch_num=" + ch_num + ", m_username=" + m_username + ", content=" + content
				+ ", time=" + time + "]";
	}
	
	
	
	
}
