package com.used.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Auction;
import com.used.example.domain.Offer;
import com.used.example.domain.Offer_req;
import com.used.example.mapper.OfferMapper;
import com.used.example.mapper.ProcessMapper;

@Service
public class ProcessServiceImpl implements ProcessService{
	
	@Autowired
	ProcessMapper processMapper;
	
	@Autowired
	OfferMapper offerMapper;
	
	
	@Override
	public void SelectOffer(Offer offer) {	
		processMapper.SelectOffer(offer);
		processMapper.ProcessUp(offer.getA_num()); //a_sale = 1
	}


//	@Override
//	public void ProcessUp(int a_num) {
//		processMapper.ProcessUp(a_num);
//		
//	}


	@Override
	public List<Auction> SkipOffer(Offer offer) {
	
		processMapper.SkipOffer(offer);
		
		Offer_req or = new Offer_req();
		or.setO_username(offer.getO_username());
		or.setSale(1);
		List<Auction> list = offerMapper.OfferList(or);
		
		return list;
		
		
	}


	@Override
	public List<Auction> AucEnd(String o_username, int a_num){
		
		
		processMapper.ProcessUp(a_num);
		
		Offer_req or = new Offer_req();
		or.setO_username(o_username);
		or.setSale(2);
		
		List<Auction> list =offerMapper.OfferList(or);
		return list;
	
	}

}
