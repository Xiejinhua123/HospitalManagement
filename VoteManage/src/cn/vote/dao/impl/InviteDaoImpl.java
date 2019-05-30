package cn.vote.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.vote.dao.InviteDao;
import cn.vote.entity.Invite;

public class InviteDaoImpl extends HibernateDaoSupport implements InviteDao{

	@Override
	public void addInvite(Invite i) {
		super.getHibernateTemplate().save(i);
	}

	@Override
	public void updateInvite(Invite i) {
		super.getHibernateTemplate().update(i);
	}

}
