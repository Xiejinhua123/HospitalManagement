package cn.vote.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.AdminResourceDao;
import cn.vote.entity.AdminResource;
import cn.vote.util.UtilHibernate;

/**
 * 权限分配
 * 
 * @author 解金化
 *
 */
public class AdminResourceDaoImpl extends HibernateDaoSupport implements AdminResourceDao {

	@Override
	public void delete(Integer ar) {
		AdminResource a=super.getHibernateTemplate().get(AdminResource.class, ar);
		super.getHibernateTemplate().delete(a);
	}

	@Override
	public AdminResource getById(Integer id) {
		return super.getHibernateTemplate().get(AdminResource.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminResource> selectByAdmin(Integer adminId) {
		String sql = "from AdminResource where adminByAdminId.id = ?";
		Query query = super.getSession().createQuery( sql );
		query.setInteger(0, adminId);
		return query.list();
	}

	@Override
	public void insert(AdminResource ars) {
		super.getHibernateTemplate().save(ars);
	}

	@Override
	public void deleteByAdminId(Integer id) {
		List<AdminResource> list = this.selectByAdmin(id);
		HibernateTemplate ht = super.getHibernateTemplate();
		for (int i = 0; i < list.size(); i++) {
			ht.delete( list.get(i) );
		}
	}

	@Override
	public List<AdminResource> getByResId(Integer id) {
		String sql = "from AdminResource where resource.id = ?";
		Query query = super.getSession().createQuery( sql );
		query.setInteger(0, id);
		return query.list();
	}
	
	@Override
	public List<AdminResource> selectByAdminAndGrade(Integer id, int i) {
		String sql = "from AdminResource where adminByAdminId.id = ? and resource.resGrade = ?";
		Query query = super.getSession().createQuery( sql );
		query.setInteger(0, id);
		query.setInteger(1, i);
		return query.list();
	}

	@Override
	public List<AdminResource> selectByAdminAndGradeAndParent(Integer id, int i,int parent) {
		String sql = "from AdminResource where adminByAdminId.id = ? and resource.resGrade = ? and resource.resourceByParent.id=?";
		Query query = super.getSession().createQuery( sql );
		query.setInteger(0, id);
		query.setInteger(1, i);
		query.setInteger(2, parent);
		return query.list();
	}

	@Override
	public List<AdminResource> selectByAdminAndParent(Integer id,
			int parent) {
		String sql = "from AdminResource where adminByAdminId.id = ? and resource.resourceByParent.id=?";
		Query query = super.getSession().createQuery( sql );
		query.setInteger(0, id);
		query.setInteger(1, parent);
		return query.list();
	}

	@Override
	public void update(AdminResource ar) {
		AdminResource a=super.getHibernateTemplate().get(AdminResource.class, ar.getId());
		try {
			AdminResource a1=UtilHibernate.Compare(a, ar);
			super.getHibernateTemplate().update(a1);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
