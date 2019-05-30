package cn.vote.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Resource implements Serializable {

	private Integer id;
	private Resource resourceByParent;
	private Integer resGrade;
	private Admin adminByCreateId;
	private Admin adminByUpdateId;
	private String resName;
	private String resAddress;
	private Integer resStatic;//删除
	private String resIco;
	private Date createTime;
	private Date updateTime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Admin getAdminByCreateId() {
		return this.adminByCreateId;
	}

	public void setAdminByCreateId(Admin adminByCreateId) {
		this.adminByCreateId = adminByCreateId;
	}

	public Admin getAdminByUpdateId() {
		return this.adminByUpdateId;
	}

	public void setAdminByUpdateId(Admin adminByUpdateId) {
		this.adminByUpdateId = adminByUpdateId;
	}

	public String getResName() {
		return this.resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResAddress() {
		return this.resAddress;
	}

	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Resource getResourceByParent() {
		return resourceByParent;
	}

	public void setResourceByParent(Resource resourceByParent) {
		this.resourceByParent = resourceByParent;
	}

	public Integer getResGrade() {
		return resGrade;
	}

	public void setResGrade(Integer resGrade) {
		this.resGrade = resGrade;
	}

	public void setResStatic(Integer resStatic) {
		this.resStatic = resStatic;
	}

	public Integer getResStatic() {
		return resStatic;
	}

	public String getResIco() {
		return resIco;
	}

	public void setResIco(String resIco) {
		this.resIco = resIco;
	}
}