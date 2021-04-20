package com.used.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.Auction;


@Mapper
public interface AuctionMapper {

	public void CreateAuction(Auction auction);

}
