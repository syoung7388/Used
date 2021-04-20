package com.used.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Auction;
import com.used.example.mapper.AuctionMapper;



@Service
public class AuctionServiceImpl implements AuctionService {
	
	
	@Autowired
	AuctionMapper auctionMapper;

	@Override
	public void CreateAuction(Auction auction) {
		auctionMapper.CreateAuction(auction);
		
	}

}
