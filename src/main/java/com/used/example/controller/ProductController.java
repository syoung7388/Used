package com.used.example.controller;

import java.io.File;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.used.example.config.JwtUtils;
import com.used.example.domain.Like;
import com.used.example.domain.Picture;
import com.used.example.domain.Product;

import com.used.example.service.ProductService;
import com.used.example.utility.MakeThumbnail;


@CrossOrigin(origins="*", maxAge =3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	///https://purumae.tistory.com/198 
	///https://dba.stackexchange.com/questions/33410/whats-the-difference-between-pointx-y-and-geomfromtextpointx-y
	
	@Autowired
	ProductService productService;
	
	private final Logger logger= LoggerFactory.getLogger(this.getClass());

	private String token;
	

	

	
	
	@PostMapping
	public ResponseEntity<?> CreateProduct(Product product, Picture picture, HttpServletRequest request) throws Exception {
		
		token= request.getHeader("access_token");
		
		if(StringUtils.hasText(token)&& token.startsWith("Bearer")) {
			token=token.substring(7, token.length());
		}
		String username= JwtUtils.getUserEmailFromToken(token);
		//토큰
		product.setUsername(username);
		
		logger.info(""+product);
		
		
		
		
		product.setUsername(username);
		product.setSale("false");
		productService.createProduct(product);
		logger.info("p_num:"+product.getP_num());
		int Pnum= product.getP_num();//제품 정보 저장 후 제품 번호 가져오기
		
		
		List<MultipartFile> multiList= picture.getMultipartfile();
		List<String> pictureNames= new ArrayList<String>();
		
		
        String path="C:\\Users\\User\\Desktop\\workspace\\Used\\src\\usedf\\src\\assets\\";
		//String path="C:\\Users\\l3\\Documents\\work2\\Used\\src\\usedf\\src\\assets\\";
		
		for(int i=0; i<multiList.size(); i++) {
			
			String filename= multiList.get(i).getOriginalFilename();
			String ext= filename.substring(filename.lastIndexOf(".")+1);
			File file= new File(path+ filename);			
			InputStream input = multiList.get(i).getInputStream();
			
			MakeThumbnail makeThumbnail = new MakeThumbnail();
			makeThumbnail.makeThumbnail(input, file,  ext);		
			
			pictureNames.add(filename);
		}
		//썸네일 만들고 이미지 리스트 저장 
		
		picture.setP_num(Pnum);
		picture.setPictureNames(pictureNames);
		
		productService.createPicture(picture);
		return new ResponseEntity<>("success", HttpStatus.OK);
		
	}
	
	
	@GetMapping("/salelist")
	public ResponseEntity<?> SaleList(HttpServletRequest request){
		
		String token= request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token= token.substring(7, token.length());
		}
		String username= JwtUtils.getUserEmailFromToken(token);
		Map<String,Object> map= new HashMap<>();
		
		
		
		List<Product> salelist= productService.getSaleList(username);
		
		logger.info("salelist:"+salelist);
		
		
		List<Product> soldlist= productService.getSoldList(username);
		map.put("saleList", salelist);
		map.put("soldList", soldlist);
		


		
		return new ResponseEntity<>(map, HttpStatus.OK);
		
	}
	
	@GetMapping("/{lat}/{lon}")
	public ResponseEntity<?> TopList(@PathVariable("lat") String lat, @PathVariable("lon") String lon){
		
		Product product = new Product();
		product.setLat(lat);
		product.setLon(lon);
		
		List<Product> list= productService.TopList(product);
		
		logger.info("toplist:"+ list);
		
		
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	@GetMapping({"/{lat}/{lon}/{kind}"})
	public ResponseEntity<?> KindList(@PathVariable("lat") String lat, @PathVariable("lon") String lon, @PathVariable("kind") String kind){
		
		Product product = new Product();
		product.setLat(lat);
		product.setLon(lon);
		product.setKind(kind);
		List<Product> list = productService.KindList(product);
		
		
		logger.info("kindlist:"+list);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/industry")
	public ResponseEntity<?> IndustryList(@RequestParam("lat")String lat, @RequestParam("lon")String lon, @RequestParam("industry")String industry){
		
		Product product = new Product();
		product.setLat(lat);
		product.setLon(lon);
		product.setIndustry(industry);
		List<Product> list = productService.IndustryList(product);
		
		logger.info("industryList:"+ product);
		
		if(list.size()== 0) {
			return new ResponseEntity<>("null",HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(list, HttpStatus.OK);
			
		}
		
	}
	
	
	
	@GetMapping
	public ResponseEntity<?>ProductDetail(@RequestParam ("p_num") int p_num, HttpServletRequest request) throws Exception{
		
		
		
		String token= request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token= token.substring(7, token.length());
		}
		String username= JwtUtils.getUserEmailFromToken(token);
		
		
		Product product = new Product();
		product.setP_num(p_num);
		product.setUsername(username);
	
		Product pro = productService.ProductDetail(product);

		logger.info("product_detail:"+ pro);
		
		
		
		
		
		return new ResponseEntity<>(pro, HttpStatus.OK);
		
	}
	@PostMapping("/edit")
	public ResponseEntity<?> SaleEdit(Product product, Picture picture, HttpServletRequest request) throws Exception{
		
		token= request.getHeader("access_token");
		
		if(StringUtils.hasText(token)&& token.startsWith("Bearer")) {
			token = token.substring(7, token.length());
		}
		
		String username= JwtUtils.getUserEmailFromToken(token);
		product.setUsername(username);
		productService.updateProduct(product); // 제품 업데이트
		
		
		 
		
		if(picture.getPi_nums() != null) {
			productService.deletePicture(picture);// 삭제한사진들 삭제
		}
		
		
		
		
		int P_num= product.getP_num();
		List <MultipartFile> multiList= picture.getMultipartfile();
		
		
		if(multiList != null) {
			 
			String path="C:\\Users\\User\\Desktop\\workspace\\Used\\src\\usedf\\src\\assets\\";
				//String path="C:\\Users\\l3\\Documents\\work2\\Used\\src\\usedf\\src\\assets\\";
			 
			 List<String> pictureNames = new ArrayList<String>();
			 for(int i=0; i<multiList.size() ; i++) {
				 
				 String filename= multiList.get(i).getOriginalFilename();
				 String ext= filename.substring(filename.indexOf(".")+i);
				 File file= new File(path+ filename);
				 InputStream input = multiList.get(i).getInputStream();
				 
				 MakeThumbnail makeThumbnail = new MakeThumbnail();
				 makeThumbnail.makeThumbnail(input, file, ext);
				 pictureNames.add(filename);
				 
			 }
			 picture.setP_num(P_num);
			 picture.setPictureNames(pictureNames);
			 
			 productService.createPicture(picture);
			 
			
		}

		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{p_num}")
	public ResponseEntity<?> DeleteProduct(@PathVariable("p_num") int p_num){
		
		productService.deleteProduct(p_num);
		
		
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	



	
	

}
