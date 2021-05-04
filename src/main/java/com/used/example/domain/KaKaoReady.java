package com.used.example.domain;

public class KaKaoReady {
	private int a_num;
	private int o_num;
	private String o_username;
	private long price;
	private int p_num;
	private String kind;
	private KakaoReady_R kready_r;

	
	
	
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public String getO_username() {
		return o_username;
	}
	public void setO_username(String o_username) {
		this.o_username = o_username;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}

	public KakaoReady_R getKready_r() {
		return kready_r;
	}
	public void setKready_r(KakaoReady_R kready_r) {
		this.kready_r = kready_r;
	}
	@Override
	public String toString() {
		return "KaKaoReady [a_num=" + a_num + ", o_num=" + o_num + ", o_username=" + o_username + ", price=" + price
				+ ", p_num=" + p_num + ", kind=" + kind + ", kready_r=" + kready_r + "]";
	}

	


	
	

	
	
	

}
