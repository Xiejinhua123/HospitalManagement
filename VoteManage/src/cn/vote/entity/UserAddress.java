package cn.vote.entity;

@SuppressWarnings("serial")
public class UserAddress implements java.io.Serializable {

	private String id;
	private Users users;
	private String userAddress;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
}