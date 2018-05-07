package com.accp.util;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 该类用来获取用户的编号
 * 
 * @author 解金化
// * @version 1.0
 *
 *	@time 2017.03.09
 * 
 */
public class Generate {
	
	/**
	 * 通过时间获取用户编号
	 * @author 解金化
	 * @version 1.0
	 * 2017.03.09
	 * 
	 * @return
	 * 		拼接好的编号
	 */
	public static String getId(){
		StringBuffer buffer = new StringBuffer(getDate());
		buffer.append(getRandom());
		return buffer.toString();
	}
	
	/**
	 * 通过给定的部门信息，获取用户编号
	 * 
	 * @author 解金化
	 * @param departmentId
	 * 		部门编号
	 * 2017.03.09
	 * 
	 * @return
	 * 		返回连接部门编号的用户编号
	 */
	public static String getId(String departmentId){
		StringBuffer buffer = new StringBuffer(getDate());
		if(Integer.parseInt(departmentId) < 10){
			buffer.append("0");
		}
		buffer.append(departmentId);
		buffer.append(getRandom());
		return buffer.toString();
	}
	
	/**
	 * 获取当前时间分割成为字符串
	 * 
	 * 年月日
	 * 
	 * @author 解金化
	 * 2017.03.09
	 * 
	 * @return
	 * 		返回拼接好的字符串
	 */
	@SuppressWarnings("deprecation")
	@Test
	public static String getDate(){
		Date d = new Date();
		
		StringBuffer str = new StringBuffer();
		int year = d.getYear() + 1900;
		int month = d.getMonth() + 1;
		int date = d.getDate();
		str.append(year);

		if(month < 10){
			str.append("0");
		}
		str.append(month);
		if(date < 10){
			str.append("0");			
		}
		str.append(date);
		return str.toString();
	}
	
	/**
	 * 获取当前的时间
	 * 年月日时分秒
	 * 
	 * @return
	 * 		返回当前的时间
	 */
	@SuppressWarnings("deprecation")
	@Test
	public static String getDateTime(){
		
		Date d = new Date();
		
		StringBuffer str = new StringBuffer((d.getYear()+1900) + "");
		int month = d.getMonth() + 1;
		int date = d.getDate();
		int hours = d.getHours();
		int minutes = d.getMinutes();
		int seconds = d.getSeconds();

		if( month < 10 )
			str.append("-0" + month);
		else
			str.append("-0" + month);
		
		if( date < 10 )
			str.append("-0" + date);
		else
			str.append("-" + date);
		
		if( hours < 10 )
			str.append(" 0" + hours);
		else
			str.append(" " + hours);
		
		if( minutes < 10 )
			str.append(":0" + minutes);
		else
			str.append(":" + minutes);
		
		if( seconds < 10 )
			str.append(":0" + seconds);
		else
			str.append(":" + seconds);
		
		return str.toString();
		
	}
	
	/**
	 * 获取随机数（四位数）
	 * 
	 * @author 解金化
	 * @version 1.0
	 * @time 2017.03.10
	 * 
	 * @return
	 * 		返回生成的四位随机数
	 */
	public static String getRandom(){
		StringBuffer str = new StringBuffer();
		Integer math = (int)(Math.random()*10000);
		if(math < 10)
			str.append("000");
		else if(math < 100)
			str.append("00");
		else if(math < 1000)
			str.append("0");
		str.append(math.toString());
		return str.toString();
	}
	
	/**
	 * 根据所提供的生日，来计算年龄
	 * 
	 * @param bir
	 * 		生日
	 * 
	 * @return
	 * 		返回计算的年龄
	 * 
	 * @throws IllegalAccessException
	 * 		参数异常，非时间类型的参数
	 */
	@SuppressWarnings("deprecation")
	public static Integer getAge(Date bir) throws IllegalAccessException{
		int age = 0;
		int year = bir.getYear();
		age = new Date().getYear() - year;
		return age;
	}
	
	/**
	 * 给定时间字符串转换为时间<br/>
	 * 要求格式必须为 yyyy-MM-dd HH:mm:ss<br/>
	 * 或者是yyyy-MM-dd
	 * @param data
	 * 		时间字符串
	 * @return
	 * 		返回时间类型
	 * @throws IllegalAccessException
	 * 		必须捕获参数异常
	 * @throws IndexOutOfBoundsException
	 * 		下标异常
	 * @throws ParseException
	 * 		时间转换异常 
	 */
	public static Date getDateByString(String data) throws IllegalAccessException,IndexOutOfBoundsException, ParseException{
		if( null == data || (data.length() != 10 && data.length() != 19) ){
			throw new IllegalAccessError("参数不正确");
		}
		String bigTime = null;
		String smailTime = null;
		if( data.length() == 19 ){
			String[] time = data.split(" ");
			if( time.length != 2 )
				throw new IllegalAccessError("参数不正确");
			
			bigTime = time[0];
			smailTime = time[1];
		}else if( data.length() == 10 )
			bigTime = data;
		
		String[] bigTimes = bigTime.split("/");
		if( bigTimes.length != 3 )throw new IllegalAccessError("参数不正确");
		
		if( Integer.parseInt( bigTimes[0] ) < 1900 )throw new IllegalAccessError("年份不正确");
		
		if( Integer.parseInt( bigTimes[1] ) < 1 || Integer.parseInt( bigTimes[1] ) > 12 )
			throw new IllegalAccessError("月份不正确");
		
		if( Integer.parseInt( bigTimes[2] ) < 1 )
			throw new IllegalAccessError("天数不正确");

		int m = Integer.parseInt( bigTimes[1] );
		switch (m) {
		case 1:	case 3:	case 5:	case 7:	case 8:	case 10:case 12:
			if( Integer.parseInt( bigTimes[2] ) > 30 )
				throw new IllegalAccessError("天数跟月份没有对应不正确");
			break;
		case 4:	case 6:	case 9:	case 11:
			if( Integer.parseInt( bigTimes[2] ) > 31 )
				throw new IllegalAccessError("天数跟月份没有对应不正确");
			break;
		case 2:
			int year = Integer.parseInt( bigTimes[0] );
			if( year % 400 == 0 || ( year % 4 == 0 && year % 100 != 0 ) )
				if( Integer.parseInt( bigTimes[2] ) > 29 )
					throw new IllegalAccessError("天数跟月份没有对应不正确");
			else
				if( Integer.parseInt( bigTimes[2] ) > 28 )
					throw new IllegalAccessError("天数跟月份没有对应不正确");
			break;
		}
		
		SimpleDateFormat sdf = null;
		if( data.length() == 10 )
			sdf = new SimpleDateFormat("yyyy/MM/dd");
		else{
			String[] smails = smailTime.split(":");
			if( smails.length != 3 )throw new IllegalAccessError("参数不正确");
			int h = Integer.parseInt(smails[0]);
			int mo = Integer.parseInt(smails[1]);
			int s = Integer.parseInt(smails[2]);
			if( h < 0 || h > 12 )throw new IllegalAccessError("小时数超出范围");
			if( mo < 0 || mo > 60 )throw new IllegalAccessError("分钟数超出范围");
			if( s < 0 || s > 60 )throw new IllegalAccessError("秒数超出范围");
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		
		Date date = sdf.parse(data);
		return date;
	}
	
	/**
	 * 根据提供的类和列名，生成sql语句
	 * @param <T>
	 * 
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

		List<String> paramNames = new ArrayList<>();
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
		Map<String,Object> map = new Hashtable<>();
		
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
	public static <T, E> T Compare(T t,E e) throws IllegalArgumentException, IllegalAccessException{
		
		Class<?> ct = t.getClass();
		Class<?> ce = e.getClass();
		Field[] tfile = ct.getDeclaredFields();
		Field[] efile = ce.getDeclaredFields();
		
		for (int i = 0; i < tfile.length; i++) { // 循环持久化对象
			Field field = tfile[i];
			field.setAccessible(true); // 设置属性直接可以访问
			efile[i].setAccessible(true);
			Object tvalue = field.get(t);
			Object evalue = efile[i].get(e);
			if(evalue != null && !tvalue.equals(evalue)){
				field.set(t, evalue);
			}
		}
		return t;
	}
	public static void main(String[] args) {
		try {
			Date date = getDateByString("2017/02/03");
			System.out.println(date);
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
