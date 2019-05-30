package cn.vote.service;

import java.util.List;

import cn.vote.entity.UserAddress;

public interface UserAddressService {

	
	void add(UserAddress ua) throws Exception;
	
	void updateUserAddress(UserAddress ua) throws Exception;
	
	void delUserAddress(String addressId) throws Exception;
	
	/**
	 * 获取登录用户所有收货地址
	 * @return 
	 */
	List<UserAddress> getAll() throws Exception;
	
	/**
	 * 根据id获取登录用户收货地址
	 * @return 
	 */
	UserAddress getUserAddressById(String addressId) throws Exception;

	
	
	
	
}
