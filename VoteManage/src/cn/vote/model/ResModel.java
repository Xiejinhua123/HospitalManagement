package cn.vote.model;

/**
 * 该模型用于在查看单个权限具体信息的时候进行网前端页面输送json数据
 * 
 * @author 解金化
 *
 */
public class ResModel {

	private Integer id;
	private String name;
	private String resAddress;
	private Integer resRank;
	private String createName;
	private String createTime;
    private String updateName;
    private String updateTime;
    private String options;
    private Integer parentId;
    private String deletes;
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
	public String getResAddress() {
		return resAddress;
	}
	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}
	public Integer getResRank() {
		return resRank;
	}
	public void setResRank(Integer resRank) {
		this.resRank = resRank;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getDeletes() {
		return deletes;
	}
	public void setDeletes(String deletes) {
		this.deletes = deletes;
	}
    
}
