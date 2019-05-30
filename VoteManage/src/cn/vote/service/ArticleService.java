package cn.vote.service;

import java.util.List;

import cn.vote.entity.Article;
import cn.vote.util.Page;

public interface ArticleService {
	
	void addArticle(Article a) throws Exception;
	
	void getAll(Page<Article> page, String selectBy, String tj)throws Exception;
	
	void delArticle(Integer aId)throws Exception;

	Article getById(Integer articleId) throws Exception ;

	void update(Article article)throws Exception;
	/**
	 * 根据发布时间
	 * @param page
	 */
	void searchArticleByNewTime(Page<Article> page)throws Exception;
	/**
	 * 最热	阅读量派逊 
	 * @param page
	 * @throws Exception
	 */
	void searchArticleByReadNumber(Page<Article> page)throws Exception;
	/**
	 * 赠送爱心
	 * 一次送一个
	 * @param articleId
	 */
	void updateSendLovesendLove(Integer articleId)throws Exception;
	
}
