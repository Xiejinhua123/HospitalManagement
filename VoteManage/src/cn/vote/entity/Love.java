package cn.vote.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class Love implements java.io.Serializable {

	private Integer id;
	private Integer putNumber;
	private Integer recycleNumber;
	private Integer loveNumber;
	private Float probability;
	private Float proportion;
	private String delete;
	private Admin adminByUpdate;
	private Date updateTime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getLoveNumber() {
		return this.loveNumber;
	}

	public void setLoveNumber(Integer loveNumber) {
		this.loveNumber = loveNumber;
	}

	public Float getProbability() {
		return this.probability;
	}

	public void setProbability(Float probability) {
		this.probability = probability;
	}

	public Float getProportion() {
		return proportion;
	}

	public void setProportion(Float proportion) {
		this.proportion = proportion;
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