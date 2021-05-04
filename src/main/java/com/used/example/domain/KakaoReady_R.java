package com.used.example.domain;

public class KakaoReady_R {
	private String tid;
	private String next_redirect_pc_url;
	private String k_token;

	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getNext_redirect_pc_url() {
		return next_redirect_pc_url;
	}
	public void setNext_redirect_pc_url(String next_redirect_pc_url) {
		this.next_redirect_pc_url = next_redirect_pc_url;
	}
	public String getK_token() {
		return k_token;
	}
	public void setK_token(String k_token) {
		this.k_token = k_token;
	}
	@Override
	public String toString() {
		return "KakaoReady_R [tid=" + tid + ", next_redirect_pc_url=" + next_redirect_pc_url + ", k_token=" + k_token
				+ "]";
	}
	

}
