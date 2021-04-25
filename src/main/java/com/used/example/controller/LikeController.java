package com.used.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.used.example.config.JwtUtils;
import com.used.example.domain.Like;
import com.used.example.domain.Product;
import com.used.example.service.LikeService;
import com.used.example.service.ProductService;



@CrossOrigin(origins="*", maxAge= 3600)
@RestController
@RequestMapping("/api/like")
public class LikeController {
	
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String token;
	
	@Autowired
	LikeService likeService;
	
	@Autowired
	ProductService productService;
	
	
	@PostMapping
	public ResponseEntity<?> CreateLike(@RequestBody Like like){

		likeService.CreateLike(like);
		
		Product product = new Product();
		
		product.setP_num(like.getP_num());
		product.setUsername(like.getL_username());

		
		Product product_detail = productService.ProductDetail(product);
		
		//logger.info("product_detail:"+product_detail);
		
		return new ResponseEntity<>(product_detail, HttpStatus.OK);
	}
	@DeleteMapping("/{p_num}/{l_username}")
	public ResponseEntity<?> DeleteLike(@PathVariable("p_num") int p_num , @PathVariable("l_username") String l_username){
		
		Like like = new Like();
		like.setL_username(l_username);
		like.setP_num(p_num);
		
		likeService.DeleteLike(like);
		
		Product product = new Product();
		
		product.setP_num(p_num);
		product.setUsername(l_username);

		
		Product product_detail = productService.ProductDetail(product);
		
		//logger.info("product_detail:"+product_detail);
		
		return new ResponseEntity<>(product_detail, HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<?> LikeList(HttpServletRequest request){
		
		token = request.getHeader("access_token");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")) {
			token = token.substring(7, token.length());
		}
		String l_username = JwtUtils.getUserEmailFromToken(token);
		
		logger.info("l_username"+l_username);
		List<Product> list =  likeService.LikeList(l_username);
		
		logger.info("likelist"+list);
		
		
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	
		
		
		
		
	}


}
