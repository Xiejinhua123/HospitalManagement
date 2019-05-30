package cn.vote.action;

import cn.vote.model.AwardsModel;
import cn.vote.service.AwardsService;
import cn.vote.util.Page;

@SuppressWarnings("serial")
public class AwardsAction extends ActionBase{

	private AwardsService awardsService;
	private Page<AwardsModel> page=new Page<AwardsModel>();
	private Integer gameId;//游戏id
	private Integer item;
	private Integer pageSize;
	private Integer awardId;//游戏奖项id
	private AwardsModel awards;//游戏奖项
	
	/**
	 * 获取开宝箱奖励
	 */
	public void getAweardsByGameId()
	{
		try {
			page.setItems(item);
			page.setPageSize(pageSize);
			awardsService.getAwardsByGameId(page, gameId);
			super.setJson(page);
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
		
	}
	
	public void getAwardsById()
	{

		try {
			awards =awardsService.getById(awardId);
			if(awards!=null)super.setJson(awards);
			else super.setJson("fail");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	public void deleteAwards()
	{
		try {
			awardsService.deleteAward(awardId);
			super.setJson("success");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	public void updateAwards()
	{

		try {
			awardsService.updateAward(awards);
			super.setJson("success");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public void addAwards()
	{

		try {
			awardsService.addAwards(awards);
			super.setJson("success");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public AwardsService getAwardsService() {
		return awardsService;
	}
	public void setAwardsService(AwardsService awardsService) {
		this.awardsService = awardsService;
	}
	public Page<AwardsModel> getPage() {
		return page;
	}
	public void setPage(Page<AwardsModel> page) {
		this.page = page;
	}
	public Integer getGameId() {
		return gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	public Integer getItem() {
		return item;
	}
	public void setItem(Integer item) {
		this.item = item;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getAwardId() {
		return awardId;
	}
	public void setAwardId(Integer awardId) {
		this.awardId = awardId;
	}

	public AwardsModel getAwards() {
		return awards;
	}

	public void setAwards(AwardsModel awards) {
		this.awards = awards;
	}
	
	
}
