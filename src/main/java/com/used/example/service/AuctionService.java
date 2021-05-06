package com.used.example.service;

import java.util.List;
import java.util.Map;

import com.used.example.domain.Address;
import com.used.example.domain.Auc_Pro;
import com.used.example.domain.Auction;
import com.used.example.domain.Product;


public interface AuctionService {

	public void CreateAuction(Auction auction);

	public List<Product> AuctionList(Product product);

	public void AucDelete(int a_num);


	public void createPayment();

	public void CreateAP(Auc_Pro ap);

	public void CreateAddress(Address address);

	public List<Auction> SaleList(Auction auction);

	public Auction AucDetail(int a_num);

	public void AucEdit(Auction auction);

	
	public List<Auction> IndustryList(String lat, String lon, String industry);

	public List<Auction> KindList(String lat, String lon, String kind);

	public void Hits(int a_num);

	public void AucEnd(int a_num);


	public int Count(Map<String, Object> map);

	public List<Auction> TopList(Map<String, Object> map);

	

	;
}
