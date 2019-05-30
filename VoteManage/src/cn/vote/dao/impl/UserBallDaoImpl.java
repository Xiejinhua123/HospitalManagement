package cn.vote.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.UserBallDao;
import cn.vote.entity.UserBall;
import cn.vote.util.UtilHibernate;

public class UserBallDaoImpl extends HibernateDaoSupport implements UserBallDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBall> getByballId(Integer BallId) {
		try{
		List<UserBall> list= super.getHibernateTemplate().find("from UserBall where ball.id=?",BallId);
		if(list!=null &&list.size()>0)
		{
			return  list;
		}
		else return null;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	
	@Override
	public Integer getUserballById(String id) {
		
		String sql = "select sum(number) from UserBall where users.id = ?";
		
		Query query = getSession().createQuery(sql);
		
		query.setString(0, id);
		
		Integer sum = 0;
		try{
			sum = Integer.parseInt( query.uniqueResult().toString() );
		}catch (Exception e) {
			sum = 0;
		}
		return sum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBall> getByUserId(String usersId) {
		try{
			List<UserBall> list= super.getHibernateTemplate().find("from UserBall where users.id=?",usersId);
			if(list!=null &&list.size()>0)
			{
				return  list;
			}
			else return null;
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getBallNumber(String userId, Integer BallId) {
		try{
			List<UserBall> list= super.getHibernateTemplate().find("from UserBall where users.id=? and ball.id=?",userId,BallId);
			if(list!=null &&list.size()>0)
			{
				return  list.get(0).getNumber();
			}
			else return null;
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
	}

	@Override
	public void addUserBall(UserBall ub) {
		try{
			 super.getHibernateTemplate().save(ub);
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void update(UserBall ub) {
		try{
			UserBall u1= super.getHibernateTemplate().get(UserBall.class, ub.getId());
			UserBall u2=UtilHibernate.Compare(u1, ub);
			super.getHibernateTemplate().update(u2);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}


	
	
}
