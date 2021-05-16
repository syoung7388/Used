package com.used.example.domain;

public class Account {
	
	
	private String sj_div; // 재무제표구분
	private String sj_nm; // 재무제표명
	private String  account_nm; // 계정명
	private String thstrm_nm; //당기명
	private long thstrm_amount;

	public String getSj_div() {
		return sj_div;
	}
	public void setSj_div(String sj_div) {
		this.sj_div = sj_div;
	}
	public String getSj_nm() {
		return sj_nm;
	}
	public void setSj_nm(String sj_nm) {
		this.sj_nm = sj_nm;
	}
	public String getAccount_nm() {
		return account_nm;
	}
	public void setAccount_nm(String account_nm) {
		this.account_nm = account_nm;
	}
	public String getThstrm_nm() {
		return thstrm_nm;
	}
	public void setThstrm_nm(String thstrm_nm) {
		this.thstrm_nm = thstrm_nm;
	}
	public long getThstrm_amount() {
		return thstrm_amount;
	}
	public void setThstrm_amount(long thstrm_amount) {
		this.thstrm_amount = thstrm_amount;
	}
	@Override
	public String toString() {
		return "Account [sj_div=" + sj_div + ", sj_nm=" + sj_nm + ", account_nm=" + account_nm + ", thstrm_nm="
				+ thstrm_nm + ", thstrm_amount=" + thstrm_amount + "]";
	}
	
	
	
	
	
	
	

	
	
	
	

}
