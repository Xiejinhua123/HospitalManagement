package cn.vote.action;

import cn.vote.model.BoxAwardsModel;
import cn.vote.service.GameService;

public class GameAction extends ActionBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6165710585728453522L;
	private GameService gameService;
	private Integer boxNumber;
	
	/**
	 * 开宝箱
	 */
	public void openTheBox(){
		
		try{
			BoxAwardsModel bam = this.gameService.openTheBox( this.boxNumber );
			super.setJson(bam);
			
		}catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public GameService getGameService() {
		return gameService;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}
















	public Integer getBoxNumber() {
		return boxNumber;
	}
















	public void setBoxNumber(Integer boxNumber) {
		this.boxNumber = boxNumber;
	}
}