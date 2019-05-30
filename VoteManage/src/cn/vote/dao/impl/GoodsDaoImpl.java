package cn.vote.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.vote.dao.GoodsDao;
import cn.vote.entity.Goods;
import cn.vote.util.Page;
import cn.vote.util.UtilHibernate;

public class GoodsDaoImpl extends HibernateDaoSupport implements GoodsDao{

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext*.xml");
		GoodsDaoImpl good= (GoodsDaoImpl) ac.getBean("goodsDao");
	    List<String> list=good.getAllGoodsName();
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	@Override
	public boolean updaupdateGoods(Goods g) {
		try{
			Goods g1=super.getHibernateTemplate().get(Goods.class, g.getId());
			Goods g2 = UtilHibernate.Compare(g1, g);
			super.getHibernateTemplate().update(g2);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Goods getById(Integer id) {
		return super.getHibernateTemplate().get(Goods.class, id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getPageAll(Page page,String goodsName) {
		Session s=this.getSession();
		Query q= s.createQuery("select count(id) from Goods");
		page.setTotal( Integer.parseInt( q.uniqueResult().toString() ) );
		q=s.createQuery("from Goods");
		int number=(page.getPageSize()-1)*page.getItems();
		q.setFirstResult(number);
		q.setMaxResults(page.getItems());
		List<Goods>  list=q.list();
		releaseSession(s);
		page.setRows(list);
	}
	
	@Override
	public boolean delete(Goods g) {
		this.updaupdateGoods(g);
		return true;
	}

	
	@SuppressWarnings("unchecked")
	public Goods getByName(String name) {
		try{
		List<Goods> g=super.getHibernateTemplate().find("from Goods where goodsName=?",name);
		if(g!=null) return g.get(0);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
	/**
	 * 解金化
	 */
	@Override
	public void add(Goods goods) {
		super.getHibernateTemplate().save(goods);
	}

	
	@SuppressWarnings("unchecked")
	public List<String> getAllGoodsName()
	{
		try{
			List<String> list=super.getHibernateTemplate().find("select goodsName from Goods");
			System.out.println(11);
			return list;
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				return null;
			}
	}
}
