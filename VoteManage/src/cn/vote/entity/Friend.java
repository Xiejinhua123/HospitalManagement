package cn.vote.entity;
import java.util.Date;

@SuppressWarnings("serial")
public class Friend  implements java.io.Serializable {

     private String id;
     private Users usersByUserId;
     private Users usersByFriendId;
     private Date createTime;
     
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Users getUsersByUserId() {
		return usersByUserId;
	}
	public void setUsersByUserId(Users usersByUserId) {
		this.usersByUserId = usersByUserId;
	}
	public Users getUsersByFriendId() {
		return usersByFriendId;
	}
	public void setUsersByFriendId(Users usersByFriendId) {
		this.usersByFriendId = usersByFriendId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

     
     

}