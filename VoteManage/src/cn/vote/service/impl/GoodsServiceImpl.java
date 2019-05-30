package cn.vote.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.vote.dao.GoodsConversionDao;
import cn.vote.dao.GoodsDao;
import cn.vote.dao.GoodsImgDao;
import cn.vote.dao.RewardGoodsDao;
import cn.vote.entity.Admin;
import cn.vote.entity.Goods;
import cn.vote.entity.GoodsConversion;
import cn.vote.entity.GoodsImg;
import cn.vote.entity.RewardGoods;
import cn.vote.model.Constants;
import cn.vote.model.GoodsModel;
import cn.vote.service.GoodsService;
import cn.vote.util.DateUtils;
import cn.vote.util.ImageCutModel;
import cn.vote.util.Page;
import cn.vote.util.ParamCheck;
import cn.vote.util.WebUtil;

public class GoodsServiceImpl implements GoodsService {

	private GoodsDao goodsDao;
	private GoodsImgDao goodsImgDao;
	private GoodsConversionDao goodsConversionDao;
	private RewardGoodsDao rewardGoodsDao;

	@Override
	public void getPageGoods(Page page, String name) throws Exception {
		if (null == page)
			throw new Exception("getPageGoods(Page<Goods> page) page 对象为空");
		System.out.println("name:" + name);
		if (name == "" || name == null || name.toString() == "") {
			goodsDao.getPageAll(page, null);
		} else
			goodsDao.getPageAll(page, name);
		List<GoodsModel> list1 = new ArrayList<GoodsModel>();
		for (Object good : page.getRows()) {
			Goods goods = (Goods) good;
			GoodsModel gm = new GoodsModel();
			gm.setId(goods.getId());
			gm.setDeleteds(goods.getDelete());
			gm.setGoodsName(goods.getGoodsName());
			gm.setDescription(gm.getDescription());
			gm.setLoveNumber(goods.getLoveNumber());
			gm.setShelvesStatus(goods.getShelvesStatus());
			gm.setUrl(goods.getUrl());
			list1.add(gm);
		}
		page.setRows(list1);
	}

	@SuppressWarnings("unused")
	@Override
	public boolean updateGoods(Goods g) throws Exception {
		if (null == g) throw new Exception("updateGoods(Goods g) g对象为空");
			
		
		Goods g1 = goodsDao.getById(g.getId());
		g1.setUpdateTime(new Date());
		g1.setDelete("0");
		g1.setAdminByUpdate((Admin)WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
		if (g1.getDelete().equals("1"))
			return true;
		return goodsDao.updaupdateGoods(g);
	}

	@Override
	public GoodsModel findGoodsById(Integer id) throws Exception {
		if (null == id)
			throw new Exception("findGoodsById(Integer id) id 为空");
		Goods goods = goodsDao.getById(id);
		GoodsModel gm = new GoodsModel();
		gm.setDeleteds(goods.getDelete());
		gm.setId(goods.getId());
		gm.setGoodsName(goods.getGoodsName());
		gm.setLoveNumber(goods.getLoveNumber());
		gm.setShelvesStatus(goods.getShelvesStatus());
		return gm;
	}

	/**
	 * 根据id删除商品 删除前先删除商品图片
	 */
	@Override
	public boolean delById(Integer id) throws Exception {
		if (null == id)
			throw new Exception("deleteById(Integer id) id 为空");
		Goods g2 = goodsDao.getById(id);
		if (g2.getDelete().equals("1"))
			return true;
		boolean b = true;
		try {
			goodsImgDao.deleteGoodImg(id);
			GoodsConversion g = new GoodsConversion();
			g.setDelete("1");
			g.setUpdateTime(DateUtils.getNowTimestamp());
			g.setAdminByUpdate((Admin) WebUtil
					.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
			this.goodsConversionDao.deleteByGoods(g);
			RewardGoods rg = new RewardGoods();
			rg.setDelete("1");
			rg.setUpdateTime(DateUtils.getNowTimestamp());
			rg.setAdminByUpdate((Admin) WebUtil
					.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
			this.rewardGoodsDao.deleteByGoods(rg);
			Goods g1 = new Goods();
			g1.setDelete("1");
			g1.setUpdateTime(DateUtils.getNowTimestamp());
			g1.setAdminByUpdate((Admin) WebUtil
					.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
			goodsDao.delete(g1);
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	@Override
	public List<String> getAllGoodsName() {
		try {
			List<String> list = goodsDao.getAllGoodsName();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 添加商品
	 */
	@Override
	public void addGoods(Goods goods, String[] paths, ImageCutModel icm)
			throws Exception {
		if (ParamCheck.checked(goods, new String[] { "description",
				"shelvesStatus", "id" }))
			throw new Exception("添加商品参数为空");
		try {
			goods.setShelvesStatus(0);
			goods.setUrl(paths[0]);
			goods.setDelete("0");
			goods.setUpdateTime(DateUtils.getCurrentDate());
			goods.setAdminByUpdate((Admin) WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
			goodsDao.add(goods);

		} catch (Exception e) {
			throw new Exception("数据库添加商品出错");
		}
		if (null != paths && paths.length > 0) {
			String conpath = ServletActionContext.getServletContext()
					.getRealPath("");

			conpath = conpath.replace('\\', '/');
			conpath = conpath.substring(0, conpath.lastIndexOf('/'));

			System.out.println(conpath);
			for (int i = 0; i < paths.length; i++) {

				final String path = paths[i];

				GoodsImg gi = new GoodsImg();
				gi.setGoods(goods);
				gi.setImgUrl(path);
				Integer id = goods.getId();
				gi.setId(id.toString() + i);
				try {
					goodsImgDao.add(gi);
				} catch (Exception e) {
					throw new Exception("添加商品的图片的路径出错");
				}
				icm = new ImageCutModel();
				icm.setNewPath(conpath + path);
				icm.setOldPath(conpath + path);
				icm.setHeight(180);
				icm.setWidth(150);

				GoodsImgCut gic = new GoodsImgCut();
				gic.setImgCutModel(icm);
				gic.start();
			}
		}
	}

	public GoodsImgDao getGoodsImgDao() {
		return goodsImgDao;
	}

	public void setGoodsImgDao(GoodsImgDao goodsImgDao) {
		this.goodsImgDao = goodsImgDao;
	}

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public GoodsConversionDao getGoodsConversionDao() {
		return goodsConversionDao;
	}

	public void setGoodsConversionDao(GoodsConversionDao goodsConversionDao) {
		this.goodsConversionDao = goodsConversionDao;
	}

	public RewardGoodsDao getRewardGoodsDao() {
		return rewardGoodsDao;
	}

	public void setRewardGoodsDao(RewardGoodsDao rewardGoodsDao) {
		this.rewardGoodsDao = rewardGoodsDao;
	}
}

/**
 * 图片切割
 * 
 * 需要一个属性，属性必须是图片切割的对象，含有完整属性信息的对象
 * 
 * 该功能相对应的往后推迟
 * 
 * 暂时不实现
 * 
 * @author 解金化
 * 
 */
class GoodsImgCut extends Thread {

	private ImageCutModel imgCutModel;

	@Override
	public void run() {
		// ImageCut.abscut(imgCutModel.getOldPath(), imgCutModel.getNewPath(),
		// imgCutModel.getX(), imgCutModel.getY(), imgCutModel.getWidth(),
		// imgCutModel.getHeight());
	}

	public void setImgCutModel(ImageCutModel imgCutModel) {
		this.imgCutModel = imgCutModel;
	}
}
