package cn.vote.model;

public class AdminUpdateModel {

	private Integer id;
	private String name;
	private String manageAccount;
	private Integer rank;
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
	public String getManageAccount() {
		return manageAccount;
	}
	public void setManageAccount(String manageAccount) {
		this.manageAccount = manageAccount;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	
}
