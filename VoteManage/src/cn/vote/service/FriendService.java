package cn.vote.service;

import java.util.List;

import cn.vote.entity.Users;

public interface FriendService {

	/**
	 * 获取用户所有好友
	 * @return
	 * @throws Exception 
	 */
	List<Users> getFriend() throws Exception;	
	/**
	 * 添加好友
	 * @param fid 好友
	 * @throws Exception 
	 */
	void addFriend(String friendId) throws Exception;
	
}
