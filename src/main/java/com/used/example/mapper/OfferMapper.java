package com.used.example.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.used.example.domain.Auction;
import com.used.example.domain.Count;
import com.used.example.domain.KindRate;
import com.used.example.domain.Offer;
import com.used.example.domain.Offer_req;

@Mapper
public interface OfferMapper {

	public void CreateOffer(Offer offer);

	public List<Auction> OfferList(Offer_req bid_r);

	public void DeleteOffer(int o_num);

	public void SelectOffer(Offer offer);

	public Count OfferCount(String o_username);

	public int OfferRank(String o_username);

	public List<KindRate> KindCount(String o_username);

	public void CheckPay(Offer offer);



}
