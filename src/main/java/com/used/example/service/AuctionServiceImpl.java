package com.used.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Auction;
import com.used.example.domain.Product;
import com.used.example.mapper.AuctionMapper;



@Service
public class AuctionServiceImpl implements AuctionService {
	
	
	@Autowired
	AuctionMapper auctionMapper;

	@Override
	public void CreateAuction(Auction auction) {
		auctionMapper.CreateAuction(auction);
		
	}

	@Override
	public List<Product> AuctionList(Product product) {
		return auctionMapper.AuctionList(product);
	}

	@Override
	public Product AuctionDetail(int p_num) {
		return auctionMapper.AuctionDetail(p_num);
	}

	@Override
	public void AuctionDelete(int a_num) {
		auctionMapper.AuctionDelete(a_num);
		
	}

	@Override
	public void AuctionEnd(String today) {
		auctionMapper.AuctionEnd(today);
		
	}

	@Override
	public void createPayment() {
		auctionMapper.createPayment();
		
	}


}
