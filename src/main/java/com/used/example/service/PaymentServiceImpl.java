package com.used.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Amount;
import com.used.example.domain.Auction;
import com.used.example.domain.Card;
import com.used.example.domain.Chat;
import com.used.example.domain.KaKaoReady;
import com.used.example.domain.KakaoAmount;
import com.used.example.domain.KakaoApproval;
import com.used.example.domain.KakaoCardInfo;
import com.used.example.domain.Payment;
import com.used.example.domain.Product;
import com.used.example.mapper.AuctionMapper;
import com.used.example.mapper.ChatMapper;
import com.used.example.mapper.PaymentMapper;
import com.used.example.mapper.ProcessMapper;
import com.used.example.mapper.TurnOverMapper;





@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	PaymentMapper paymentMapper;
	
	
	@Autowired
	AuctionMapper auctionMapper;
	
	@Autowired
	ChatMapper chatMapper;
	
	@Autowired
	ProcessMapper processMapper;
	
	
	
	
	

	@Override
	public Map<String, Object> PaymentDetail(int a_num) { 
		
		Map<String , Object> map = new HashMap<>();
		Payment paydetail = paymentMapper.PaymentDetail(a_num);
		Auction aucdetail = auctionMapper.AucDetail(a_num);
		Chat chatdetail = null;
		if(paydetail != null & aucdetail != null) {
			String buyer = paydetail.getPa_username();
			String seller = aucdetail.getA_username();
			chatdetail = chatMapper.ChatDetail(buyer,seller);
		}		
		map.put("paydetail", paydetail);
		map.put("aucdetail", aucdetail);
		map.put("chatdetail", chatdetail);
		
		

		return map;
	}

	@Override
	public List<Auction> PayList(String o_username) {
		return paymentMapper.PayList(o_username);
	}

	@Override
	public void CreatePayment(Payment payment) {
		paymentMapper.CreatePayment(payment);
		
	}

	@Override
	public List<KaKaoReady> SelectPaymenet(String today) {
		return paymentMapper.SelectPaymenet(today);
	}

	@Override
	public void CreateCard(Card card) {
		paymentMapper.CreateCard(card);
		
	}

	@Override
	public void CreateAmount(Amount amount) {
		paymentMapper.CreateAmount(amount);
		
	}

	@Override
	public void PayStep(Payment payment) {
		paymentMapper.PayStep(payment);
		
	}

	@Override
	public void ProcessUp(int a_num) {
		 processMapper.ProcessUp(a_num);
		
	}
	
	
	

}
