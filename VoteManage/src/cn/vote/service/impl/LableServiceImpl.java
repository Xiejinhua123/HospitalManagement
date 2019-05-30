package cn.vote.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.vote.dao.LableDao;
import cn.vote.dao.UserLabelDao;
import cn.vote.dao.VotingRecordsDao;
import cn.vote.entity.Admin;
import cn.vote.entity.Lable;
import cn.vote.model.Constants;
import cn.vote.model.LabelModel;
import cn.vote.service.LableService;
import cn.vote.util.DateUtils;
import cn.vote.util.Page;
import cn.vote.util.WebUtil;

public class LableServiceImpl implements LableService {
	private LableDao lableDao;
	private UserLabelDao userLabelDao;
	private VotingRecordsDao votingRecordsDao;

	public void getAll(Page<LabelModel> page, Lable l) throws Exception {

		if (page == null)
			throw new Exception("getAll( Page<LabelModel> page) page为空");

		List<Lable> list = lableDao.getPage(page, null);
		List<LabelModel> list1 = new ArrayList<LabelModel>();
		for (Lable la : list) {
			LabelModel lm = new LabelModel();
			lm.setCreateTime(la.getCreateTime());
			lm.setEvent(la.getEvent());
			lm.setExplains(la.getExplains());
			lm.setId(la.getId());
			lm.setLableName(la.getLableName());
			lm.setDeletes(la.getDelete());
			Integer number = userLabelDao.getNumberByLableId(la.getId());
			lm.setNumber(number);
			list1.add(lm);
		}

		List<Lable> list2 = lableDao.getAll();

		if (list1 != null)
			page.setTotal(list2.size());

		page.setRows(list1);
	}

	@Override
	public List<LabelModel> getAllLabel() {
		List<LabelModel> list = new ArrayList<LabelModel>();
		List<Lable> list1 = lableDao.getAll();
		for (Lable lable : list1) {
			LabelModel lm = new LabelModel();
			lm.setId(lable.getId());
			lm.setLableName(lable.getLableName());
			lm.setDeletes(lable.getDelete());
			list.add(lm);
		}
		return list;
	}

	@Override
	public Lable getById(Integer id) throws Exception {
		if (id == null)
			throw new Exception("getById(Integer id) id为空");
		Lable la = lableDao.getById(id);
		return la;
	}

	@Override
	public boolean updateLable(Lable lable) throws Exception {
		if (lable == null)
			throw new Exception("update(Lable lable) lable为空");
		Lable l = lableDao.getById(lable.getId());
		if (l.getDelete().equals("1"))
			return false;
		l.setAdminByUpdate((Admin)WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
		l.setUpdateTime(new Date());
		l.setDelete("0");
		boolean b = lableDao.update(lable);
		return b;
	}

	// 先删除用户标签
	// 再删除标签
	@Override
	public boolean delete(Integer id) throws Exception {
		if (id == null)
			throw new Exception("update(Lable lable)lable为空");
		// 如果已经被删除不能再次删除
		Lable l1 = lableDao.getById(id);
		if (l1.getDelete().equals("1"))
			return false;

		userLabelDao.deleteByLabel(id);
		this.votingRecordsDao.deteleByLabel(id);
		Lable l = new Lable();
		l.setDelete("1");
		l.setUpdateTime(DateUtils.getNowTimestamp());
		l.setAdminByUpdate((Admin) WebUtil
				.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
		return lableDao.delete(l);
	}

	@Override
	public boolean addLable(Lable lable) throws Exception {
		if (lable == null)
			throw new Exception("addLable(Lable lable) lable为空");
		String date = DateUtils.dateToString(DateUtils.getCurrentDate(),
				DateUtils.YYYY_MM_DD_HH_MM_SS);
		lable.setCreateTime(Timestamp.valueOf(date));
		lable.setDelete("0");
		lable.setUpdateTime(DateUtils.getNewDate());
		lable.setAdminByUpdate((Admin) WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
		return lableDao.addLable(lable);
	}

	public LableDao getLableDao() {
		return lableDao;
	}

	public void setLableDao(LableDao lableDao) {
		this.lableDao = lableDao;
	}

	public UserLabelDao getUserLabelDao() {
		return userLabelDao;
	}

	public void setUserLabelDao(UserLabelDao userLabelDao) {
		this.userLabelDao = userLabelDao;
	}

	public VotingRecordsDao getVotingRecordsDao() {
		return votingRecordsDao;
	}

	public void setVotingRecordsDao(VotingRecordsDao votingRecordsDao) {
		this.votingRecordsDao = votingRecordsDao;
	}

}
