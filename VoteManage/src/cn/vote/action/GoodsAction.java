package cn.vote.action;



import java.util.List;

import org.apache.log4j.Logger;

import cn.vote.entity.Goods;
import cn.vote.model.GoodsModel;
import cn.vote.service.GoodsImgService;
import cn.vote.service.GoodsService;
import cn.vote.util.ImageCutModel;
import cn.vote.util.Page;

public class GoodsAction extends FileAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2790875043635711416L;

	private Logger log = Logger.getLogger(GoodsAction.class);
	
	private Page<GoodsModel> page=new Page<GoodsModel>(); // 分页对象，需要向前台返回数据
	private Integer pagesize; // 第几页
	private Integer items; // 每页多少行
	private GoodsService goodsService;
	private GoodsImgService goodsImgService;
	private Goods goods;
	private String name;
	private Integer goodsId;
	private String manage;
	private ImageCutModel icm; // 执行图片切割的必要参数封装类
	
	/**
	 * 分页查询商品，前台传回page对象
	 */
	public void getAllGoods()
	{
		try{
		page.setItems(this.items);
		page.setPageSize(this.pagesize);
		if("".equals(name) || name==null)
			goodsService.getPageGoods(page,null);
		else goodsService.getPageGoods(page,name);
		super.setJson(page);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			witerJson();
		}
	}
	/**
	 * 修改商品
	 * @return 失败返回fail 
	 */
	public void  updateGoods()
	{
		try{
			boolean b=goodsService.updateGoods(goods);
			if(b)super.setJson("success");
			else super.setJson("fail");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}
		super.witerJson();
	}
	/**
	 * 根据商品id查询商品
	 * @return  失败返回fail 
	 */
	public void getById()
	{
		try {
			GoodsModel g=goodsService.findGoodsById(goodsId);
			if(g==null)super.setJson("fail");
			else super.setJson(g);
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
		
	}
	
	/**
	 * 根据id删除
	 * 成功返回true
	 * 失败返回false
	 */
	public void deleteGoodById()
	{
		try {
			boolean b=goodsService.delById(goodsId);
			if(b)super.setJson("true");
			else super.setJson("false");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("false");
		}finally{
			super.witerJson();
		}
	}
	
	/**
	 * 添加商品
	 * 
	 * @author 解金化
	 * 
	 * @date 2017.07.22
	 */
	public String addGoods(){
		
		try {
			String[] paths = super.addImg("/pagefile/image/goodImage/");
			this.goodsService.addGoods( this.goods , paths , icm);
			this.manage = "success";
			return SUCCESS;
		} catch (Exception e) {
			
			log.error("添加商品出现错误，当前的事物回滚");
			this.manage = "error";
			return ERROR;
		}
	}
	
	public void getAllGoodsName()
	{
		try {
			List<String> list=goodsService.getAllGoodsName();
			if(list!=null)super.setJson(list);
			else super.setJson("false");
		} catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	
	
	
	
	
	
	
	

	public Page<GoodsModel> getPage() {
		return page;
	}
	public void setPage(Page<GoodsModel> page) {
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
	public GoodsService getGoodsService() {
		return goodsService;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public GoodsImgService getGoodsImgService() {
		return goodsImgService;
	}
	public void setGoodsImgService(GoodsImgService goodsImgService) {
		this.goodsImgService = goodsImgService;
	}
	public String getManage() {
		return manage;
	}
	public void setManage(String manage) {
		this.manage = manage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ImageCutModel getIcm() {
		return icm;
	}
	public void setIcm(ImageCutModel icm) {
		this.icm = icm;
	}
	
	

	
	
}	
