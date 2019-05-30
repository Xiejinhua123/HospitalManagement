package cn.vote.dao;

import java.util.List;

import cn.vote.entity.Awards;
import cn.vote.model.AwardsModel;
import cn.vote.util.Page;

public interface AwardsDao {

	/**
	 * 根据游戏编号，获取当前的游戏的所有奖项
	 * 
	 * 这个方法应该是按照概率从小到大排列
	 * 
	 * @param string
	 * 		游戏编号
	 * @return
	 * 		游戏对应的奖项
	 */
	List<Awards> getByGameId(Page<AwardsModel> page, Integer id);
	
	/**
	 * 根据游戏id查询游戏奖项
	 * @param id 游戏id
	 * @return
	 */
	List<Awards> getByGameId(Integer id);

	/**
	 * 获取所有游戏奖项数量
	 * @return
	 */
	Long getAllNumber();
	
	/**
	 * 根据游戏id查询游戏奖项数量
	 * @param id
	 * @return
	 */
	Long getAllNumberByGameId(Integer id );

	Awards getById(Integer awardsID);
	/**
	 * 删除游戏奖项
	 * @param awardsID 游戏奖项id
	 */
	void deleteAward(Awards a);
	/**
	 * 修改游戏奖项
	 * @param awardsID 游戏奖项id
	 */
	void updateAward(Awards a);
	
	void addAward(Awards a);
}
