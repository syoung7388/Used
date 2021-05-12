package com.used.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Amount;
import com.used.example.domain.Auction;
import com.used.example.domain.Card;
import com.used.example.domain.KaKaoReady;
import com.used.example.domain.KakaoAmount;
import com.used.example.domain.KakaoApproval;
import com.used.example.domain.KakaoCardInfo;
import com.used.example.domain.Payment;
import com.used.example.domain.Product;
import com.used.example.mapper.PaymentMapper;





@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	PaymentMapper paymentMapper;

	@Override
	public Payment PaymentDetail(int a_num) {
		return paymentMapper.PaymentDetail(a_num);
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
	
	
	

}
