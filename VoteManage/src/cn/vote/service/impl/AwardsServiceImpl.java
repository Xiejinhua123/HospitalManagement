package cn.vote.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.vote.dao.AwardsDao;
import cn.vote.dao.BallDao;
import cn.vote.dao.GameDao;
import cn.vote.dao.GoodsDao;
import cn.vote.entity.Admin;
import cn.vote.entity.Awards;
import cn.vote.entity.Ball;
import cn.vote.entity.Goods;
import cn.vote.model.AwardsModel;
import cn.vote.model.Constants;
import cn.vote.service.AwardsService;
import cn.vote.util.DateUtils;
import cn.vote.util.Page;
import cn.vote.util.WebUtil;

public class AwardsServiceImpl implements AwardsService {

	private AwardsDao awardsDao;
	private BallDao ballDao;
	private GoodsDao goodsDao;
	private GameDao gameDao;

	@Override
	public void getAwardsByGameId(Page<AwardsModel> page, Integer gameId)
			throws Exception {
		if (gameId == null)
			throw new Exception("参数为空,查询游戏奖项错误");
		List<Awards> list = awardsDao.getByGameId(page, gameId);// 查询游戏奖项
		if (list == null)
			return;
		List<AwardsModel> list1 = new ArrayList<AwardsModel>();
		for (Awards awards : list) {
			AwardsModel a = new AwardsModel();
			a.setId(awards.getId());
			// 这里获取ball对象
			if (awards.getBallId() != null) {
				Ball b = ballDao.getById(awards.getBallId());
				a.setBallName(b.getBallName());
				a.setBallNumber(awards.getBallnumber());
			}
			// 这里获取商品对象
			if (awards.getGoodsId() != null) {
				Goods g = goodsDao.getById(awards.getGoodsId());
				a.setGoodsName(g.getGoodsName());
				a.setGoodsNumber(awards.getGoodsNumber());
			}
			a.setDeletes(awards.getDelete());
			a.setLoveNumber(awards.getLoveNumber());
			a.setBoxNumber(awards.getBoxNumber());
			a.setParticipation(awards.getParticipation());
			a.setProbability(awards.getProbability());
			list1.add(a);
		}
		page.setRows(list1);
		// 这里获取某个游戏奖项总条数
		Long num = awardsDao.getAllNumberByGameId(gameId);
		page.setTotal(num.intValue());
	}

	@Override
	public AwardsModel getById(Integer awardsID) {

		Awards awards = awardsDao.getById(awardsID);
		AwardsModel a = new AwardsModel();
		a.setId(awards.getId());
		// 这里获取ball对象
		if (awards.getBallId() != null) {
			Ball b = ballDao.getById(awards.getBallId());
			a.setBallName(b.getBallName());
			a.setBallNumber(awards.getBallnumber());
		}
		// 这里获取商品对象
		if (awards.getGoodsId() != null) {
			Goods g = goodsDao.getById(awards.getGoodsId());
			a.setGoodsName(g.getGoodsName());
			a.setGoodsNumber(awards.getGoodsNumber());
		}
		a.setLoveNumber(awards.getLoveNumber());
		a.setBoxNumber(awards.getBoxNumber());
		a.setParticipation(awards.getParticipation());
		a.setProbability(awards.getProbability());
		a.setDeletes(awards.getDelete());
		return a;
	}

	@Override
	public void deleteAward(Integer awardsID) throws ParseException {
		Awards a1 = awardsDao.getById(awardsID);
		if (a1.getDelete().equals("1"))
			return;
		Awards a = new Awards();
		a.setDelete("1");
		a.setUpdateTime(DateUtils.getNowTimestamp());
		a.setAdminByUpdate((Admin) WebUtil
				.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
		awardsDao.deleteAward(a);
	}

	@Override
	public void updateAward(AwardsModel a) {
		Awards a2 = awardsDao.getById(a.getId());
		if (a2.getDelete().equals("1"))
			return;
		Awards a1 = new Awards();
		a1.setId(a.getId());
		a1.setLoveNumber(a.getLoveNumber());
		a1.setBoxNumber(a.getBoxNumber());
		if (a.getGoodsName() != null && !a.getGoodsName().equals("")
				&& !a.getGoodsName().equals("无")) {
			Goods g = goodsDao.getByName(a.getGoodsName());
			a1.setGoodsId(g.getId());
			a1.setGoodsNumber(a.getGoodsNumber());
		}
		if (a.getBallName() != null && a.getBallName().equals("")
				&& !a.getGoodsName().equals("无")) {
			Ball b = ballDao.getByName(a.getBallName());
			a1.setBallId(b.getId());
			a1.setBallnumber(a.getBallNumber());
		}
		a1.setProbability(a.getProbability());
		a1.setParticipation(a.getParticipation());
		a1.setGame(gameDao.getGameById(2));
		a1.setAdminByUpdate((Admin)WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
		a1.setUpdateTime(new Date());
		a1.setDelete(a2.getDelete());
		awardsDao.updateAward(a1);
	}

	public AwardsDao getAwardsDao() {
		return awardsDao;
	}

	public void setAwardsDao(AwardsDao awardsDao) {
		this.awardsDao = awardsDao;
	}

	public BallDao getBallDao() {
		return ballDao;
	}

	public void setBallDao(BallDao ballDao) {
		this.ballDao = ballDao;
	}

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public GameDao getGameDao() {
		return gameDao;
	}

	public void setGameDao(GameDao gameDao) {
		this.gameDao = gameDao;
	}

	@Override
	public void addAwards(AwardsModel a) {
		Awards a1 = new Awards();
		a1.setId(a.getId());
		a1.setLoveNumber(a.getLoveNumber());
		a1.setBoxNumber(a.getBoxNumber());
		if (a.getGoodsName() != null && !a.getGoodsName().equals("")
				&& !a.getGoodsName().equals("无")) {
			Goods g = goodsDao.getByName(a.getGoodsName());
			a1.setGoodsId(g.getId());
			a1.setGoodsNumber(a.getGoodsNumber());
		}
		if (a.getBallName() != null && !a.getBallName().equals("")
				&& !a.getBallName().equals("无")) {
			Ball b = ballDao.getByName(a.getBallName());
			a1.setBallId(b.getId());
			a1.setBallnumber(a.getBallNumber());
		}
		a1.setProbability(a.getProbability());
		a1.setParticipation(a.getParticipation());
		a1.setUpdateTime(DateUtils.getCurrentDate());
		a1.setDelete("0");
		a1.setAdminByUpdate((Admin) WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
		a1.setGame(gameDao.getGameById(2));
		awardsDao.addAward(a1);

	}

}
