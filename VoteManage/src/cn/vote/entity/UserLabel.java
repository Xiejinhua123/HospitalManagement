package cn.vote.entity;

/**
 * 用户标签
 * 
 * @author 解金化
 * 
 */
@SuppressWarnings("serial")
public class UserLabel implements java.io.Serializable {

	private String id;
	private Users users;
	private Lable lable;
	private Integer voteNumber;
	private String text;

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

	public Lable getLable() {
		return this.lable;
	}

	public void setLable(Lable lable) {
		this.lable = lable;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getVoteNumber() {
		return voteNumber;
	}

	public void setVoteNumber(Integer voteNumber) {
		this.voteNumber = voteNumber;
	}

}