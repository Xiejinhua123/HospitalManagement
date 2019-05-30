package cn.vote.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.FriendDao;
import cn.vote.entity.Friend;
import cn.vote.entity.Users;
import cn.vote.util.UtilHibernate;

public class FriendDaoImpl extends HibernateDaoSupport implements FriendDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> getFriend(Users u) {
		try{
		List<Friend> list=super.getHibernateTemplate().find("from Friend where usersByUserId.id=?",u.getId());
		if(list!=null &&list.size()>0) return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addFriend(Friend f) {
		try{
			super.getHibernateTemplate().save(f);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void delFrienf(Friend f) {
		this.updateFrient(f);
	}

	@Override
	public void updateFrient(Friend f) {
		Friend a=super.getHibernateTemplate().get(Friend.class, f.getId());
		try {
			Friend a1=UtilHibernate.Compare(a, f);
			super.getHibernateTemplate().update(a1);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}


}
