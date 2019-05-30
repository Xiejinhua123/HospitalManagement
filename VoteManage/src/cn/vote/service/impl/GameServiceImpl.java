package cn.vote.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.vote.dao.AwardsDao;
import cn.vote.dao.BallDao;
import cn.vote.dao.GameDao;
import cn.vote.dao.GameRcordDao;
import cn.vote.dao.GoodsDao;
import cn.vote.dao.LoveDao;
import cn.vote.entity.Awards;
import cn.vote.entity.Love;
import cn.vote.entity.Users;
import cn.vote.model.BoxAwardsModel;
import cn.vote.model.Constants;
import cn.vote.service.GameService;
import cn.vote.util.WebUtil;

public class GameServiceImpl implements GameService {

	private GameDao gameDao;
	private GameRcordDao gameRcordDao;
	private LoveDao loveDao;
	private AwardsDao awardsDao; // 奖项设置
	private BallDao ballDao;
	private GoodsDao goodsDao;

	@Override
	public BoxAwardsModel openTheBox(Integer boxNumber) throws Exception {

		if (!(boxNumber > 0)) {
			throw new Exception("开宝箱数量为0");
		}

		Users user = (Users) WebUtil
				.getSessionAttribute(Constants.SESSION_USER_KEY);

		BoxAwardsModel bam = null;

		Love love = loveDao.getLove();

		List<Awards> awards = this.awardsDao.getByGameId(2); // 这个奖项应该是按照概率从小到大自动排列

		if (!(love.getProportion() > 0)) { // 当前爱心没有了投放量 ， 参与开宝箱游戏 没有中奖
			/**
			 * 爱心的投放量已经没有了，这个时候，奖项中的爱心出现的几率给改为0
			 */
			for (Awards a : awards) {
				if (null != a.getLoveNumber() && a.getLoveNumber() > 0) {
					a.setProbability((float) 0);
				}
			}
		}

		return bam;
	}

	/**
	 * 开宝箱
	 * 
	 * @param number
	 *            宝箱数量
	 * @param awards
	 *            奖项
	 * @return 获取到的信息
	 */
	@Override
	public BoxAwardsModel getBam(Integer number, List<Awards> awards) {
		// 打算利用充值量和获得过的商品总量来进行计算，考虑中。。。
		// Integer pay = this.rechargeRecordDao.getAllPay( user.getId() ); //
		// 获取当前用户的总的充值量

		BoxAwardsModel bam = new BoxAwardsModel();

		float[] fs = getProbability(awards); // 获取概率问题
		float[][] re = getProbabilitySection(fs); // 获取概率区间

		// 开始随机选中抽奖项
		Map<String, Integer> balls = null; // 中奖的龙珠信息
		Map<String, Integer> goods = null; // 中奖的商品信息
		for (int i = 0; i < number; i++) { // 开始进行循环宝箱

			double random = Math.random();

			int j = -1;
			j = getIndex(random, re);
			if (j == -1) {
				continue;
			}

			Awards a = awards.get(j);
			if (a.getBallId() != null) { // 获取到的是龙珠
				String ballname = ballDao.getById(a.getBallId()).getBallName();

				if (null == balls) { // 开宝箱首次开启龙珠 ， 为龙珠项创建对象

					balls = new HashMap<String, Integer>();
					balls.put(ballname, a.getBallnumber());
				} else {
					if (balls.containsKey(ballname)) { // 判断是否已经存在的抽到的龙珠
						Integer b = balls.get(ballname) != null ? balls
								.get(ballname) : 0; // 临时存放该变量,获取原有的龙珠数量
						b += a.getBallnumber();
						balls.put(ballname, b); // 替换掉原有的数量
					}
				}
				System.out.println(i + "：抽中龙珠");
				continue;
			} else if (a.getBoxNumber() != null) { // 宝箱开出宝箱
				if (null != bam.getBoxNumber()) { // 给定箱子数量
					bam.setBoxNumber(bam.getBoxNumber() + a.getBoxNumber());
				} else {
					bam.setBoxNumber(a.getBoxNumber());
				}
				System.out.println(i + "：抽中宝箱");
				continue;
			} else if (a.getLoveNumber() != null) { // 宝箱开出爱心
				if (null != bam.getLovaNumber()) { // 给定箱子数量
					bam.setLovaNumber(bam.getLovaNumber() + a.getLoveNumber());
				} else {
					bam.setLovaNumber(a.getLoveNumber());
				}
				System.out.println(i + "：抽中爱心，数量为：" + a.getLoveNumber());
				continue;
			} else if (a.getGoodsId() != null) { // 开出的是商品
				String goodsName = goodsDao.getById(a.getGoodsId())
						.getGoodsName(); // 商品名称

				if (null == goods) { // 开宝箱首次开启商品，为商品创建对象

					goods = new HashMap<String, Integer>();
					goods.put(goodsName, a.getGoodsNumber());
				} else {
					if (goods.containsKey(goodsName)) { // 判断是否已经存在的抽到的龙珠
						Integer b = goods.get(goodsName) != null ? goods
								.get(goodsName) : 0; // 临时存放该变量,获取原有的龙珠数量
						b += a.getGoodsNumber();
						goods.put(goodsName, b); // 替换掉原有的数量
					}
				}
				System.out.println(i + "：抽中商品");
				continue;
			}
		}
		bam.setBalls(balls);
		bam.setGoods(goods);
		return bam;
	}

	/**
	 * 通过给定的随机数信息获取到当前的随机数位于的概率区间是在什么地方
	 * 
	 * 将会返回奖项的下标
	 * 
	 * @param random
	 *            给定的随机数
	 * @param fs
	 *            对应的概率区间
	 * @return 奖项下标
	 */
	private int getIndex(double random, float[][] re) {

		for (int i = 0; i < re.length; i++) {
			if (random > re[i][0] && random <= re[i][1]) {
				return i;
			} else {
				continue;
			}
		}
		return -1;
	}

	/**
	 * 通过数据库中查询到的游戏的奖项信息，<br/>
	 * 
	 * 获取到奖项对应的概率信息<br/>
	 * 
	 * 通过概率获取到当前的概率所占的比重<br/>
	 * 
	 * 重新计算比重<br/>
	 * 
	 * @param awards
	 *            奖项集合
	 * @return 概率所占比重集合
	 */
	private float[] getProbability(List<Awards> awards) {
		/**
		 * 原来中的，数据库中的概率信息
		 */
		float[] fs = new float[awards.size()]; // 获取概率，奖项对应的概率 并且
												// 这个概率数组的下标跟奖项对应，中间不能修改

		float sum = 0; // 计算概率之和

		for (int i = 0; i < awards.size(); i++) {
			fs[i] = awards.get(i).getProbability();
			sum += fs[i];
		}
		// 在获取到所有的概率后，需要计算其中的每个部分所占有的权重

		/**
		 * 新的需要返回的概率数组，其中的概率信息包含了所在奖项所占比重
		 */
		float[] newFs = new float[fs.length];
		for (int i = 0; i < fs.length; i++) {
			float linshi = fs[i] / sum;
			newFs[i] = linshi;
		}
		return newFs;
	}

	/**
	 * 通过给定的概率数组，计算出相对应的概率区间
	 * 
	 * @param fs
	 *            概率数组
	 * @return 概率区间数组<br/>
	 * 
	 *         这是一个二维数组，数组中的每一项将会从小到大排列<br/>
	 * 
	 *         二维部分数组同样按照从小到大排列
	 */
	@SuppressWarnings("unused")
	private float[][] getProbabilitySection(float[] fs) {

		float[][] re = new float[fs.length][2]; // 定义需要返回的二维数组对象

		for (int i = 0; i < fs.length; i++) {
			if (i == 0) {
				re[i][0] = 0;
				re[i][1] = fs[i];
			} else {
				re[i][0] = fs[i - 1];
				re[i][1] = fs[i];
			}
		}
		return re;
	}

	public static void main(String[] args) {
		GameServiceImpl g = new GameServiceImpl();
		float[] f = new float[5];
		f[0] = (float) 0.1;
		f[1] = (float) 0.2;
		f[2] = (float) 0.3;
		f[3] = (float) 0.4;
		f[4] = (float) 0.5;
		float[][] fs = g.getProbabilitySection(f);
		for (int i = 0; i < fs.length; i++) {
			System.out.print(fs[i][0] + "\t" + fs[i][1] + "\t");
		}
	}

	public GameDao getGameDao() {
		return gameDao;
	}

	public void setGameDao(GameDao gameDao) {
		this.gameDao = gameDao;
	}

	public GameRcordDao getGameRcordDao() {
		return gameRcordDao;
	}

	public void setGameRcordDao(GameRcordDao gameRcordDao) {
		this.gameRcordDao = gameRcordDao;
	}

	public LoveDao getLoveDao() {
		return loveDao;
	}

	public void setLoveDao(LoveDao loveDao) {
		this.loveDao = loveDao;
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
}
