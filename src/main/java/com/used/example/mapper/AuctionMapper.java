package com.used.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.Auction;
import com.used.example.domain.Product;


@Mapper
public interface AuctionMapper {

	public void CreateAuction(Auction auction);

	public List<Product> AuctionList(Product product) ;

	public Product AuctionDetail(int p_num);

	public void AuctionDelete(int a_num);

	public void AuctionEnd(String today);

	public void createPayment();


}
