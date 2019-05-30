package cn.vote.service.impl;

import java.util.Date;

import cn.vote.dao.LoveDao;
import cn.vote.entity.Admin;
import cn.vote.entity.Love;
import cn.vote.model.Constants;
import cn.vote.service.LoveService;
import cn.vote.util.WebUtil;

public class LoveServiceImpl implements LoveService {

	private LoveDao loveDao;

	@Override
	public Love getLove() {
		return loveDao.getLove();
	}

	@Override
	public void updateLove(Love l) {
		Love l1=loveDao.getLove();
		if(l1.getDelete().equals("1")) return;
		l.setUpdateTime(new Date());
		l.setAdminByUpdate((Admin)WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
		loveDao.updateLove(l);
	}

	public LoveDao getLoveDao() {
		return loveDao;
	}

	public void setLoveDao(LoveDao loveDao) {
		this.loveDao = loveDao;
	}

}
