package cn.vote.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class Users implements java.io.Serializable {

	private String id;
	private Integer deleteds;
	private String wechatName;
	private String userName;
	private String userPassword;
	private Date birthday;
	private String telephone;
	private String userAvatar;
	private Integer totalVotes; // 投票总量
	private Integer boxNumber;
	private Integer loveNumber;
	private Integer voteNumber;
	private Integer ballNumber;
	private Integer userType;
	private Admin adminByUpdate;
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getDeleteds() {
		return deleteds;
	}

	public void setDeleteds(Integer deleteds) {
		this.deleteds = deleteds;
	}

	public String getWechatName() {
		return wechatName;
	}

	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public Integer getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(Integer totalVotes) {
		this.totalVotes = totalVotes;
	}

	public Integer getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(Integer boxNumber) {
		this.boxNumber = boxNumber;
	}

	public Integer getLoveNumber() {
		return loveNumber;
	}

	public void setLoveNumber(Integer loveNumber) {
		this.loveNumber = loveNumber;
	}

	public Integer getVoteNumber() {
		return voteNumber;
	}

	public void setVoteNumber(Integer voteNumber) {
		this.voteNumber = voteNumber;
	}

	public Integer getBallNumber() {
		return ballNumber;
	}

	public void setBallNumber(Integer ballNumber) {
		this.ballNumber = ballNumber;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Admin getAdminByUpdate() {
		return adminByUpdate;
	}

	public void setAdminByUpdate(Admin adminByUpdate) {
		this.adminByUpdate = adminByUpdate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}