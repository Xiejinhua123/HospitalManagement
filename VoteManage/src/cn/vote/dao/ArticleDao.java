package cn.vote.dao;

import cn.vote.entity.Article;
import cn.vote.util.Page;

public interface ArticleDao {

	
	void addArticle(Article a);
	
	void getAll(Page<Article> page);
	
	void delArticle(Article article);
	/**
	 * 获取文章总数
	 * @return
	 */
	Integer getAllNumber();
	//条件查询
	void getAllBy(Page<Article> page, String selectBy, String tj);

	Article getById(Integer articleId);

	void updateArticle(Article article);
	/**
	 * 时间排序
	 * @param page
	 */
	void searchArticleByNewTime(Page<Article> page);
	/**
	 * 阅读量排序
	 * @param page
	 */
	void searchArticleByReadNumber(Page<Article> page);

	
	
}
