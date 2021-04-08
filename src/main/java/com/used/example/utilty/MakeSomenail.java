package com.used.example.utilty;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;



public class MakeSomenail {
	
	
	public void makeSomenail(File filePath, String fileName, String fileExt)throws Exception{
		
		try {
			
		
			BufferedImage srcImg = ImageIO.read(filePath);
			
			int dw= 250, dh= 150;
			int ow= srcImg.getWidth();
			int oh = srcImg.getHeight();
			
			int nw= ow;
			int nh= (ow*dh)/ dw;
			
			if(nh> oh){
				nw= (oh*dw)/dh;
				nh= oh;
			}
			BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh);
			
			BufferedImage destImg= Scalr.resize(cropImg, dw, dh);
			
			String thumbName = "Used/src/usedf/src/asset/"+ "THUMB_" + fileName; 
			File thumbFile = new File(thumbName); 
			ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}


		

	
	}




	

}
