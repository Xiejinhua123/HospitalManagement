package cn.vote.receptionModel;

import java.util.Date;

public class UserReception {

	private String id;
	private String Details;
	private Integer aaa;
	private String src;
	private String name;
	private Date birthday;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public Integer getAaa() {
		return aaa;
	}
	public void setAaa(Integer aaa) {
		this.aaa = aaa;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
