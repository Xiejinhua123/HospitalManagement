package cn.vote.action;

import java.util.List;

import cn.vote.entity.UserLabel;
import cn.vote.model.UserLableModel;
import cn.vote.model.UserModel;
import cn.vote.service.UserLabelService;
import cn.vote.util.Page;

@SuppressWarnings("serial")
public class UserLabelAction extends ActionBase{

	private UserLabelService userLabelService;
	private Integer labelId;
	private Integer pagesize; // 第几页
	private Integer items; // 每页多少行
	private Page<UserModel> page=new Page<UserModel>(); // 分页对象，需要向前台返回数据
	//添加
	public void addUL()
	{
		try{
			this.userLabelService.addUserLabel(labelId);
			super.setJson("success");
		}catch (Exception e) {
			super.setJson(e.getMessage());
		}finally{
			super.witerJson();
		}
		
	}
	//删除
	public void delUL()
	{
		try{
			this.userLabelService.delUserLabel(labelId);
			super.setJson("success");
		}catch (Exception e) {
			super.setJson(e.getMessage());
		}finally{
			super.witerJson();
		}
	}
	//查找
	public void getUL()
	{
	try{
		List<UserLabel> list=userLabelService.getUserLabel();
		if(list!=null) super.setJson(list);
		else super.setJson("fail");
	}catch (Exception e) {
		super.setJson(e.getMessage());
	}finally{
		super.witerJson();
	}
	}
	
	public void getUserByLavelId()
	{
		try{
			page.setItems(items);
			page.setPageSize(pagesize);
			userLabelService.getUserByLabelId(page, labelId);
			super.setJson(page);
		}catch (Exception e) {
			super.setJson(e.getMessage());
		}finally{
			super.witerJson();
		}
	}
	//获取该标签排行前十
	public void getUserByLabelIdTop10()
	{
		try{
			List<UserLableModel> list=userLabelService.getUserByLabelIdTop10(labelId);
			super.setJson(list);
		}catch (Exception e) {
			super.setJson(e.getMessage());
		}finally{
			super.witerJson();
		}
	}
	
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getItems() {
		return items;
	}
	public void setItems(Integer items) {
		this.items = items;
	}
	public Page<UserModel> getPage() {
		return page;
	}
	public void setPage(Page<UserModel> page) {
		this.page = page;
	}
	public Integer getLabelId() {
		return labelId;
	}
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	public UserLabelService getUserLabelService() {
		return userLabelService;
	}

	public void setUserLabelService(UserLabelService userLabelService) {
		this.userLabelService = userLabelService;
	}

}
