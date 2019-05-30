package cn.vote.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.RechargeRecordDao;

public class RechargeRecordDaoImpl extends HibernateDaoSupport implements RechargeRecordDao {

	@Override
	public Integer getAllPay(String id) {
		
		String sql = "select sum(payMoney) from RechargeRecord r where r.id = ?";
		
		Query query = getSession().createQuery(sql);
		query.setString(0, id);
		
		return (Integer)query.uniqueResult();
	}

}
