package com.used.example.service;

import java.util.List;

import com.used.example.domain.Auction;
import com.used.example.domain.Offer;

public interface ProcessService {

	public void SelectOffer(Offer offer);

	public List<Auction> SkipOffer(Offer offer);

	public List<Auction> AucEnd(String o_username, int a_num);

}
