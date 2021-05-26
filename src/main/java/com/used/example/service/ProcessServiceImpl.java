package com.used.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Offer;
import com.used.example.mapper.ProcessMapper;

@Service
public class ProcessServiceImpl implements ProcessService{
	
	@Autowired
	ProcessMapper processMapper;
	
	
	@Override
	public void SelectOffer(Offer offer) {	
		processMapper.SelectOffer(offer);
	}


	@Override
	public void ProcessUp(int a_num) {
		processMapper.ProcessUp(a_num);
		
	}


	@Override
	public void SkipOffer(Offer offer) {
		processMapper.SkipOffer(offer);
		
	}

}
