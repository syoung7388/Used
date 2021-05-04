package com.used.example.domain;


public class KakaoCardInfo {

	private long bin;
	private String card_type;
	private String install_month;
	private long approved_id;
	private String card_mid;
	private String interest_free_install;
	
	public long getBin() {
		return bin;
	}
	public void setBin(long bin) {
		this.bin = bin;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getInstall_month() {
		return install_month;
	}
	public void setInstall_month(String install_month) {
		this.install_month = install_month;
	}
	public long getApproved_id() {
		return approved_id;
	}
	public void setApproved_id(long approved_id) {
		this.approved_id = approved_id;
	}
	public String getCard_mid() {
		return card_mid;
	}
	public void setCard_mid(String card_mid) {
		this.card_mid = card_mid;
	}
	public String getInterest_free_install() {
		return interest_free_install;
	}
	public void setInterest_free_install(String interest_free_install) {
		this.interest_free_install = interest_free_install;
	}

	@Override
	public String toString() {
		return "KakaoCardInfo [bin=" + bin + ", card_type=" + card_type + ", install_month=" + install_month
				+ ", approved_id=" + approved_id + ", card_mid=" + card_mid + ", interest_free_install="
				+ interest_free_install + "]";
	}

	

}
