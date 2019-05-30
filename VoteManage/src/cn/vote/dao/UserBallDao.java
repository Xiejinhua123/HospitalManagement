package cn.vote.dao;

import java.util.List;

import cn.vote.entity.UserBall;

public interface UserBallDao {
	
	/**
	 * 根据龙珠id查询龙珠兑换记录
	 * @param id 龙珠id
	 * @return	所有用户手中该龙珠数量
	 */
	public List<UserBall> getByballId(Integer BallId);
	 
	/**
	 * 通过用户查找当前的用户的所有的龙珠的总数
	 * 
	 * @param id
	 * 		用户编号
	 * @return
	 * 		龙珠总数
	 */
	public Integer getUserballById(String id);
	
	/**
	 * 根据用户id查询用户龙珠集合
	 * @param usersId
	 * @return
	 */
	public List<UserBall> getByUserId(String usersId);
	
	/**
	 * 计算用户某个龙珠数量
	 * @param userId 用户ID
	 * @param BallId 龙珠id
	 * @return	龙珠个数
	 */
	public Integer getBallNumber(String userId,Integer BallId );
	
	/**
	 * 添加用户龙珠数据
	 */

	void addUserBall(UserBall ub);
	
	/**
	 * 修改
	 * @param ub
	 */
	void update(UserBall ub);
	
	
}
