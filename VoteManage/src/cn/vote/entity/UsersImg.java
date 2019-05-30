package cn.vote.entity;

@SuppressWarnings("serial")
public class UsersImg implements java.io.Serializable {

	private String id;
	private Users users;
	private String imgUrl;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
}