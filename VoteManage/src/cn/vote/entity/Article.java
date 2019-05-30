package cn.vote.entity;

import java.sql.Timestamp;

@SuppressWarnings("serial")
public class Article implements java.io.Serializable {

	private Integer id;
	private String deletes;
	private Lable lable;
	private String title;
	private String content;
	private Timestamp crateTime;
	private Timestamp updateTime;
	private Users users;
	private Admin admin;
	private Integer loveNumber;
	private Integer readNumber;
	private Integer voteNumber;
	private String name;
	private Admin adminByUpdate;
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Admin getAdminByUpdate() {
		return adminByUpdate;
	}
	public void setAdminByUpdate(Admin adminByUpdate) {
		this.adminByUpdate = adminByUpdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCrateTime() {
		return crateTime;
	}
	public void setCrateTime(Timestamp crateTime) {
		this.crateTime = crateTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Integer getLoveNumber() {
		return loveNumber;
	}
	public void setLoveNumber(Integer loveNumber) {
		this.loveNumber = loveNumber;
	}
	public Integer getReadNumber() {
		return readNumber;
	}
	public void setReadNumber(Integer readNumber) {
		this.readNumber = readNumber;
	}
	public Integer getVoteNumber() {
		return voteNumber;
	}
	public void setVoteNumber(Integer voteNumber) {
		this.voteNumber = voteNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDeletes() {
		return deletes;
	}
	public void setDeletes(String deletes) {
		this.deletes = deletes;
	}
	public Lable getLable() {
		return lable;
	}
	public void setLable(Lable lable) {
		this.lable = lable;
	}
	

}