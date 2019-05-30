package cn.vote.action;

import java.util.List;

import cn.vote.entity.Lable;
import cn.vote.model.LabelModel;
import cn.vote.service.LableService;
import cn.vote.util.Page;

public class LableAction extends ActionBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3208699270681481949L;
	private Page<LabelModel> page=new Page<LabelModel>(); // 分页对象，需要向前台返回数据
	private Integer pagesize; // 第几页
	private Integer items; // 每页多少行
	private LableService lableService;
	private Lable lables;//标签对象
	private Integer id;//标签id
	
	public void getLable()
	{
		try{
			page.setItems(this.items);
			page.setPageSize(this.pagesize);
			lableService.getAll(page,null);
			super.setJson(page);
		}catch(Exception e){
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	public void getAllLabel()
	{
		try{
			List<LabelModel> list=lableService.getAllLabel();
			super.setJson(list);
		}catch(Exception e){
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	//根据标签id查询标签
	public void getLableById()
	{
		try {
			lables=lableService.getById(id);
			super.setJson(lables);
		} catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	//添加标签
	public void addLable()
	{
		try {
			boolean b=lableService.addLable(lables);
			if(b) super.setJson("true");
			else super.setJson("false");
		} catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public void updateLable()
	{
		try {
			lableService.updateLable(lables);
			super.setJson("true");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public void deleteLable()
	{
		boolean b;
		try {
			b = lableService.delete(id);
			if(b) super.setJson("true");
			else super.setJson("false");
		} catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	
	public LableService getLableService() {
		return lableService;
	}

	public void setLableService(LableService lableService) {
		this.lableService = lableService;
	}
	
	public Page<LabelModel> getPage() {
		return page;
	}
	public void setPage(Page<LabelModel> page) {
		this.page = page;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Lable getLables() {
		return lables;
	}
	public void setLables(Lable lables) {
		this.lables = lables;
	}
	
	
	
	
	
	
	
}
