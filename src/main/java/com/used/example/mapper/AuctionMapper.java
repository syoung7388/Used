package com.used.example.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.used.example.domain.Address;
import com.used.example.domain.Auc_Pro;
import com.used.example.domain.Auction;
import com.used.example.domain.Count;
import com.used.example.domain.DelayDate;
import com.used.example.domain.Product;
import com.used.example.domain.MonthSum;


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



	public void Hits(int a_num);

	public void AucStep(int a_num);



	public int TotalCount(Map<String, Object> map);

	public List<Auction> TopList(Map<String, Object> map);

	public List<Auction> IndustryList(Map<String, Object> map);

	public List<Auction> KindList(Map<String, Object> map);

	public Count SaleCount(String username);

	public List<MonthSum> SaleSum(String username);

	public void AucDelay(DelayDate delaydate);



}
