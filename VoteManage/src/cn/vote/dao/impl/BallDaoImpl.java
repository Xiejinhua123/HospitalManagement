package cn.vote.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.BallDao;
import cn.vote.entity.Ball;
import cn.vote.util.UtilHibernate;

public class BallDaoImpl extends HibernateDaoSupport implements BallDao {

	@Override
	public Ball getById(Integer ballId) {
		
		return super.getHibernateTemplate().get(Ball.class , ballId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Ball getByName(String name) {
		
		List<Ball> list=super.getHibernateTemplate().find("from Ball where ballName=？",name);
		if(list!=null) return list.get(0);
		return null;
	}
	
	@Override
	public boolean update(Ball ball) throws IllegalArgumentException, IllegalAccessException {
		
		Ball perBall = getById( ball.getId() );
		
		perBall = UtilHibernate.Compare(perBall, ball);
		
		this.getHibernateTemplate().update(perBall);
		
		return true;
	}

	@Override
	public List<Ball> getAll() {
		return super.getHibernateTemplate().loadAll(Ball.class);
	}		
}
