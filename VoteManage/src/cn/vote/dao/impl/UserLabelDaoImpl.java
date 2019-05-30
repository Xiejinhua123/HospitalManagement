package cn.vote.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.UserLabelDao;
import cn.vote.entity.UserLabel;
import cn.vote.model.UserModel;
import cn.vote.util.Page;
import cn.vote.util.UtilHibernate;

public class UserLabelDaoImpl extends HibernateDaoSupport implements
		UserLabelDao {

	Logger logger = Logger.getLogger(UserLabelDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<UserLabel> getUserLabeAll(String userId) {
		try {
			List<UserLabel> list = super.getHibernateTemplate().find(
					"from UserLabel where users.id=?", userId);
			if (list != null && list.size() > 0)
				return list;
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("获取用户标签失败");
			return null;
		}
		return null;
	}

	@Override
	public void addLabel(UserLabel userLabel) {
		try {
			super.getHibernateTemplate().save(userLabel);
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("添加用户标签失败");
		}
	}

	@Override
	public void delLabel(UserLabel userLabel) {
		try {
			super.getHibernateTemplate().delete(userLabel);
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("删除用户标签失败");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserLabel getById(String  usersId, Integer labelId) {

		try {
			List<UserLabel> list = super.getHibernateTemplate().find(
					"from UserLabel where users.id=? and lable.id=?", usersId,
					labelId);
			if (list != null && list.size() > 0)
				return list.get(0);
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("获取用户标签失败");
			return null;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getNumberByLableId(Integer labelId) {
		try {
			List<Long> list = super.getHibernateTemplate()
					.find("select count(id) from UserLabel where lable.id=?",
							labelId);
			return list.get(0).intValue();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteByLabel(Integer labelId) {
		try {
			List<UserLabel> list = super.getHibernateTemplate().find(
					"from UserLabel where lable.id=?", labelId);
			if (list != null && list.size() > 0) {
				for (UserLabel userLabel : list) {
					super.getHibernateTemplate().delete(userLabel);
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("删除用户标签失败");
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<UserLabel> getUserByLabelId(Page<UserModel> p, Integer LabelId) {
		try {
			Session s = this.getSession();
			Query q = s.createQuery("from UserLabel where lable.id=?");
			q.setParameter(0, LabelId);
			q.setMaxResults(p.getItems());
			int num = (p.getPageSize() - 1) * p.getItems();
			q.setFirstResult(num);
			List<UserLabel> list = q.list();
			if (list != null && list.size() > 0)
				return list;
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("获取用户失败");
			return null;
		}
		return null;
	}

	@Override
	public void doVote(UserLabel userLabel) {
		super.getHibernateTemplate().update(userLabel);
	}

	@Override
	public List<UserLabel> getUserByLabelIdTop10(Integer labelId) {
		try {
			Session s = this.getSession();
			Query q = s.createQuery("from UserLabel where lable.id=? order by voteNumber desc");
			q.setParameter(0, labelId);
			q.setMaxResults(10);
			q.setFirstResult(0);
			List<UserLabel> list = q.list();
			if (list != null && list.size() > 0)
				return list;
		} catch (Exception e) {
			e.getStackTrace();
			logger.error("获取用户失败");
			return null;
		}
		return null;
	}

	@Override
	public List<UserLabel> getExpert() {
		Session s = this.getSession();
		Query q = s.createQuery("from UserLabel group by users.id order by count(voteNumber) desc");
		q.setMaxResults(10);
		q.setFirstResult(0);
		return q.list();
	}
	@Override
	public List<Long> getExpertNumber() {
		Session s = this.getSession();
		Query q = s.createQuery("select sum(voteNumber) from UserLabel group by users.id order by count(voteNumber) desc");
		q.setMaxResults(10);
		q.setFirstResult(0);
		return q.list();
	}
	
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext*.xml");
		UserLabelDaoImpl u=ac.getBean(UserLabelDaoImpl.class);
		List<Long> list=u.getExpertNumber();
		for (Long userLabel : list) {
			System.out.println(userLabel);
		}
	}
}
