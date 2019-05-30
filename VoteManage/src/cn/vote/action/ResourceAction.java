package cn.vote.action;

import java.util.List;

import cn.vote.entity.Resource;
import cn.vote.model.ResModel;
import cn.vote.model.ResourceModel;
import cn.vote.service.ResourceService;

@SuppressWarnings("serial")
public class ResourceAction extends ActionBase {
	
	private ResourceService resourceService;
	private Resource res;
	private String manage;
	private Boolean flush;
	private Integer parent;
	private Integer adminId;
	/**
	 * 获取所有的权限信息
	 */
	public void getAllRes(){
		try {
			List<ResModel> list = this.resourceService.getAll();
			super.setJson(list);
		} catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	/**	
	 * 执行删除
	 * @return
	 */
	public String delRes(){
		try{
			this.resourceService.delete( this.res.getId() );
			this.manage = "删除成功";
			this.flush = false;
		}catch (Exception e) {
			if( res == null )
				this.flush = true;
			this.manage = "删除失败";
		}
		return SUCCESS;
	}
	
	/**
	 * 执行修改
	 * @return
	 */
	public String updRes(){
		try{
			this.resourceService.update(res);
			this.manage = "修改成功";
			this.flush = false;
		}catch (Exception e) {
			e.printStackTrace();
			if( res == null )
				this.flush = true;
			this.manage = "修改失败";
		}
		return SUCCESS;
	}
	
	/**
	 * 执行添加
	 * @return
	 */
	public String addRes(){
		try{
			this.resourceService.addRes(res);
			this.manage = "添加成功";
			this.flush = false;
		}catch (Exception e) {
			if( res == null )
				this.flush = true;
			this.manage = "添加失败";
		}
		return SUCCESS;
	}
	
	/**
	 * 通过编号查询权限信息
	 */
	public void getById(){
		try{
			ResModel rm = this.resourceService.getByid(this.res.getId());
			super.setJson(rm);
		}catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	/**
	 * 编辑用户时，获取1集权限
	 */
	public void getLevel1(){
		try{
			List<ResourceModel> list = this.resourceService.ajaxlevel1( this.res.getResGrade(),this.adminId );
			if(list!=null )super.setJson(list);
			else super.setJson(null);
		}catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public void getResByParent()
	{
		try{
			List<ResourceModel> list=resourceService.getLevel2(parent);
			if(list!=null )super.setJson(list);
			else super.setJson(null);
		}catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	/**
	 * 编辑用户时，获取子集权限
	 */
	public void getResByParent2()
	{
		try{
			List<ResourceModel> list=resourceService.getLevel(parent, res.getResGrade(),this.adminId);
			if(list!=null )super.setJson(list);
			else super.setJson(null);
		}catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	/**
	 * ajax获取当前用户可以操作的权限，并且权限必须是给定参数的上级权限
	 */
	public void getAjaxRes(){
		try{
			List<ResourceModel> list = this.resourceService.ajaxGetAll( this.res.getResGrade() );
			if(list!=null )super.setJson(list);
			else super.setJson(null);
		}catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	public ResourceService getResourceService() {
		return resourceService;
	}
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	public Resource getRes() {
		return res;
	}
	public void setRes(Resource res) {
		this.res = res;
	}
	public String getManage() {
		return manage;
	}
	public void setManage(String manage) {
		this.manage = manage;
	}
	public Boolean getFlush() {
		return flush;
	}
	public void setFlush(Boolean flush) {
		this.flush = flush;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
}
