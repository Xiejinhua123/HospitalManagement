package cn.vote.dao;

import java.util.List;

import cn.vote.entity.RewardGrade;

public interface RewardGradeDao {

	/**
	 * 修改档位
	 * @param r 
	 */
	void updateRewardGrade(RewardGrade r);
	
	/**
	 * 添加档位
	 * @param r
	 */
	void addRewardGrade(RewardGrade r);
	
	/**
	 * 删除档位
	 * @param id
	 */
	void delRewardGrade(RewardGrade r);
	
	List<RewardGrade> getAll();
	
	/**
	 * 根据id查询档位
	 * @param r
	 * @return
	 */
	List<RewardGrade> getById(Integer r);
}
