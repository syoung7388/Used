package com.used.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.used.example.domain.Picture;




@CrossOrigin(origins="*", maxAge =3600)
@RestController
@RequestMapping("/api/image")
public class ImageController {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//RequestParam("FormData") List<MultipartFile> multi
	
	@PostMapping("/multiimage")
	public void MultiImage(@RequestBody File image) throws IllegalStateException, IOException{
		

		
		
		
//		
//		
//		for(int i=0; i<multi.size(); i++) {
//		
//			
//			
//			String originalFileName = multi.get(i).getOriginalFilename();
//			int index= originalFileName .lastIndexOf(".");
//			System.out.println("나지금 Domain이야:"+ originalFileName);
//			
//			String fileName= originalFileName.substring(0, index);
//			String fileExt= originalFileName.substring(index+1);
//			
//			
//			File file = new File("Used/src/usedf/src/asset/"+ originalFileName);
//			
//		
//			logger.info(file.getAbsolutePath());
//		
//		
//			multi.get(i).transferTo(file);
//		
////			
////			Somnail.makeSomenail(file.getAbsoluteFile(), originalFileName, fileExt);
//
//		}
//		
//		
//		
	}
	
	
	
	

}
