package com.used.example.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.used.example.config.JwtUtils;
import com.used.example.domain.Product;
import com.used.example.domain.User;
import com.used.example.service.ProductService;
import com.used.example.utilty.makeSomenail;

@CrossOrigin(origins="*", maxAge =3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	
	
	@Autowired
	ProductService productService;
	
	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	
	

	
	
	
	@PostMapping("/writing")
	public ResponseEntity<?> Writing (@RequestBody Product product, HttpServletRequest request) throws Exception{
		
		
		String token = new String();
		token= request.getHeader("access_token");
		
		if(StringUtils.hasText(token)&& token.startsWith("Bearer")) {
			token=token.substring(7, token.length());
		}
		String username= JwtUtils.getUserEmailFromToken(token);
		
		
		//====================================================================토큰
		
		ArrayList<MultipartFile> imageList = product.getImageList();
		
		
		makeSomenail Somnail = new makeSomenail();
		
		for(int i=0; i<imageList.size(); i++) {
			
//			String rootPath= FileSystemView.getFileSystemView().getHomeDirectory().toString();
//			String basePath= rootPath+"/"+"single";
//			
			
			
		
			String originalFileName = imageList.get(i).getOriginalFilename();
			int index= originalFileName .lastIndexOf(".");
			System.out.println("나지금 Domain이야:"+ originalFileName);
			
			String fileName= originalFileName.substring(0, index);
			String fileExt= originalFileName.substring(index+1);
			
			
			File file = new File("Used/src/usedf/src/asset/"+ originalFileName);
			
			logger.info(file.getAbsolutePath());
			
			imageList.get(i).transferTo(file);
			
			Somnail.makeSomenail(file.getAbsoluteFile(), originalFileName, fileExt);

		}
		

		
		
		
		
		
		//=====================================================================이미지
		logger.info(username);
		product.setUsername(username);
		
		productService.createProduct(product);
		
		
		
		
		

		return new ResponseEntity<>("success", HttpStatus.OK);
		

		
		
	}



	
	

}
