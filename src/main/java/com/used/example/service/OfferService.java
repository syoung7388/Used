package com.used.example.service;

import java.util.List;


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

	public Count BidCount(String o_username);

	public int BidRank(String o_username);

	public List<KindRate> KindCount(String o_username);

	public void CheckPay(Offer offer);

	


}
