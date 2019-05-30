package cn.vote.dao;

import java.util.List;

import cn.vote.entity.UsersImg;

public interface UsersImgDao {
	
	public void addUserImg(UsersImg ui);
	
	void delUserImg(String ui);
	
	public void update(UsersImg ui);
	
	/**
	 * 根据用户id查询用户所有图片
	 * @param userId
	 * @return
	 */
	List<UsersImg> getAll();

	public List<UsersImg> getByUsersId(String id);
}
