package com.accp.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.accp.dao.CommonDao;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;

public class CommonDaoImpl<T> extends HibernateUtil implements CommonDao<T>{

	@SuppressWarnings("hiding")
	@Override
	public <T> Object save(T t) {
		
		 Session s=HibernateUtil.currentSession();
		 Serializable ss=s.save(t);
		 try{
			 return  ss;
		 }
		 catch (Exception e) {
			 return  null;
		 }
	}
	@Override
	public <T> boolean del(Class<?> c,String  id) {
		 Session s=HibernateUtil.currentSession();
		 try{
			 T t=(T)s.get(c,id);
			 s.delete(t);
			 return  true;
		 }
		 catch (Exception e) {
			 System.out.println(e.getMessage());
			 return  false;
		}
		finally{
			 
		}
	}
	@Override
	/**
	 * 方法重载 删除id为int 的
	 * @param c
	 * @param id
	 * @return
	 */
	public <T> boolean del(Class<?> c,int  id) {
		 Session s=HibernateUtil.currentSession();
		
		 try{
			 T t=(T)s.get(c,id);
			 
			 s.delete(t);
			
			 return  true;
		 }
		 catch (Exception e) {
			 System.out.println(e.getMessage());
			 return  false;
		}
	}
	@Override
	/**
	 * 方法未完成
	 * 
	 *需要解析T属性是否为空  不为空进行赋值
	 */
	public <T> boolean update(T t) {
		 Session s=HibernateUtil.currentSession();
		 try{
			 s.merge(t);
			 return  true;
		 }
		 catch (Exception e) {
			 return  false;
		}
	}
	
	
	/*
	public <T> T getById(Class c,Serializable id) {
		 Session s=HibernateUtil.currentSession();
		 T t=(T)s.get(c,id);
		return t;
	}
	
	public <T> void getPage(Page<T> page, T t) {
		
		Session session = HibernateUtil.currentSession();
		String sql=Generate.getSql(t);
		Query query = session.createQuery(sql);
		//参数一     一页多少条
		//参数二     从哪开始(页数-1)*每页条数
		//map 动态查询 where 后条件
		// select top ? * from user where userId not in (select top ? userId from user)
		Map<String ,Object > map=Generate.getParams(t);
		for (String s : map.keySet()) {
			query.setParameter(s, map.get(s));
		}
		page.setItemscount(query.list().size()); //总条目数		
		query.setFirstResult((page.getPagesize()-1) * page.getItems() );  //从第几行开始
		query.setMaxResults( page.getItems() );	//一页多少行
		List<T> list = query.list();
		page.setList(list);
	}*/
	/**
	 * 动态查询
	 * @param t 条件对象
	 * 
	 * @return T对象集合
	*/
	public <T> List<T> getByColumn(T t)
	{
		Session s=HibernateUtil.currentSession();
		String hql=Generate.getSql(t);
		Query q=s.createQuery(hql);
		Map<String,Object> map=Generate.getParams(t);
		for (String  str : map.keySet()) {
			q.setParameter(str, map.get(str));
		}
		List<T> list=q.list();
		return list;
	}
	
	/**
	 * 留作纪念
	 * @param t
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException

	public <T> List<T> getByCo(T t) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		  Session s=HibernateUtil.currentSession();
		  Criteria c=s.createCriteria(t.getClass());
		  Field[] field = t.getClass().getDeclaredFields(); 
		  Object value =null;
		  for(int j=0 ; j<field.length ; j++){
			  try{
				  String name = field[j].getName();  //获取属性名称
				  name = name.substring(0,1).toUpperCase()+name.substring(1);//首字母大写
				  String type = field[j].getGenericType().toString();    //获取属性的类型
				  Method m = t.getClass().getMethod("get"+name);
				  value =  m.invoke(t);    //获取属性值
				  if(name!=null && name !="[]" )
				  {
					  c.add(Restrictions.eq(name, value));
				  }  
			  }
			  catch(Exception e)
			  {
				 e.getMessage();
			  }
		  }
		  return c.list();
		
		
	}*/

}
