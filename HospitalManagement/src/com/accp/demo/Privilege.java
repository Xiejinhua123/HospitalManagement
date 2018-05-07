package com.accp.demo;

/**
 * 权限类
 * 
 * @author 解金化
 * @version 1.0
 * 
 * 	2017.03.08
 *
 */
public class Privilege {
	
	private int priId; // 权限编号
	private String priName; // 权限名称
	private int parentId; // 上级权限编号
	private String memo; // 备注
	private String menuPic; // 图标
	private String mentUrl; // 权限路径
	private String displayOrder; // 排序
	private String createTime; // 创建时间
	private String modifyTime; // 修改时间
	private int enabled; // 是否禁用该权限
	public Privilege() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Privilege(int priId, String priName, int parentId, String memo,
			String menuPic, String mentUrl, String displayOrder,
			String createTime, String modifyTime, int enabled) {
		super();
		this.priId = priId;
		this.priName = priName;
		this.parentId = parentId;
		this.memo = memo;
		this.menuPic = menuPic;
		this.mentUrl = mentUrl;
		this.displayOrder = displayOrder;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.enabled = enabled;
	}
	public int getPriId() {
		return priId;
	}
	public void setPriId(int priId) {
		this.priId = priId;
	}
	public String getPriName() {
		return priName;
	}
	public void setPriName(String priName) {
		this.priName = priName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getMenuPic() {
		return menuPic;
	}
	public void setMenuPic(String menuPic) {
		this.menuPic = menuPic;
	}
	public String getMentUrl() {
		return mentUrl;
	}
	public void setMentUrl(String mentUrl) {
		this.mentUrl = mentUrl;
	}
	public String getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(String displayOrder) {
		this.displayOrder = displayOrder;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	

}
