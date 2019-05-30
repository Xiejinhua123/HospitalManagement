package cn.vote.action;

import cn.vote.entity.Love;
import cn.vote.service.LoveService;

public class LoveAction extends ActionBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2287633563558612236L;
	private LoveService loveService;
	private Love love;
	
	
	public void getL()
	{
		try{
		Love l=loveService.getLove();
		if(l!=null) super.setJson(l);
		else super.setJson("false");
		}catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public void updateL()
	{
		try{
		loveService.updateLove(love);
		super.setJson("true");
		}catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	public LoveService getLoveService() {
		return loveService;
	}

	public void setLoveService(LoveService loveService) {
		this.loveService = loveService;
	}

	public Love getLove() {
		return love;
	}

	public void setLove(Love love) {
		this.love = love;
	}
	
}
