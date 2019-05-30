package cn.vote.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.UsersImgDao;
import cn.vote.entity.UsersImg;
import cn.vote.util.UtilHibernate;

public class UsersImgDaoImpl extends HibernateDaoSupport implements UsersImgDao{

	@Override
	public void addUserImg(UsersImg ui) {
		super.getHibernateTemplate().save(ui);
		
	}

	@Override
	public void delUserImg(String ui) {
		UsersImg u=super.getHibernateTemplate().get(UsersImg.class, ui);
		super.getHibernateTemplate().delete(u);
	}

	@Override
	public List<UsersImg> getAll() {
		 List<UsersImg>  list=super.getHibernateTemplate().find("from UsersImg");
		 if(list!=null) return list;
		return null;
	}

	@Override
	public List<UsersImg> getByUsersId(String id) {
		String sql = "from UsersImg where users.id = ?";
		Query query = super.getSession().createQuery(sql);
		query.setString(0, id);
		return query.list();
	}

	@Override
	public void update(UsersImg ui) {
		UsersImg u=super.getHibernateTemplate().get(UsersImg.class, ui.getId());
		try {
			UsersImg u1=UtilHibernate.Compare(u, ui);
			super.getHibernateTemplate().update(u1);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}
