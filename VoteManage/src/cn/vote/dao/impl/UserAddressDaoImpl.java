package cn.vote.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.UserAddressDao;
import cn.vote.entity.UserAddress;
import cn.vote.util.UtilHibernate;

public class UserAddressDaoImpl extends HibernateDaoSupport implements
		UserAddressDao {

	Logger logger = Logger.getLogger(UserAddressDaoImpl.class);

	@Override
	public void addAddress(UserAddress ua) {
		try {
			super.getHibernateTemplate().save(ua);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("用户地址添加失败");
		}
	}

	@Override
	public void deleteAddress(String u) {
		UserAddress a=super.getHibernateTemplate().get(UserAddress.class, u);
		super.getHibernateTemplate().delete(a);
	}

	@Override
	public void update(UserAddress u) {
		try {
			UserAddress a = super.getHibernateTemplate().get(UserAddress.class,
					u.getId());
			UserAddress ua = UtilHibernate.Compare(a, u);
			super.getHibernateTemplate().update(ua);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("修改用户地址失败");
		}

	}

	@Override
	public UserAddress getById(String id) {
		
		return super.getHibernateTemplate().get(UserAddress.class, id);
	}

	@Override
	public List<UserAddress> getAll() {
		List<UserAddress> list=super.getHibernateTemplate().find("from UserAddress");
		if(list==null) return list;
		return null;
	}
}
