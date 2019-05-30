package cn.vote.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.apache.struts2.ServletActionContext;


/**
 * 该类用于图片上传，仅限于图片上传，<br/>
 * 
 * 用法：
 * 		在需要文件上传的action中，继承该类<br/>
 * 		不需要实现方法，也不需要自己写任何参数<br/>
 * 		直接通过super关键字调用addImg()方法即可<br/>
 * @author 解金化
 *
 */
public class FileAction extends ActionBase {

	private static final long serialVersionUID = 4902539075601536424L;
	
	private List<File> file;
	private List<String> fileFileName;
	private List<String> fileContentType;
	private List<String> dataUrl;
	
	
	/**
	 * 该方法执行保存图片功能，<br/>
	 * 
	 * @param partpath
	 * 		这是需要保存的相对路径
	 * @return
	 * 		成功返回true，失败返回false
	 * @throws Exception
	 * 		异常必须捕获
	 */
	@SuppressWarnings("rawtypes")
	public String[] addImg( String partpath) throws Exception {
		
		for (File f : file) {
			ImageInputStream iis = ImageIO.createImageInputStream(f); // resFile为需被
			Iterator iter = ImageIO.getImageReaders(iis);
			
			if (!iter.hasNext()) {
				throw new Exception("非图片类型的");
			}
		}
		
		String[] imgPath = new String[file.size()];
		
	    String imgpath = partpath;
	    
	    for (int i = 0; i < file.size(); ++i) {
	    	
	        InputStream is = new FileInputStream(file.get(i));
	
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
	        imgPath[i] = "/VoteManage" + pathn;
	    }
	    return imgPath;
	}

	public List<File> getFile() {
		return file;
	}
	public void setFile(List<File> file) {
		this.file = file;
	}
	public List<String> getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}
	public List<String> getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public List<String> getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(List<String> dataUrl) {
		this.dataUrl = dataUrl;
	}
}
