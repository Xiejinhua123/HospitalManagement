package cn.vote.action;

import cn.vote.service.FriendService;

public class FriendAction extends ActionBase{
	private static final long serialVersionUID = -6094383297562636932L;
	private FriendService friendService;
	private String friendId;
	
	public void addFriend()
	{
		try {
			friendService.addFriend(friendId);
			super.setJson("true");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("false");
		}finally{
			super.witerJson();
		}
		
		
	}
	public void getFriend()
	{
		try {
			friendService.getFriend();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public FriendService getFriendService() {
		return friendService;
	}

	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	
	
}
