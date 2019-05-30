package cn.vote.dao;

import java.util.List;

import cn.vote.entity.Ball;

/**
 * 龙珠表的增删查改查
 * 
 * @author 解金化
 *
 */
public interface BallDao {

	/**
	 * 根据编号查询龙珠
	 * @param 龙珠编号
	 * @return
	 * 		龙珠实体
	 */
	Ball getById(Integer ballId);

	/**
	 * 修改龙珠信息
	 * @param ball
	 * 		待修改的龙珠的实体
	 * @return
	 * 		是否执行成功
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	boolean update(Ball ball) throws IllegalArgumentException, IllegalAccessException;

	/**
	 * 获取所有的龙珠信息
	 * @return
	 * 		获取到的所有信息
	 */
	List<Ball> getAll();
	
	public Ball getByName(String name);

}
