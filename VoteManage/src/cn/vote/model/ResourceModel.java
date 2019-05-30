package cn.vote.model;

/**
 * 权限部分的模型信息
 * 
 * 该模型将会在上级用户给下级用户添加权限的时候用到
 * 
 * @author 解金化
 *
 */
public class ResourceModel {
	
	private Integer greadeId;
	private Integer id;
	private String name;
	private String address;
	private Integer statu;//三种情况父级有子级没有  1 
						 //父级子级都有 2	
						 //子级有 父级没有 3
	
	
	public Integer getId() {
		return id;
	}
	public Integer getGreadeId() {
		return greadeId;
	}
	public void setGreadeId(Integer greadeId) {
		this.greadeId = greadeId;
	}
	public Integer getStatu() {
		return statu;
	}
	public void setStatu(Integer statu) {
		this.statu = statu;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
