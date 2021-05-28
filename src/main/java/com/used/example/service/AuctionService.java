package com.used.example.service;

import java.util.List;
import java.util.Map;

import com.used.example.domain.Address;
import com.used.example.domain.Auc_Pro;
import com.used.example.domain.Auction;
import com.used.example.domain.Count;
import com.used.example.domain.Product;
import com.used.example.domain.MonthSum;


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

	
	public Map<String, Object> IndustryList(Map<String, Object> map);

	public Map<String, Object> KindList(Map<String, Object> map);

	public void Hits(int a_num);

	public void AucStep(int a_num);


	public int TotalCount(Map<String, Object> map);

	public Map<String, Object> TopList(Map<String, Object> map);

	public Count SaleCount(String username);

	public List<MonthSum> SaleSum(String username);

	public Map<String, Object> SaleStatistic(String username);



	

	;
}
