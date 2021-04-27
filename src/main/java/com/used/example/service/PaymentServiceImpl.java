package com.used.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	

}
