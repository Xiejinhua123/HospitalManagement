package cn.vote.model;

import java.util.Date;

public class LabelModel {
	private Integer id;
    private String lableName;
    private String explains;
    private Date createTime;
    private String event;
    private Integer number;
    private String deletes;
    
	public String getDeletes() {
		return deletes;
	}
	public void setDeletes(String deletes) {
		this.deletes = deletes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLableName() {
		return lableName;
	}
	public void setLableName(String lableName) {
		this.lableName = lableName;
	}
	public String getExplains() {
		return explains;
	}
	public void setExplains(String explains) {
		this.explains = explains;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
    
    
    
}
