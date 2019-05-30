package cn.vote.dao;

import java.util.List;

import cn.vote.entity.UserAddress;

public interface UserAddressDao {
	
	/**
	 * 添加用户地址
	 * @param ua 用户地址
	 */
	public void addAddress(UserAddress ua);
	
	/**
	 * 删除用户地址
	 * @param string 用户地址id
 	 */
	public  void deleteAddress(String u);

	
	void update(UserAddress u);
	
	public UserAddress getById(String id);
	
	public List<UserAddress> getAll();
}
