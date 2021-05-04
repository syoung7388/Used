package com.used.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Auction;
import com.used.example.domain.Bid_request;
import com.used.example.domain.Offer;
import com.used.example.mapper.OfferMapper;

@Service
public class OfferServiceImpl implements OfferService{
	
	
	@Autowired 
	OfferMapper offerMapper;

	@Override
	public void CreateOffer(Offer offer) {
		offerMapper.CreateOffer(offer);
		
	}

	@Override
	public List<Auction> BidList(Bid_request bid_r) {
		return offerMapper.BidList(bid_r);
	}

	@Override
	public void DeleteOffer(int o_num) {
		offerMapper.DeleteOffer(o_num);
		
		
	}

	@Override
	public void SelectOffer(String today) {
		offerMapper.SelectOffer(today);
		
	}



}