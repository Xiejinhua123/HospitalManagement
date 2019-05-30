package cn.vote.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.GameDao;
import cn.vote.entity.Game;

public class GameDaoImpl extends HibernateDaoSupport implements GameDao {

	@Override
	public Game getGameById(Integer gameId) {
		
		return super.getHibernateTemplate().get(Game.class, gameId);
	}

	@Override
	public void addGame(Game g) {
		super.getHibernateTemplate().save(g);
	}

}
