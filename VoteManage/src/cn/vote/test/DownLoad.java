package cn.vote.test;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class DownLoad {
	/**
	 * 文件下载
	 * @param path 文件路径
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/downloadRecruitInformation")
	public ResponseEntity<byte[]> downloadRecruitInformation(String path) throws IOException{
		   //处理显示中文文件名的问题
		   File file = new File(path);
		   String fileName = new String(file.getName().getBytes("utf-8"),"ISO-8859-1");
		   //设置请求头内容,告诉浏览器代开下载窗口
	       HttpHeaders headers = new HttpHeaders();  
	       headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
	       headers.setContentDispositionFormData("attachment",fileName);
	       /*前端弹出下载*/
	       return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
	                                              headers, HttpStatus.CREATED); 
	}
	/**
	 * 文件上传
	 * @param file 要上传的文件
	 * @param session
	 * @return	文件路径
	 * @throws Exception
	 */
	@RequestMapping("onFile")
	public String onFile(@RequestParam MultipartFile file,HttpSession session) throws Exception
	{
		String filename=file.getOriginalFilename();
		String path=session.getServletContext().getRealPath("/images");
		File myfile=new File(path,filename);
		file.transferTo(myfile);
		return path+"\\"+filename;
	}
}
