package cn.vote.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.ArticleDao;
import cn.vote.entity.Article;
import cn.vote.util.Page;
import cn.vote.util.UtilHibernate;

public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao{

	@Override
	public void addArticle(Article a) {
		
		super.getHibernateTemplate().save(a);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void getAll(Page<Article> page) {
		Session s=this.getSession();
		Query q=s.createQuery("from Article");
		int num=(page.getPageSize()-1)*page.getItems();
		q.setFirstResult(num);
		q.setMaxResults(page.getItems());
		List<Article> list=q.list();
		if(list!=null)page.setRows(list);
		page.setTotal(getAllNumber());
	}

	@Override
	public void delArticle(Article article) {
		this.updateArticle(article);
	}
	
	@SuppressWarnings("unchecked")
	public Integer getAllNumber()
	{
		List<Long> list=super.getHibernateTemplate().find("select count(*) from Article");
		if(list!=null) return list.get(0).intValue();
		return null;
	}

	@Override
	public void getAllBy(Page<Article> page,String selectBy, String tj) {
		String hql="";
		if(selectBy.equals("id"))hql="from Article where id = ?";
		if(selectBy.equals("title"))hql="from Article where title like ?";
		if(selectBy.equals("name"))hql="from Article where name like ?";
		Session s=this.getSession();
		Query q=s.createQuery(hql);
		if(selectBy.equals("id"))
		{
			Integer tji=Integer.parseInt(tj);
			q.setParameter(0,tji);
			
		}
		else q.setParameter(0, "%"+tj+"%");
		int num=(page.getPageSize()-1)*page.getItems();
		q.setFirstResult(num);
		q.setMaxResults(page.getItems());
		List<Article> list=q.list();
		if(list!=null)page.setRows(list);
		if(selectBy.equals("id"))page.setTotal(getAllByNumber(true,hql,tj));
		else page.setTotal(getAllByNumber(false,hql,tj));
	}
	
	@Override
	public void searchArticleByReadNumber(Page<Article> page) {
		List<Article> list=super.getHibernateTemplate().find("from Article order by readNumber desc");
		page.setRows(list);
		page.setTotal(getAllNumber());
	}

	@Override
	public void searchArticleByNewTime(Page<Article> page) {
		List<Article> list=super.getHibernateTemplate().find("from Article order by crateTime desc");
		page.setRows(list);
		page.setTotal(getAllNumber());
	}
	@SuppressWarnings("unchecked")
	public Integer getAllByNumber(boolean b,String hql,String tj)
	{
		hql="select count(*) "+hql;
		if(b)
		{
			Integer tji=Integer.parseInt(tj);
			List<Long> list=super.getHibernateTemplate().find(hql,tji);
			return list.get(0).intValue();
		}
		else
		{
			 List<Long> list=super.getHibernateTemplate().find(hql,tj);
			 return list.get(0).intValue();
		}
	}
	@Override
	public Article getById(Integer articleId) {
		return super.getHibernateTemplate().get(Article.class, articleId);
	}

	@Override
	public void updateArticle(Article article) {
		Article a=super.getHibernateTemplate().get(Article.class, article.getId());
		try {
			Article a1=UtilHibernate.Compare(a, article);
			super.getHibernateTemplate().update(a1);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}


	

}
