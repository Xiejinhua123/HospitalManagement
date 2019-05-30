package cn.vote.model;

public class AdminModel {
	
	 private Integer id;
	 private String name;
	 private Integer rank;
	 private String updName;
	 private String createName;
	 private String createTime;
	 private String updTime;
	 private Boolean noOption;
	 private String deldetes;
	 
	 
	public String getDeldetes() {
		return deldetes;
	}
	public void setDeldetes(String deldetes) {
		this.deldetes = deldetes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUpdName() {
		return updName;
	}
	public void setUpdName(String updName) {
		this.updName = updName;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public Boolean getNoOption() {
		return noOption;
	}
	public void setNoOption(Boolean noOption) {
		this.noOption = noOption;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setUpdTime(String updTime) {
		this.updTime = updTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public String getUpdTime() {
		return updTime;
	}
}
