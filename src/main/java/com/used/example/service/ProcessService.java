package com.used.example.service;

import com.used.example.domain.Offer;

public interface ProcessService {

	public void SelectOffer(Offer offer);

	public void ProcessUp(int a_num);

	public void SkipOffer(Offer offer);

}
