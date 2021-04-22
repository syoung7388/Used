package com.used.example.service;

import java.util.List;

import com.used.example.domain.Auction;
import com.used.example.domain.Product;


public interface AuctionService {

	public void CreateAuction(Auction auction);

	public List<Product> AuctionList(Product product);

	public Product AuctionDetail(int p_num);

}
