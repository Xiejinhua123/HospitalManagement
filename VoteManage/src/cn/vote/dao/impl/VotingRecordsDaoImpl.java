package cn.vote.dao.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.VotingRecordsDao;
import cn.vote.entity.Admin;
import cn.vote.entity.VotingRecords;
import cn.vote.model.Constants;
import cn.vote.util.DateUtils;
import cn.vote.util.WebUtil;

public class VotingRecordsDaoImpl extends HibernateDaoSupport implements
		VotingRecordsDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<VotingRecords> getByLableId(Integer id) {
		List<VotingRecords> list = super.getHibernateTemplate().find(
				"from VotingRecords where lable.id=?", id);
		if (list != null && list.size() >= 1)
			return list;
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VotingRecords> getByUserId(Integer id) {
		List<VotingRecords> list = super.getHibernateTemplate().find(
				"from VotingRecords where users.id=?", id);
		if (list != null && list.size() >= 1)
			return list;
		else
			return null;
	}

	@Override
	public void addVotingRecords(VotingRecords vr) {
		try {
			super.getHibernateTemplate().save(vr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deteleByLabel(Integer id) throws ParseException {

		List<VotingRecords> list = super.getHibernateTemplate().find(
				"from VotingRecords where lable.id = ? ", id);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setDelete("1");
			list.get(i).setUpdateTime(DateUtils.getNowTimestamp());
			list.get(i).setAdminByUpdate((Admin)WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
			super.getHibernateTemplate().delete(list.get(i));
		}

	}

}
