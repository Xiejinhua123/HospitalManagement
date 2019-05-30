package cn.vote.dao;

import cn.vote.entity.Game;

public interface GameDao {

	
	
	Game getGameById(Integer gameId);
	
	void addGame(Game g);
}
