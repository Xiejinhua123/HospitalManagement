package com.accp.demo;

/**
 * Ȩ����
 * 
 * @author ���
 * @version 1.0
 * 
 * 	2017.03.08
 *
 */
public class Privilege {
	
	private int priId; // Ȩ�ޱ��
	private String priName; // Ȩ������
	private int parentId; // �ϼ�Ȩ�ޱ��
	private String memo; // ��ע
	private String menuPic; // ͼ��
	private String mentUrl; // Ȩ��·��
	private String displayOrder; // ����
	private String createTime; // ����ʱ��
	private String modifyTime; // �޸�ʱ��
	private int enabled; // �Ƿ���ø�Ȩ��
	public Privilege() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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
