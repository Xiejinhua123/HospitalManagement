package cn.vote.service;

import java.text.ParseException;
import cn.vote.model.AwardsModel;
import cn.vote.util.Page;

public interface AwardsService {

	
	/**
	 * 根据游戏编号获取游戏获奖信息
	 * @param gameId
	 * @return
	 * @throws Exception
	 */


	void getAwardsByGameId(Page<AwardsModel> page, Integer gameId)
			throws Exception;

	
	
	AwardsModel getById(Integer awardsID);
	/**
	 * 删除游戏奖项
	 * @param awardsID 游戏奖项id
	 * @throws ParseException 
	 */
	void deleteAward(Integer awardsID) throws ParseException;
	/**
	 * 修改游戏奖项
	 * @param awardsID 游戏奖项id
	 */
	void updateAward(AwardsModel a);


	void addAwards(AwardsModel a);

}
