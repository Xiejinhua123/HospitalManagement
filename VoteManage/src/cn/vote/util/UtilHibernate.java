package cn.vote.util;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * hibernate 信息封装类
 * 
 * @author 解金化
 * 
 * @version 1.0
 * 
 * @date 2017-06-26
 *
 */
public class UtilHibernate {

	/**
	 * hibernate自动生成hql语句<br/>
	 * 
	 * 根据提供的类和列名，生成sql语句
	 * @param <T>
	 * 		形参
	 * @param t
	 * 		提供的类的对象
	 * 
	 * @param paramNames
	 * 		提供生成的列名
	 * 
	 * @return
	 * 		已经生成的sql语句
	 */
	public static <T> String getSql(T t){

		List<String> paramNames = new ArrayList<String>();
		Map<String,Object> map = getParams(t);
		for (String s : map.keySet()) {
			paramNames.add(s);
		}
		
		Class<?> cl = t.getClass();   // T的类型对象
		Field[] fields = new Field[paramNames.size()];
		String tablename = cl.getSimpleName();
		try {
			StringBuffer sql = new StringBuffer("from " + tablename + " where 1=1 ");
			
			for(int i=0;i<paramNames.size();i++){
				fields[i] = cl.getDeclaredField(paramNames.get(i));
				fields[i].setAccessible(true);
				Type type = fields[i].getGenericType();
				if( type.equals(String.class) ){
					sql.append(" and " + paramNames.get(i) + " like :" + paramNames.get(i) + " ");
				}else{
					sql.append(" and " + paramNames.get(i) + " = :" + paramNames.get(i) + " ");
				}
			}
			return sql.toString();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * hibernate专用值解析<br/>
	 * 
	 * 获取含有值的信息
	 * 
	 * @param t
	 * 		需要分析的对象
	 * 
	 * @return
	 * 		key 就是列名
	 * 		value 就是值
	 */
	@SuppressWarnings("rawtypes")
	public static <T> Map<String, Object> getParams(T t){

		Class<?> cl = t.getClass();   // T的类型对象
		Field[] fields = cl.getDeclaredFields();
		Map<String,Object> map = new Hashtable<String,Object>();
		
		try {
			for(int i=0; i < fields.length; i++){
				fields[i].setAccessible(true);
				Object obj = fields[i].get(t);
				
				if(null == obj)continue;
				
				Type type = fields[i].getGenericType();
				
				if(type.equals(java.util.Set.class)){
					if( ((Set)fields[i].get(t)).size() == 0 )continue;
				}else if( type.equals(java.lang.String.class) ){
					map.put(fields[i].getName(),"%" + fields[i].get(t) + "%");
				}
				else
					map.put(fields[i].getName(),fields[i].get(t));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		map.remove("uz");
		return map;
	}
	
	/**
	 * 通过给定的两个对象
	 * 
	 * 将对象不同的值进行更改
	 * 
	 * 持久化对象的值更改为瞬时对象的值
	 * 
	 * 用于修改操作
	 * 
	 * @param t
	 * 		持久状态的对象
	 * @param e
	 * 		瞬时对象
	 * @return
	 * 		持久化对象
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	public static <T, E> E Compare(T t,E e) throws IllegalArgumentException, IllegalAccessException{
		
		Class<?> ct = t.getClass();
		Class<?> ce = e.getClass();
		Field[] tfile = ct.getDeclaredFields();
		Field[] efile = ce.getDeclaredFields();
		
		for (int i = 0; i < tfile.length; i++) { // 循环持久化对象
			Field field = tfile[i];
			Type type = field.getGenericType();
			
			if( type.toString().equals("class " + Set.class.getName() ) || type.toString().equals("interface " + Set.class.getName() ) ){
				continue;
			}
			
			field.setAccessible(true); // 设置属性直接可以访问
			efile[i].setAccessible(true);
			
			Object tvalue = field.get(t); // 持久对象的值
			Object evalue = efile[i].get(e); // 需要更改的值
			
			if( null == tvalue )
				tvalue = new Object();
			
			if(evalue != null && !tvalue.equals(evalue)){
				tfile[i].set(t, evalue);
			}
		}
		
		return (E)t;
		}
	
	
	
		public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
//			ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext*.xml");
//			UserDao u=ac.getBean(UserDao.class);
//			Users u1=u.getById("1500967969865");
//			Users u2=new Users();
//			u2.setTelephone("11111111111");
//			Users u3=UtilHibernate.Compare(u1, u2);
//			u.updateUser(u3);
			
		}
	}
	
	

