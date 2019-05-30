package cn.vote.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.apache.struts2.ServletActionContext;

public class Stream {
		/**
		 * file类型转成byte[]
		 * @param myFile 文件
		 * @param myFileFileName 文件名称
		 * @return
		 */
		public static String addImg( String partpath,File file) throws Exception {
		
		
			ImageInputStream iis = ImageIO.createImageInputStream(file); // resFile为需被
			@SuppressWarnings("rawtypes")
			Iterator iter = ImageIO.getImageReaders(iis);
			
			if (!iter.hasNext()) {
				throw new Exception("非图片类型的");
			}
		
		
			String imgpath = partpath;
	    
	  
	    	
	        InputStream is = new FileInputStream(file);
	
	        String path = ServletActionContext.getServletContext().getRealPath("/");
	
	        /**
	         * 图片存在服务器上的相对路径
	         */
	        String pathn = imgpath + new Date().getTime() + ".png";
	        
	        File destFile = new File(path + pathn); // 原名称保存数据库
	        //不太合理，需要自己生成一个时间戳，来保存图片
	
//	        File destFile = new File(imgpath, new Date().getTime()+".png" ); // 原名称保存数据库
	        
	        OutputStream os = new FileOutputStream(destFile);
	
	        byte[] buffer = new byte[600];
	
	        int length = 0;
	
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	
	        is.close();
	
	        os.close();
	        
	        //在当前的文件流关闭后 ，当前图片已经被存储在服务器中，返回当前图片在服务器上的地址
	        imgpath = "/VoteManage" + pathn;
	   
	    return imgpath;
	}
}
