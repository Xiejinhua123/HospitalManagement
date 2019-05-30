package cn.vote.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import cn.vote.dao.BallDao;
import cn.vote.dao.GoodsBallDao;
import cn.vote.dao.GoodsDao;
import cn.vote.entity.Ball;
import cn.vote.entity.Goods;
import cn.vote.entity.GoodsBall;
import cn.vote.model.GoodsBallModel;
import cn.vote.model.GoodsBall_Ball_Model;
import cn.vote.model.GoodsBall_Goods_Model;
import cn.vote.service.GoodsBallService;
import cn.vote.util.Page;

/**
 * 龙珠商品的实现类
 * 
 * @author 解金化
 * 
 */
public class GoodsBallServiceImpl implements GoodsBallService {

	private Logger log = Logger.getLogger(GoodsBallServiceImpl.class);
	private GoodsBallDao goodsBallDao;
	private GoodsDao goodsDao;
	private BallDao ballDao;

	@Override
	public void getAllGoodsBall(Page<GoodsBallModel> page) throws Exception {

		if (null == page) {
			throw new Exception("分页查询龙珠兑换商品详情的时候参数异常");
		}

		String path = "/VoteManage/pagefile/image/ballImage/";

		// 分页获取当前的数据库中的集合
		List<GoodsBall> list = null;
		try {
			list = goodsBallDao.getPage(page);

		} catch (Exception e) {
			log.error("在分页查询龙珠兑换商品的时候出错");
			throw new Exception("在分页查询龙珠兑换商品的时候出错");
		}

		/**
		 * 该集合中含有的对象：编号，商品的json字符串，龙珠的json字符串 当前需要的是龙珠的实体信息和商品的实体信息
		 * 
		 * 首先需要解析获取到的json字符串
		 * 
		 * 1、通过各自的编号获取各自的对象 2、将对象中的信息提取出来放在模型中 3、模型内的数据将存储到集合中
		 * 4、将集合中的信息放在大模型（龙珠兑换商品模型）中 5、返回到page的集合中
		 */

		List<GoodsBallModel> gbm = new ArrayList<GoodsBallModel>(); // 这个集合对象就要被放入到页面中去

		for (GoodsBall gb : list) {

			// 先做商品部分
			String goodsJson = gb.getGoodsIds(); // 获取到商品的的json应该是一个map

			Map<Object, Object> goodsMap = (Map<Object, Object>) JSON
					.parse(goodsJson);
			List<GoodsBall_Goods_Model> ggmList = new ArrayList<GoodsBall_Goods_Model>(); // 该集合是当前的商品模型
			for (Object o : goodsMap.keySet()) {

				Integer goodsId = Integer.parseInt(o.toString()); // 获取到当前的商品的编号

				Goods goods = new Goods();
				try {
					goods = goodsDao.getById(goodsId);
				} catch (Exception e) {
					log.error("通过商品的编号查询商品失败");
					throw new Exception("通过商品的编号查询商品失败");
				}
				try {
					GoodsBall_Goods_Model ggm = new GoodsBall_Goods_Model();
					if (goods != null) {
						ggm.setId(goods.getId());
						ggm.setName(goods.getGoodsName());
						ggm.setUrl(goods.getUrl()); // 商品图片
						ggm.setNumber(Integer.parseInt(goodsMap.get(o)
								.toString()));
						ggmList.add(ggm);
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("赋值失败");
				}
			}

			// 接下来做龙珠部分
			String ballJson = gb.getProduct(); // 获取到龙珠的json

			Map<Object, Object> map = (Map<Object, Object>) JSON
					.parse(ballJson);
			List<GoodsBall_Ball_Model> gbbList = new ArrayList<GoodsBall_Ball_Model>();
			for (Object o : map.keySet()) {

				Integer ballId = Integer.parseInt(o.toString());
				Ball ball = new Ball();
				try {
					ball = ballDao.getById(ballId);
				} catch (Exception e) {
					log.error("通过龙珠编号查询龙珠失败" + e.getMessage());
					throw new Exception("通过龙珠编号查询龙珠失败");
				}

				GoodsBall_Ball_Model gbm1 = new GoodsBall_Ball_Model();
				if (ball != null) {
					gbm1.setId(ball.getId());
					gbm1.setName(ball.getBallName());
					gbm1.setNumber(Integer.parseInt(map.get(o).toString()));
					gbm1.setUrl(path + ball.getImgurl());
					gbbList.add(gbm1);
				}
			}

			/**
			 * 在这里需要做一次排序 让龙珠按照编号 从小到大排列
			 */

			// 最后把所有的信息放入集合中

			GoodsBallModel goodsBallModel = new GoodsBallModel();
			goodsBallModel.setGbb(gbbList);
			goodsBallModel.setGbg(ggmList);
			goodsBallModel.setId(gb.getId());
			gbm.add(goodsBallModel);
		}

		page.setRows(gbm); // 将获取到的集合对象放入到page对象中
	}

	public GoodsBallDao getGoodsBallDao() {
		return goodsBallDao;
	}

	public void setGoodsBallDao(GoodsBallDao goodsBallDao) {
		this.goodsBallDao = goodsBallDao;
	}

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public BallDao getBallDao() {
		return ballDao;
	}

	public void setBallDao(BallDao ballDao) {
		this.ballDao = ballDao;
	}
}
