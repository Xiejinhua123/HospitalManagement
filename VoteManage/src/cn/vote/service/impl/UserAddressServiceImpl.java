package cn.vote.service.impl;

import java.util.List;

import cn.vote.dao.UserAddressDao;
import cn.vote.entity.UserAddress;
import cn.vote.entity.Users;
import cn.vote.model.Constants;
import cn.vote.service.UserAddressService;
import cn.vote.util.DateUtils;
import cn.vote.util.WebUtil;

public class UserAddressServiceImpl implements UserAddressService {

	private UserAddressDao userAddressDao;

	@Override
	public void add(UserAddress ua) throws Exception {
		if (ua.getUserAddress() == null)
			throw new Exception("用户地址参数为空");
		try {
			Users user = (Users) WebUtil
					.getSessionAttribute(Constants.SESSION_USER_KEY);
			ua.setUsers(user);
			ua.setId(DateUtils.getUUID());
			userAddressDao.addAddress(ua);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUserAddress(UserAddress ua) throws Exception {

		if (ua.getUserAddress() == null || ua.getId() == null)
			throw new Exception("用户地址参数为空");
		try {
			Users users = (Users) WebUtil
					.getSessionAttribute(Constants.SESSION_USER_KEY);
			ua.setUsers(users);
			userAddressDao.update(ua);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delUserAddress(String addressId) throws Exception {
		if (addressId == null)
			throw new Exception("用户地址id参数为空");
		try {
			userAddressDao.deleteAddress(addressId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserAddress> getAll() throws Exception {
		List<UserAddress> list = userAddressDao.getAll();
		if (list != null)
			return list;
		else
			return null;
	}

	@Override
	public UserAddress getUserAddressById(String addressId) throws Exception {
		if (addressId == null)
			throw new Exception("用户地址id参数为空");
		return userAddressDao.getById(addressId);
	}

}
