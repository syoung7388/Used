package com.used.example.controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;

import org.apache.http.HttpHeaders;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ClientCodecConfigurer.MultipartCodecs;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.used.example.config.JwtUtils;
import com.used.example.domain.Auction;
import com.used.example.domain.Picture;
import com.used.example.domain.Product;
import com.used.example.domain.User;
import com.used.example.service.ProductService;
import com.used.example.utility.MakeThumbnail;


@CrossOrigin(origins="*", maxAge =3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	
	
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
	
	@GetMapping("/saledetail")
	public ResponseEntity<?> SaleDetail(@RequestParam ("p_num") int p_num) throws Exception{
		Product product = productService.getSaleDetail(p_num);

		logger.info("product:"+ product);
		
		
		
		
		
		return new ResponseEntity<>(product, HttpStatus.OK);
		
	}

	



	
	

}
