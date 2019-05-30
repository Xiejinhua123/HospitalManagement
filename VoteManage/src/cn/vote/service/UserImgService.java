package cn.vote.service;

import java.util.List;

import cn.vote.entity.UsersImg;

public interface UserImgService {

	
	void addUserImg(UsersImg ui) throws Exception;
	
	void delUserImg(String uiId)throws Exception;
	
	List<UsersImg> getAllUserImg()throws Exception;
}
