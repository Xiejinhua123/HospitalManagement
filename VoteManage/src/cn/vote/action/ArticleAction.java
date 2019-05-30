package cn.vote.action;

import cn.vote.entity.Article;
import cn.vote.service.ArticleService;
import cn.vote.util.Page;

public class ArticleAction extends ActionBase{
	//分页
	private Integer pagesize;
	//分页
	private Integer items;
	//分页
	private Page<Article> page=new Page<Article>();
	
	private Article article;
	//文章id
	private Integer articleId;
	
	private ArticleService articleService;
	//查询方式
	private String selectBy;
	//查询条件
	private String tj;
	
	private String title;
	//赠送爱心 一次送一个
	public void sendLove()
	{
		try {
			articleService.updateSendLovesendLove(articleId);
			super.setJson("success");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson(e.getMessage());
		}finally{
			super.witerJson();
		}
	}
	/**
	 * 根据标题模糊查询
	 */
	public void searchArticleByTitle()
	{
		try {
			page.setItems(items);
			page.setPageSize(pagesize);
			articleService.getAll(page,"title",title);
			if(page.getRows()!=null)super.setJson(page);
			else super.setJson("null");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	/**
	 * 查询最新发布文章
	 */
	public void searchArticleByNewTime()
	{
		try {
			page.setItems(items);
			page.setPageSize(pagesize);
			articleService.searchArticleByNewTime(page);
			if(page.getRows()!=null)super.setJson(page);
			else super.setJson("null");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	/**
	 * 查询最新发布文章
	 */
	public void searchArticleByReadNumber()
	{
		try {
			page.setItems(items);
			page.setPageSize(pagesize);
			articleService.searchArticleByReadNumber(page);
			if(page.getRows()!=null)super.setJson(page);
			else super.setJson("null");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	public void addArticle()
	{
		try {
			article.setContent(article.getContent().replace("\"","'"));
			articleService.addArticle(article);
			super.setJson("success");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public void delArticle()
	{
		try {
			articleService.delArticle(articleId);
			super.setJson("success");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public void getArticleAll()
	{
		try {
			page.setItems(items);
			page.setPageSize(pagesize);
			articleService.getAll(page,selectBy,tj);
			if(page.getRows()!=null)super.setJson(page);
			else super.setJson("null");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public void updateArticle()
	{
		try {
			articleService.update(article);
			super.setJson("success");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	public String content()
	{
		try {
			article=articleService.getById(articleId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}


	public String getTj() {
		return tj;
	}
	public void setTj(String tj) {
		this.tj = tj;
	}
	public String getSelectBy() {
		return selectBy;
	}
	public void setSelectBy(String selectBy) {
		this.selectBy = selectBy;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getItems() {
		return items;
	}
	public void setItems(Integer items) {
		this.items = items;
	}
	public Page<Article> getPage() {
		return page;
	}
	public void setPage(Page<Article> page) {
		this.page = page;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
