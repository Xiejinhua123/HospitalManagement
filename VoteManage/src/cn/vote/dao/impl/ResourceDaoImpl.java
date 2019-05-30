package cn.vote.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.ResourceDao;
import cn.vote.entity.Resource;
import cn.vote.util.UtilHibernate;

/**
 * 权限实体增删改查
 * 
 * @author 解金化
 *
 */
public class ResourceDaoImpl extends HibernateDaoSupport implements ResourceDao {

	@Override
	public void insert(Resource res) {
		super.getHibernateTemplate().save(res);
	}


	@Override
	public void update(Resource res) throws Exception {
		
		Resource r = this.getById(res.getId());
		if( res.getAdminByCreateId() != null )r.setAdminByCreateId(res.getAdminByCreateId());
		if( res.getAdminByUpdateId() != null )r.setAdminByUpdateId(res.getAdminByUpdateId());
		if( res.getCreateTime() != null )r.setCreateTime(res.getCreateTime());
		if( res.getResAddress() != null )r.setResAddress(res.getResAddress());
		if( res.getResGrade() != null )r.setResGrade(res.getResGrade());
		if( res.getResName() != null )r.setResName(res.getResName());
		if( res.getResourceByParent() != null )r.setResourceByParent(res.getResourceByParent());
		if( res.getResStatic() != null )r.setResStatic(res.getResStatic());
		if( res.getUpdateTime() != null )r.setUpdateTime(res.getUpdateTime());
		
		super.getHibernateTemplate().update(r);
	}

	@Override
	public Resource getById(Integer id) {
		return super.getHibernateTemplate().get(Resource.class, id);
	}

	@Override
	public List<Resource> getAll() {
		return super.getHibernateTemplate().loadAll(Resource.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getByUserId(Integer adminId) {
		return super.getHibernateTemplate().find("from Resource where adminByCreateId.id=?",adminId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getByParentId(Integer parentId) {
		return super.getHibernateTemplate().find("from Resource where resourceByParent.id=?",parentId);
	}

}
