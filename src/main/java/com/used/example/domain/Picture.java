package com.used.example.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Picture {
	private List<MultipartFile> multipartfile;// 받아오는거
	

	private int p_num;
	private int pi_num;
	private String pictureName; //select할때

	
	
	
	
	private List<String> pictureNames;//insert할때
	private List<Integer> pi_nums; //삭제 할떄  
	
	
	
	
	
	public List<String> getPictureNames() {
		return pictureNames;
	}
	public void setPictureNames(List<String> pictureNames) {
		this.pictureNames = pictureNames;
	}
	public List<MultipartFile> getMultipartfile() {
		return multipartfile;
	}
	public void setMultipartfile(List<MultipartFile> multipartfile) {
		this.multipartfile = multipartfile;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public int getPi_num() {
		return pi_num;
	}
	public void setPi_num(int pi_num) {
		this.pi_num = pi_num;
	}

	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public List<Integer> getPi_nums() {
		return pi_nums;
	}
	public void setPi_nums(List<Integer> pi_nums) {
		this.pi_nums = pi_nums;
	}
	@Override
	public String toString() {
		return "Picture [multipartfile=" + multipartfile + ", p_num=" + p_num + ", pi_num=" + pi_num + ", pictureName="
				+ pictureName + ", pictureNames=" + pictureNames + ", pi_nums=" + pi_nums + "]";
	}
	
	
	

	
	
	
	
	

}
