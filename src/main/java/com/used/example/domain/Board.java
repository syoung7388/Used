package com.used.example.domain;

import java.util.ArrayList;

public class Board {
	
	private int b_num;
	private String title;
	private String content;
	private String writer;
	private int bTime;// 게시뮬  작성시간


	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getbTime() {
		return bTime;
	}
	public void setbTime(int bTime) {
		this.bTime = bTime;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}


}
