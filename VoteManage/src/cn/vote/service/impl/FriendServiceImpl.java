package cn.vote.service.impl;

import java.util.List;

import cn.vote.dao.FriendDao;
import cn.vote.dao.UserDao;
import cn.vote.entity.Friend;
import cn.vote.entity.Users;
import cn.vote.model.Constants;
import cn.vote.service.FriendService;
import cn.vote.util.DateUtils;
import cn.vote.util.WebUtil;

public class FriendServiceImpl implements FriendService {

	private FriendDao friendDao;
	private UserDao userDao;

	@Override
	public List<Users> getFriend() throws Exception {
		return null;
	}

	@Override
	public void addFriend(String friendId) throws Exception {
		if (friendId == null || friendId.equals(""))
			throw new Exception("添加好友失败，当前参数为null");
		Users u = (Users) WebUtil
				.getSessionAttribute(Constants.SESSION_USER_KEY);
		Users fu = userDao.getById(friendId);
		Friend f = new Friend();
		f.setUsersByUserId(u);
		f.setUsersByFriendId(fu);
		f.setCreateTime(DateUtils.getNewDate());
		friendDao.addFriend(f);
	}

	public FriendDao getFriendDao() {
		return friendDao;
	}

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
