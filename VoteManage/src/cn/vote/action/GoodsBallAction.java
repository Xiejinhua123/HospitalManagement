package cn.vote.action;

import cn.vote.model.GoodsBallModel;
import cn.vote.service.GoodsBallService;
import cn.vote.util.Page;

/**
 * 龙珠会换商品
 * 
 * @author 解金化
 * 
 * @date 2017.07.23
 *
 */
public class GoodsBallAction extends ActionBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9212655550140590933L;
	private GoodsBallService goodsBallService;
	private Page<GoodsBallModel> page = new Page<GoodsBallModel>();
	
	/**
	 * 获取所有的龙珠兑换商品情况
	 */
	public void getGoodsBall(){
		
		try{
			goodsBallService.getAllGoodsBall( page );
			super.setJson(page);
			
		}catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public GoodsBallService getGoodsBallService() {
		return goodsBallService;
	}
	public void setGoodsBallService(GoodsBallService goodsBallService) {
		this.goodsBallService = goodsBallService;
	}




















	public Page<GoodsBallModel> getPage() {
		return page;
	}




















	public void setPage(Page<GoodsBallModel> page) {
		this.page = page;
	}


















}
