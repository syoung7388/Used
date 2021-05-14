package com.used.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.used.example.domain.Auction;
import com.used.example.domain.Bid_request;
import com.used.example.domain.Count;
import com.used.example.domain.KindRate;
import com.used.example.domain.Offer;

@Mapper
public interface OfferMapper {

	public void CreateOffer(Offer offer);

	public List<Auction> BidList(Bid_request bid_r);

	public void DeleteOffer(int o_num);

	public void SelectOffer(String today);

	public Count BidCount(String o_username);

	public int BidRank(String o_username);

	public List<KindRate> KindCount(String o_username);

	

}
