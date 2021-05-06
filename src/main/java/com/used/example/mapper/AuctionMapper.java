package com.used.example.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.used.example.domain.Address;
import com.used.example.domain.Auc_Pro;
import com.used.example.domain.Auction;
import com.used.example.domain.Product;


@Mapper
public interface AuctionMapper {

	public void CreateAuction(Auction auction);

	public List<Product> AuctionList(Product product) ;

	public Auction AucDetail(int a_num);

	public void AucDelete(int a_num);



	public void createPayment();


	public void CreateAP(Auc_Pro ap);

	public void CreateAddress(Address address);

	public List<Auction> SaleList(Auction auction);

	public void AucEdit( Auction auction);

	

	public List<Auction> IndustryList(@Param("lat")String lat,@Param("lon") String lon, @Param("industry") String industry);

	public List<Auction> KindList(@Param("lat")String lat,@Param("lon") String lon, @Param("kind") String kind);

	public void Hits(int a_num);

	public void AucEnd(int a_num);



	public int Count(Map<String, Object> map);

	public List<Auction> TopList(Map<String, Object> map);



}
