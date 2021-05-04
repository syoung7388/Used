package com.used.example.domain;

public class KakaoApproval {
	private  String aid;
	private String tid;
	private String cid;
	private String sid;
	private int partner_order_id; // a_num
	private String partner_user_id; // o_username
	private String payment_method_type; 
	private KakaoAmount amount; // o_price
	private KakaoCardInfo card_info; 
	private String item_name; // kind
	private int item_code;//p_num
	private int quantity;
	private String approved_at;
	@Override
	public String toString() {
		return "KakaoApproval [aid=" + aid + ", tid=" + tid + ", cid=" + cid + ", sid=" + sid + ", partner_order_id="
				+ partner_order_id + ", partner_user_id=" + partner_user_id + ", payment_method_type="
				+ payment_method_type + ", amount=" + amount + ", card_info=" + card_info + ", item_name=" + item_name
				+ ", item_code=" + item_code + ", quantity=" + quantity + ", approved_at=" + approved_at + "]";
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getPartner_order_id() {
		return partner_order_id;
	}
	public void setPartner_order_id(int partner_order_id) {
		this.partner_order_id = partner_order_id;
	}
	public String getPartner_user_id() {
		return partner_user_id;
	}
	public void setPartner_user_id(String partner_user_id) {
		this.partner_user_id = partner_user_id;
	}
	public String getPayment_method_type() {
		return payment_method_type;
	}
	public void setPayment_method_type(String payment_method_type) {
		this.payment_method_type = payment_method_type;
	}
	public KakaoAmount getAmount() {
		return amount;
	}
	public void setAmount(KakaoAmount amount) {
		this.amount = amount;
	}
	public KakaoCardInfo getCard_info() {
		return card_info;
	}
	public void setCard_info(KakaoCardInfo card_info) {
		this.card_info = card_info;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_code() {
		return item_code;
	}
	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getApproved_at() {
		return approved_at;
	}
	public void setApproved_at(String approved_at) {
		this.approved_at = approved_at;
	}
	


}
