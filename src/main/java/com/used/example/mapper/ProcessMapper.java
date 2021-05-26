package com.used.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.Offer;


@Mapper
public interface ProcessMapper {

	public void SelectOffer(Offer offer);

	public void ProcessUp(int a_num);

	public void SkipOffer(Offer offer);

}
