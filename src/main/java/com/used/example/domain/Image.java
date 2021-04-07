package com.used.example.domain;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class Image {
	
	
	public String Image( List<MultipartFile> images){
		
		
		
		

		
		String path= "";
		String thumbPath= path+"thumb/";
		String filename = 
		String ext= filename.substring(filename.lastIndexOf(".")+1);
		
		
		File file= new File(path+ filename);
		File thumbFile = new File(thumbPath+filename);
		
		try {
			InputStream input = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(input, file);
			
			
			Buffr
			
			
		}
		
		
		
		
	}
	
	
}
