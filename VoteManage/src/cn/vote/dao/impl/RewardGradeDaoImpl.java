package cn.vote.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.RewardGradeDao;
import cn.vote.entity.RewardGrade;

public class RewardGradeDaoImpl extends HibernateDaoSupport implements RewardGradeDao{

	@Override
	public void updateRewardGrade(RewardGrade r) {
		try{
			super.getHibernateTemplate().update(r);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addRewardGrade(RewardGrade r) {
		try{
			super.getHibernateTemplate().save(r);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delRewardGrade(RewardGrade r) {
		this.updateRewardGrade(r);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RewardGrade> getAll() {
		try{
			List<RewardGrade> r=super.getHibernateTemplate().find("from RewardGrade");
			if(r!=null)return r;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RewardGrade> getById(Integer r) {
		try{
			List<RewardGrade> list=super.getHibernateTemplate().find("from RewardGrade where id=?",r);
			if(list!=null)	return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
