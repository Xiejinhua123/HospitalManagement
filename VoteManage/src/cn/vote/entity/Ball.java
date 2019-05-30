package cn.vote.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class Ball implements java.io.Serializable {

	private Integer id;
	private String ballName;
	private Float probability;
	private String imgurl;
	private Integer putNumber;
	private Integer recycleNumber;
	private String text;
	private String delete;
	private Admin adminByUpdate;
	private Date updateTime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBallName() {
		return this.ballName;
	}

	public void setBallName(String ballName) {
		this.ballName = ballName;
	}

	public Float getProbability() {
		return this.probability;
	}

	public void setProbability(Float probability) {
		this.probability = probability;
	}

	public String getImgurl() {
		return this.imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Integer getPutNumber() {
		return this.putNumber;
	}

	public void setPutNumber(Integer putNumber) {
		this.putNumber = putNumber;
	}

	public Integer getRecycleNumber() {
		return this.recycleNumber;
	}

	public void setRecycleNumber(Integer recycleNumber) {
		this.recycleNumber = recycleNumber;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
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