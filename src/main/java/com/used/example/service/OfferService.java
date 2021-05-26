package com.used.example.service;

import java.util.List;
import java.util.Map;

import com.used.example.domain.Auction;
import com.used.example.domain.Count;
import com.used.example.domain.KindRate;
import com.used.example.domain.Offer;
import com.used.example.domain.Offer_req;

public interface OfferService {

	public void CreateOffer(Offer offer);

	public List<Auction> OfferList(Offer_req or);

	public void DeleteOffer(int o_num);

	public void SelectOffer(Offer offer);

	public void CheckPay(Offer offer);

	public Map<String, Object> OfferStatistic(String o_username);

	


}
