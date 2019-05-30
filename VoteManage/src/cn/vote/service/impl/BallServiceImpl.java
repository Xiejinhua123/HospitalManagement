package cn.vote.service.impl;

import java.util.Date;
import java.util.List;

import cn.vote.dao.BallDao;
import cn.vote.dao.UserBallDao;
import cn.vote.entity.Admin;
import cn.vote.entity.Ball;
import cn.vote.entity.UserBall;
import cn.vote.model.BallModel;
import cn.vote.model.Constants;
import cn.vote.service.BallService;
import cn.vote.util.WebUtil;

public class BallServiceImpl implements BallService {

	private BallDao ballDao;
	private UserBallDao userBallDao;

	@Override
	public boolean updateBall(Ball ball) throws Exception {
		if (ball == null)
			throw new Exception("updateBall(Ball ball) ball 为空");
		Ball b=ballDao.getById(ball.getId());
		if(b.getDelete().equals("1"))return false;
		ball.setUpdateTime(new Date());
		ball.setAdminByUpdate((Admin)WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
		return ballDao.update(ball);
	}

	@Override
	public List<Ball> getAll() throws Exception {

		List<Ball> list = ballDao.getAll();
		return list;
	}

	@Override
	public Ball getById(Integer id) throws Exception {
		if (id == null)
			throw new Exception("getById(Integer id) id 为空");
		return ballDao.getById(id);
	}

	@Override
	public BallModel getBallModelById(Integer id) throws Exception {
		if (id == null)
			throw new Exception("getById(Integer id) id 为空");
		Ball b = ballDao.getById(id);// 查询龙珠信息
		BallModel bm = new BallModel(); // 前台需要的龙珠模型
		List<UserBall> lub = userBallDao.getByballId(b.getId());// 根据龙珠id查询用户手中龙珠数量
		if (lub != null)
			bm.setUserballNumber(lub.size());// 用户手中龙珠数量
		else
			bm.setUserballNumber(0);

		bm.setExchangeNumber(b.getRecycleNumber());
		bm.setPutIntoNumber(b.getPutNumber());
		bm.setId(b.getId());
		bm.setBallName(b.getBallName());
		bm.setProbability(b.getProbability());
		bm.setText(b.getText());
		bm.setBallInstructions("龙珠说明");
		return bm;
	}

	public BallDao getBallDao() {
		return ballDao;
	}

	public void setBallDao(BallDao ballDao) {
		this.ballDao = ballDao;
	}

	public UserBallDao getUserBallDao() {
		return userBallDao;
	}

	public void setUserBallDao(UserBallDao userBallDao) {
		this.userBallDao = userBallDao;
	}
}
