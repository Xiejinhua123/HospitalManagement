package cn.vote.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 投票记录表
 * 
 * @author 解金化
 *
 */
@SuppressWarnings("serial")
public class VotingRecords implements java.io.Serializable {

	private String id;
	private Users usersByUserId;
	private Lable lable; // 标签
	private Users usersByVoteUserId;
	private Integer voteNumber;
	private Timestamp recordTime;
	private String delete;
	private Admin adminByUpdate;
	private Date updateTime;
	
	
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
	public Lable getLable() {
		return lable;
	}
	public void setLable(Lable lable) {
		this.lable = lable;
	}
	public Users getUsersByVoteUserId() {
		return usersByVoteUserId;
	}
	public void setUsersByVoteUserId(Users usersByVoteUserId) {
		this.usersByVoteUserId = usersByVoteUserId;
	}
	public Integer getVoteNumber() {
		return voteNumber;
	}
	public void setVoteNumber(Integer voteNumber) {
		this.voteNumber = voteNumber;
	}
	public Timestamp getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
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