package com.used.example.domain;

public class KakaoApproval {
	private  String aid;
	private String tid;
	private String cid;
	private String sid;
	private String partner_order_id; // a_num
	private String partner_user_id; // o_username
	private String payment_method_type; 
	private KakaoAmount amount; // o_price
	private KakaoCardInfo card_info; 
	private String item_name; // kind
	private int item_code;//p_num
	private int quantity;
	private String approved_at;
	

}
