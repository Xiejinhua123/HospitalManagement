package cn.vote.service;

import java.util.List;

import cn.vote.entity.UserLabel;
import cn.vote.model.UserLableModel;
import cn.vote.model.UserModel;
import cn.vote.util.Page;

public interface UserLabelService {

	
	/**
	 * 给用户添加标签
	 * @param labelId 标签id
	 */
	void addUserLabel(Integer labelId);
	
	/**
	 * 删除用户的标签
	 * @param labelId 标签id
	 */
	void delUserLabel(Integer labelId);
	
	/**
	 * 获取用户的所有标签
	 * @return 
	 */
	List<UserLabel> getUserLabel();
	
	/**
	 * 获取标签用户
	 * @param p
	 * @param id
	 * @throws Exception
	 */
	void getUserByLabelId(Page<UserModel> p, Integer id) throws Exception;
	/**
	 * 根据标签id获取标签前十
	 * @param page
	 * @param labelId
	 */
	List<UserLableModel> getUserByLabelIdTop10(Integer labelId) throws Exception ;
}
