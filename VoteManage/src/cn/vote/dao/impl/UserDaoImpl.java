package cn.vote.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.UserDao;
import cn.vote.entity.Users;
import cn.vote.model.UserModel;
import cn.vote.util.Page;
import cn.vote.util.UtilHibernate;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public boolean updateUser(Users u) {
		try {
			Users user = super.getHibernateTemplate().get(Users.class,
					u.getId());
			user = UtilHibernate.Compare(user, u);
			super.getHibernateTemplate().update(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean delUser(Users u) {
		this.updateUser(u);
		return true;
	}

	@Override
	public List<Users> gettotal(Page<UserModel> page, String name) {

		String hql = "";
		if (name == null || name.equals("totalVotes"))
			hql = "from Users where deleteds = 0 order by totalVotes desc";
		else if (name.equals("boxNumber"))
			hql = "from Users where deleteds = 0 order by boxNumber desc";
		else if (name.equals("ballNumber"))
			hql = "from Users where deleteds = 0 order by ballNumber desc";
		else if (name.equals("loveNumber"))
			hql = "from Users where deleteds = 0 order by loveNumber desc";

		page.setTotal(getAll().intValue());// 放入总
		Session s = this.getSession();
		Query q = s.createQuery(hql);

		int number = (page.getPageSize() - 1) * page.getItems();
		q.setFirstResult(number);
		q.setMaxResults(page.getItems());
		List<Users> list = q.list();
		releaseSession(s);
		if (list == null || list.size() < 1)
			return null;
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Users> getPage(Page<UserModel> page, String name, String tj) {
		Session s = this.getSession();
		try {
			Integer total = 0;
			if (name == null || "".equals(name))
				total = getAll().intValue();// 放入总条数
			else
				total = getNumByName(name).intValue();// 放入总条数
			page.setTotal(total);
			Query q1 = null;
			if (name == null || "".equals(name))
				q1 = s.createQuery("from Users");
			else {
				String hql = null;
				if (tj.equals("id"))
					hql = "from Users where id like ?";
				if (tj.equals("userName"))
					hql = "from Users where userName like ?";
				if (tj.equals("telephone"))
					hql = "from Users where id like ?";
				q1 = s.createQuery(hql);
				q1.setParameter(0, name + "%");
			}
			int number = (page.getPageSize() - 1) * page.getItems();
			q1.setFirstResult(number);
			q1.setMaxResults(page.getItems());
			List<Users> list = q1.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			releaseSession(s);
		}
		return null;
	}

	@Override
	public Long getAll() {
		List list = super.getHibernateTemplate().find(
				"select count(id) from Users");
		return (Long) list.get(0);
	}

	@Override
	public Long getNumByName(String name) {
		try {
			Session session = super.getSession();
			String hql = "select count(id) from Users where userName = ?";
			Query query = session.createQuery(hql);
			query.setString(0, name);
			return (Long) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (long) 0;
	}

	@Override
	public boolean addUser(Users u) {
		try {
			super.getHibernateTemplate().save(u);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String checkedId(final String id) {
		return super.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "select id from Users where ID = ?";
				Query query = session.createQuery(hql);
				query.setString(0, id);
				return query.uniqueResult();
			}
		});
	}

	@Override
	public Users getById(String id) {
		return super.getHibernateTemplate().get(Users.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Users doLogin(String name, String pwd) {
		List<Users> list = null;
		try {
			list = super.getHibernateTemplate()
					.find("from Users where userName=? and userPassword=?",
							name, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getVoteTen(int i, int j) {
		List<Users> list = null;
		try {
			Session s = this.getSession();
			Query q = s.createQuery("from Users order by totalVotes desc");
			q.setFirstResult((i - 1) * j);
			q.setMaxResults(j);
			list = q.list();
			releaseSession(s);
			if (list != null)
				return list;
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext*.xml");
		UserDaoImpl ud = ac.getBean(UserDaoImpl.class);
		// List<String> list=ud.getAllId();
		while (true) {

		}
	}
	@Override
	public List<Users> getUserByUserName(String name) {
		return super.getHibernateTemplate().find("from Users where userName like ?","%"+name+"%");
	}
	
}
