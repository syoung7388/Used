package com.used.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Auction;
import com.used.example.domain.Count;
import com.used.example.domain.KindRate;
import com.used.example.domain.Offer;
import com.used.example.domain.Offer_req;
import com.used.example.mapper.AuctionMapper;
import com.used.example.mapper.OfferMapper;

import ch.qos.logback.classic.Logger;

@Service
public class OfferServiceImpl implements OfferService{
	
	
	private final Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired 
	OfferMapper offerMapper;
	
	@Autowired 
	AuctionMapper auctionMapper;

	@Override
	public Auction CreateOffer(Offer offer) {
		offerMapper.CreateOffer(offer);
		
		int a_num = offer.getA_num();
		Auction auction = auctionMapper.AucDetail(a_num);
		
		return auction;
		
	}

	@Override
	public List<Auction> OfferList(Offer_req or) {
		return offerMapper.OfferList(or);
	}

	@Override
	public Auction DeleteOffer(int o_num, int a_num) {
		offerMapper.DeleteOffer(o_num);
		
		Auction auction = auctionMapper.AucDetail(a_num);
		
		return auction;
		
		
	}

	@Override
	public void SelectOffer(Offer offer) {
		offerMapper.SelectOffer(offer);
		
	}





	@Override
	public void CheckPay(Offer offer) {
		offerMapper.CheckPay(offer);
	}

	@Override
	public Map<String, Object> OfferStatistic(String o_username) {
		
		Map<String, Object> map = new HashMap<>();
		Count count = offerMapper.OfferCount(o_username);
		if(count.getSoldcount() != 0) {
			int rank = offerMapper.OfferRank(o_username);
			List <KindRate> kind_rate = offerMapper.KindCount(o_username);
			
			List<String> kind = new ArrayList<>();
			List<Integer> rate = new ArrayList<>();	
			for(int i=0; i<kind_rate.size(); i++) {
				kind.add( kind_rate.get(i).getKind());
				rate.add(kind_rate.get(i).getKindrate());	
			}
			map.put("kind",kind);
			map.put("rate", rate);
			map.put("rank", rank);
			map.put("count", count);
			
		}else {
			map.put("count", count);	
		}
		return map;
		
	}




}
