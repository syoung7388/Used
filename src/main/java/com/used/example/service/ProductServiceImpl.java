package com.used.example.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.used.example.date.DateForm;
import com.used.example.domain.Auction;
import com.used.example.domain.Picture;
import com.used.example.domain.Product;
import com.used.example.mapper.ProductMapper;
import com.used.example.picture.MakeThumbnail;

import ch.qos.logback.classic.Logger;


@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	ProductMapper productMapper;
	
	
	@Autowired
	MakeThumbnail makeThumbnail;
	@Autowired
	DateForm dateForm;
	
	private final Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void createProduct(Product product) {
		productMapper.createProduct(product);
		
	}

	@Override
	public void createPicture(Picture picture) {
		
		List<MultipartFile> imgList= picture.getImg();
		
		
		if(imgList != null) {
		List<String> pictureNames= new ArrayList<String>();
		
		
		//String path="C:\\Users\\User\\Desktop\\workspace\\Used\\src\\asset\\";
	      // String path="C:\\Users\\User\\Desktop\\workspace\\Used\\src\\f_used\\src\\assets\\";
			//String path="C:\\Users\\l3\\Documents\\work2\\Used\\src\\f_used\\src\\assets\\";
			//String path = "C:\\Users\\l3\\Desktop\\eee\\";
			String path = "/home/ec2-user/project/asset/";
			for(int i=0; i<imgList.size(); i++) {
				
				String filename= imgList.get(i).getOriginalFilename();

//				logger.info("imageList:"+imgList.get(i));
				
				
				int index = filename.lastIndexOf(".");
			
				String output_ext = "";
				for(int j=index+1; j<filename.length(); j++) {
					char one = filename.charAt(j);
					if((65 <= one) && (one <= 90)) {
						output_ext += filename.valueOf(one).toLowerCase();
					}else {
						output_ext += one;
					}
				}
				

				//String final_name = filename.substring(0, index+1)+ output_ext;
				UUID uuid = UUID.randomUUID();
				String final_name = uuid.toString()+dateForm.getAllDate()+"."+output_ext ;
				
		
				
				
				
			
				File file= new File(path+ final_name);			
				InputStream input = null;
				try {
					input = imgList.get(i).getInputStream();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
//				MakeThumbnail makeThumbnail = new MakeThumbnail();
				makeThumbnail.makeThumbnail(input, file,  output_ext);		
				
				pictureNames.add(final_name);
			}
			
			
			picture.setPictureNames(pictureNames);	
		}
		productMapper.createPicture(picture);
		
	}

	@Override
	public List<Product> getSaleList(String username) {
		return productMapper.getSaleList(username);
	}

	@Override
	public List<String> getImg(int i) {
		return productMapper.getImg(i);
	}

	@Override
	public List<Product> getSoldList(String username) {
		
		return productMapper.getSoldList(username);
	}



	@Override
	public List<Auction> getAuction(int p_num) {
		
		return productMapper.getAuction(p_num);
	}

	@Override
	public void updateProduct(Product product) {
		productMapper.updateProduct(product);
		
	}

	@Override
	public void deletePicture(Picture picture) {
		productMapper.deletePicture(picture);
		
	}

	@Override
	public void deleteProduct(int p_num) {
		productMapper.deleteProduct(p_num);
		
	}

	@Override
	public List<Product> TopList(Product product) {
		return productMapper.TopList(product);
		
	}

	@Override
	public List<Product> IndustryList(Product product) {
		return productMapper.IndustryList(product);
	}

	@Override
	public List<Product> KindList(Product product) {
		
		return productMapper.KindList(product);
	}



	








}
