package com.used.example.utility;

import java.awt.Graphics2D;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.used.example.domain.Picture;
import com.used.example.service.ProductService;



public class MakeThumbnail {
	
	
	@Autowired
	ProductService productService;
	
	public void makeThumbnail(InputStream input, File file, String ext) {
		

			
			
			try {
				
				FileUtils.copyInputStreamToFile(input, file);
				
				
				BufferedImage imageBuf= ImageIO.read(file);
				int fixWidth= 500;
				double ratio = imageBuf.getWidth()/ (double)fixWidth;
				int thumbWidth= fixWidth;
				int thumbHeight=(int)(imageBuf.getHeight()/ratio);
				BufferedImage thumbImageBf = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_3BYTE_BGR);
				Graphics2D g = thumbImageBf.createGraphics();
				Image thumbImage = imageBuf.getScaledInstance(thumbWidth, thumbHeight, Image.SCALE_SMOOTH);
				g.drawImage(thumbImage, 0, 0, thumbWidth, thumbHeight, null);
				g.dispose();
				ImageIO.write(thumbImageBf, ext, file);
				System.out.println("썸네일 생성완료");

			}catch (IOException e) {
				FileUtils.deleteQuietly(file);
				e.printStackTrace();
			}
			
		}//for문 끝
		
		
	


	

}

	