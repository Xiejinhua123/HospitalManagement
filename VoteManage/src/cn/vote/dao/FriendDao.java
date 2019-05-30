package cn.vote.dao;

import java.util.List;

import cn.vote.entity.Friend;
import cn.vote.entity.Users;

public interface FriendDao {

	
	/**
	 * 获取用户所有好友
	 * @return
	 */
	List<Friend> getFriend(Users u);	
	/**
	 * 添加好友
	 * @param fid 好友
	 */
	void addFriend(Friend f);
	
	
	/**
	 * 根据id删除好友
	 * @param fid
	 */
	void delFrienf(Friend f);
	
	void updateFrient(Friend f);
}
