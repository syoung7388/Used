package com.used.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.used.example.domain.Address;
import com.used.example.domain.Auc_Pro;
import com.used.example.domain.Auction;
import com.used.example.domain.Count;
import com.used.example.domain.Product;
import com.used.example.domain.MonthSum;
import com.used.example.domain.Pagination;
import com.used.example.domain.Payment;
import com.used.example.mapper.AuctionMapper;
import com.used.example.mapper.PaymentMapper;



@Service
public class AuctionServiceImpl implements AuctionService {
	
	
	@Autowired
	AuctionMapper auctionMapper;
	
	@Autowired
	PaymentMapper paymentMapper;
	

	@Override
	public void CreateAuction(Auction auction) {
		auctionMapper.CreateAuction(auction);
		
	}

//	@Override
//	public List<Product> AuctionList(Product product) {
//		return auctionMapper.AuctionList(product);
//	}


	@Override
	public void AucDelete(int a_num) {
		auctionMapper.AucDelete(a_num);
		
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
		
		Auction auction  = auctionMapper.AucDetail(a_num);

		return auction;
	}

	@Override
	public void AucEdit(Auction auction) {
		 auctionMapper.AucEdit(auction);
		
	}



	@Override
	public void Hits(int a_num) {
		auctionMapper.Hits(a_num);
		
	}

	@Override
	public void AucStep(int a_num) {
		auctionMapper.AucStep(a_num);
		
	}


//	@Override
//	public int TotalCount(Map<String, Object> map) {
//		return auctionMapper.TotalCount(map);
//	}

	@Override
	public Map<String, Object> TopList(Map<String, Object> map) {
		
		Map<String, Object> topmap = new HashMap<>();
		List<Auction> toplist= auctionMapper.TopList(map);
		topmap.put("toplist", toplist);
		int page= (int) map.get("page");
		Pagination pagination = new Pagination();
		if(page == 0) {
			map.put("listsort", 0);
			int count = auctionMapper.TotalCount(map);
			pagination = new Pagination(count, page);
			topmap.put("pagination", pagination);
			
		}
		
		return topmap;
	}

	@Override
	public Map<String, Object> IndustryList(Map<String, Object> map) {
		Pagination pagination = new Pagination();
		
		List<Auction> industrylist = auctionMapper.IndustryList(map);
		
		Map<String ,Object> industrymap = new HashMap<>();
		industrymap.put("industrylist", industrylist);
		int page= (int) map.get("page");
		if(page == 0) {
			map.put("listsort", 1);
			int count = auctionMapper.TotalCount(map);
			pagination = new Pagination(count, page);
			industrymap.put("pagination", pagination);
			
		}
		return industrymap;
	}

	@Override
	public Map<String, Object> KindList(Map<String, Object> map) {
		Map<String ,Object> kindmap = new HashMap<>();
		Pagination pagination = new Pagination();
		
		List<Auction> kindlist = auctionMapper.KindList(map);
		kindmap.put("kindlist", kindlist);
		
		int page= (int) map.get("page");
		if(page == 0) {
			map.put("listsort", 2);
			int count = auctionMapper.TotalCount(map);
			pagination = new Pagination(count, page);
			kindmap.put("pagination", pagination);
			
		}
		
		
		return kindmap;
	}

//	@Override
//	public Count SaleCount(String username) {
//		return auctionMapper.SaleCount(username);
//	}

//	@Override
//	public List<MonthSum> SaleSum(String username) {
//		return auctionMapper.SaleSum(username);
//	}
	

	@Override
	public Map<String, Object> SaleStatistic(String username) {
		
		
		
		Map<String, Object> map = new HashMap<>();
		Count count = auctionMapper.SaleCount(username);
		
		List<MonthSum> sum = auctionMapper.SaleSum(username);
		
		List<String> month = new ArrayList<>();
		List<Long> total = new ArrayList<>();
		List<String> labels = new ArrayList<>();
		
		
		for(int i=0; i< sum.size(); i++) {
			month.add(sum.get(i).getMonth()+"월");
			total.add(sum.get(i).getTotal());
		}
		map.put("count", count);
		map.put("month", month);
		map.put("total", total);
		
		return map;
	}
	
	@Async
	@Override
	public Auction AucDelay(Auction auction) {
		
		auctionMapper.AucDelay(auction);
		
		return auctionMapper.AucDetail(auction.getA_num());
		
		
	}



}
