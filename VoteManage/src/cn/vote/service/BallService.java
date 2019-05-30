package cn.vote.service;

import java.util.List;

import cn.vote.entity.Ball;
import cn.vote.model.BallModel;

public interface BallService {
	/**
	 * 修改龙珠信息
	 * @param ball
	 * @return
	 */
	public boolean updateBall(Ball ball) throws Exception;
	
	public List<Ball> getAll() throws Exception;
	
	public Ball getById(Integer id)  throws Exception;
	/**
	 * 根据id查询龙珠信息.发放数量.使用情况
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BallModel getBallModelById(Integer id)  throws Exception;
	
}
