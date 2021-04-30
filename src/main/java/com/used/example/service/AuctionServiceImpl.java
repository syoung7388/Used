package com.used.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Address;
import com.used.example.domain.Auc_Pro;
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
	public void AucDelete(int a_num) {
		auctionMapper.AucDelete(a_num);
		
	}

	@Override
	public void AuctionEnd(String today) {
		auctionMapper.AuctionEnd(today);
		
	}

	@Override
	public void createPayment() {
		auctionMapper.createPayment();
		
	}


	@Override
	public void CreateAP(Auc_Pro ap) {
		auctionMapper.CreateAP(ap);
		
	}

	@Override
	public void CreateAddress(Address address) {
		auctionMapper.CreateAddress(address);
		
	}

	@Override
	public List<Auction> SaleList(Auction auction) {
		return auctionMapper.SaleList(auction);
	}

	@Override
	public Auction AucDetail( int a_num) {
		return auctionMapper.AucDetail(a_num);
	}

	@Override
	public void AucEdit(Auction auction) {
		 auctionMapper.AucEdit(auction);
		
	}

	@Override
	public List<Auction> TopList(Address address) {
		return auctionMapper.TopList(address);
	}

	@Override
	public List<Auction> IndustryList(String lat, String lon, String industry) {
		return auctionMapper.IndustryList(lat, lon, industry);
	}

	@Override
	public List<Auction> KindList(String lat, String lon, String kind) {
		return auctionMapper.KindList(lat, lon, kind);
	}



}
