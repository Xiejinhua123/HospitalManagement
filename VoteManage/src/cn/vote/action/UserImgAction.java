package cn.vote.action;

import java.io.File;
import java.util.List;

import cn.vote.entity.UsersImg;
import cn.vote.service.UserImgService;
import cn.vote.util.Stream;

public class UserImgAction extends ActionBase{

	
	private static final long serialVersionUID = -4575492627017976872L;
	private String uiid;
	private UserImgService userImgService;
	private UsersImg usersImg;
	private File file;
	//尚未获取图片
	public void addUserImg()
	{
		try{
			String imgUrl=Stream.addImg("/pagefile/image/UserImage/",file);
			usersImg.setImgUrl(imgUrl);
			userImgService.addUserImg(usersImg);
			super.setJson("success");
		}catch (Exception e) {
			super.setJson("error");
			e.printStackTrace();
		}finally{
			super.witerJson();
		}
	}
	
	public void delUserImg()
	{
		try{
			userImgService.delUserImg(uiid);
			super.setJson("success");
		}catch (Exception e) {
			super.setJson("error");
			e.printStackTrace();
		}finally{
			super.witerJson();
		}
	}
	
	public void getAllUserImg()
	{
		try{
			List<UsersImg> ua=userImgService.getAllUserImg();
			if(ua!=null) super.setJson(ua);
			else super.setJson("null");
		}catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
		
	}
	
	
	public String getUiid() {
		return uiid;
	}
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	public UserImgService getUserImgService() {
		return userImgService;
	}
	public void setUserImgService(UserImgService userImgService) {
		this.userImgService = userImgService;
	}

	public UsersImg getUsersImg() {
		return usersImg;
	}

	public void setUsersImg(UsersImg usersImg) {
		this.usersImg = usersImg;
	}
	
}
