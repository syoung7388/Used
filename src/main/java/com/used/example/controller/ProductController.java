package com.used.example.controller;

import java.io.File;


import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ClientCodecConfigurer.MultipartCodecs;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.used.example.config.JwtUtils;
import com.used.example.domain.Image;
import com.used.example.domain.Product;
import com.used.example.domain.User;
import com.used.example.service.ProductService;
import com.used.example.utilty.MakeSomenail;


@CrossOrigin(origins="*", maxAge =3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	
	
	@Autowired
	ProductService productService;
	
	private final Logger logger= LoggerFactory.getLogger(this.getClass());

	private String token;
	
	
	
	


	
	
	@PostMapping("/writing")
	public ResponseEntity<?> Writing (Product product, HttpServletRequest request) throws Exception {
	

		
		
	
		
		
	


		
		

		
		
		//====================================================================이미지 리스트
		

		//logger.info("product: "+product.getImageList());
		token= request.getHeader("access_token");
		
		if(StringUtils.hasText(token)&& token.startsWith("Bearer")) {
			token=token.substring(7, token.length());
		}
		String username= JwtUtils.getUserEmailFromToken(token);
		//====================================================================토큰
		
		logger.info(username);
		//product.setUsername(username);
		
		
		
		//List<MultipartFile> imageList= product.getImageList();
		
		//logger.info("배열"+imageList);
		
		
//		productService.createProduct(product);
		
		
		
		
		
		return new ResponseEntity<>("success", HttpStatus.OK);
		

		
		
	}



	
	

}
