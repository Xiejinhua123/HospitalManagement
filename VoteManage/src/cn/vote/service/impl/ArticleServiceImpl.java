package cn.vote.service.impl;

import java.sql.Timestamp;

import cn.vote.dao.ArticleDao;
import cn.vote.entity.Admin;
import cn.vote.entity.Article;
import cn.vote.entity.Users;
import cn.vote.model.Constants;
import cn.vote.service.ArticleService;
import cn.vote.util.DateUtils;
import cn.vote.util.Page;
import cn.vote.util.WebUtil;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;

	@Override
	public void addArticle(Article a) throws Exception {
		if (a.getContent() == null || a.getTitle() == null)
			throw new Exception("分页获取用户信息失败，当前参数为null");
		a.setCrateTime(Timestamp.valueOf(DateUtils.dateToString(
				DateUtils.getNewDate(), DateUtils.YYYY_MM_DD_HH_MM_SS)));
		a.setLoveNumber(0);
		a.setVoteNumber(0);
		a.setReadNumber(0);
		a.setUpdateTime(Timestamp.valueOf(DateUtils.dateToString(
				DateUtils.getNewDate(), DateUtils.YYYY_MM_DD_HH_MM_SS)));
		a.setDeletes("0");
		a.setAdminByUpdate((Admin)WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
		Object o = WebUtil
				.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		if (o != null) {
			Admin admin = (Admin) o;
			a.setAdmin(admin);
			a.setName(admin.getName());

		} else {
			Object usero = WebUtil
					.getSessionAttribute(Constants.SESSION_USER_KEY);
			Users usersa = (Users) usero;
			a.setUsers(usersa);
			a.setName(usersa.getUserName());
		}
		try {
			articleDao.addArticle(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void searchArticleByReadNumber(Page<Article> page) throws Exception{
		if (page.getItems() == null || page.getPageSize() == null)
			throw new Exception("getAll(Page<Article> page) 参数为空");
			articleDao.searchArticleByReadNumber(page);
			for (Article article : page.getRows()) {
				article.setName(article.getName());
				article.setAdmin(null);
				article.setUsers(null);
			}
	}
	
	@Override
	public void searchArticleByNewTime(Page<Article> page)throws Exception {
		if (page.getItems() == null || page.getPageSize() == null)
			throw new Exception("getAll(Page<Article> page) 参数为空");
			articleDao.searchArticleByNewTime(page);
			for (Article article : page.getRows()) {
				article.setName(article.getName());
				article.setAdmin(null);
				article.setUsers(null);
			}
	}
	@Override
	public void getAll(Page<Article> page, String selectBy, String tj)
			throws Exception {
		if (page.getItems() == null || page.getPageSize() == null)
			throw new Exception("getAll(Page<Article> page) 参数为空");
		try {
			if (selectBy == null || "".equals(selectBy))
				articleDao.getAll(page);
			else
				articleDao.getAllBy(page, selectBy, tj);
			if (page.getRows().size() < 1)
				return;
			for (Article article : page.getRows()) {
				article.setName(article.getName());
				article.setAdmin(null);
				article.setUsers(null);
				article.setUrl(getUrl(article.getContent()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getUrl(String s)
	{
		  int a=s.indexOf("src");
	      String s2=s.substring(a+5);
	      String s1="";
	      for (int i = 0; i < s2.length(); i++) {
	    	char c=s2.charAt(i);
	    	char s3='\'';
	    	if(c==s3)
			{
				break;
			}
			s1+=c;
	      }
	      return s1;
	}
	@Override
	public Article getById(Integer articleId) throws Exception {
		if (articleId == null)
			throw new Exception("getById（）参数为空");
		Article a = articleDao.getById(articleId);
		Object o=WebUtil.getSessionAttribute(Constants.SESSION_USER_KEY);
		if(o!=null)
		{
			a.setReadNumber(a.getReadNumber()+1);
			articleDao.updateArticle(a);
		}
		return a;
	}

	@Override
	public void update(Article article) throws Exception {
		if (article.getId() == null || article.getTitle() == null
				|| article.getContent() == null)
			throw new Exception("修改文章信息，当前参数为null");
		Article a = articleDao.getById(article.getId());
		if (a.getDeletes().equals("1"))
			return;
		a.setUpdateTime(DateUtils.getNowTimestamp());
		a.setAdminByUpdate((Admin)WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
		articleDao.updateArticle(article);
	}
	
	@Override
	public void delArticle(Integer aId) throws Exception {
		if(aId==null) throw new Exception("delArticle 参数为空");
		Article a1=articleDao.getById(aId);
		//如果已经被删除不执行操作
		if(a1.getDeletes().equals("1")) return;
		try{
			Article a=new Article();
			a.setDeletes("1");
			a.setUpdateTime(DateUtils.getNowTimestamp());
			a.setAdmin((Admin) WebUtil
					.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
			articleDao.delArticle(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateSendLovesendLove(Integer articleId) throws Exception{
		if(articleId==null) throw new Exception("sendLove 参数为空");
		Users u=(Users) WebUtil.getSessionAttribute(Constants.SESSION_USER_KEY);
		if(u.getLoveNumber()<1) throw new Exception("爱心数量不足");
		else
		{
			Article a=articleDao.getById(articleId);
			a.setLoveNumber(a.getLoveNumber()+1);
			articleDao.updateArticle(a);
		}
	}
//	@Override
//	public void getByTitle(String title , Page page) throws Exception {
//		
//		this.articleDao.getAllBy(page, "title", title);
//		List<Article> list = page.getRows();
//		List<ArticleViewModel> l = new LinkedList<ArticleViewModel>();
//		for (Article a : list) {
//			ArticleViewModel am = new ArticleViewModel();
//			am.setId(a.getId());
//			am.setImgPath(getImgPath(a.getContent()));
//			am.setTitle(a.getTitle());
//			l.add(am);
//		}
//		page.setRows(null);
//		page.setRows(l);
//	}
//
//	/**
//	 * 通过给定过的文章内容获取该文章中的图片的任意一个
//	 * 
//	 * @param p
//	 * 		文章内容
//	 * @return
//	 * 		文章中的图片路径信息
//	 */
//	private String getImgPath( String p ){
//		String[] imgs = p.split("img");
//		if( imgs.length == 0 ){
//			return "../../VoteManage/pagefile/image/articleImage/mr.png";
//		}else{
//			String img = imgs[0];
//			String[] imgPaths = img.split("'");
//			return imgPaths[1];
//		}
//	}
		
	public ArticleDao getArticleDao() {
		return articleDao;
	}
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	
	
	

}
