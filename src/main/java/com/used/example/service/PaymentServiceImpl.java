package com.used.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Auction;
import com.used.example.domain.KaKaoReady;
import com.used.example.domain.KakaoAmount;
import com.used.example.domain.KakaoApproval;
import com.used.example.domain.KakaoCardInfo;
import com.used.example.domain.Product;
import com.used.example.mapper.PaymentMapper;





@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	PaymentMapper paymentMapper;

	@Override
	public Product PaymentDetail(int p_num) {
		return paymentMapper.PaymentDetail(p_num);
	}

	@Override
	public List<Auction> PayList(String o_username) {
		return paymentMapper.PayList(o_username);
	}

	@Override
	public void CreatePayment(KakaoApproval approval) {
		paymentMapper.CreatePayment(approval);
		
	}

	@Override
	public List<KaKaoReady> SelectPaymenet(String today) {
		return paymentMapper.SelectPaymenet(today);
	}

	@Override
	public void CreateCard(KakaoCardInfo cardInfo) {
		paymentMapper.CreateCard(cardInfo);
		
	}

	@Override
	public void CreateAmount(KakaoAmount amount) {
		paymentMapper.CreateAmount(amount);
		
	}
	
	
	

}
