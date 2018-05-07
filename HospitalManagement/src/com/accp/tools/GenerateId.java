package com.accp.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 该类用来获取用户的编号
 * 
 * @author 解金化
 * @version 1.0
 *
 *	@time 2017.03.09
 * 
 */
public class GenerateId {
	
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
	public static String getDateTime(){
		
		Date d = new Date();
		
		StringBuffer str = new StringBuffer((d.getYear()+1900) + "");
		int month = d.getMonth() + 1;
		int date = d.getDate();
		int hours = d.getHours();
		int minutes = d.getMinutes();
		int seconds = d.getSeconds();

		str.append("-" + month);
		
		str.append("-" + date);
		
		str.append(" " + hours);
		
		str.append(":" + minutes);
		
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
	private static String getRandom(){
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
	public static int getAge(String bir) throws IllegalAccessException{
		
		if(bir != null){
		
			String regEx = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		    // 编译正则表达式
		    Pattern pattern = Pattern.compile(regEx);
		    // 忽略大小写的写法
		    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(bir);
		    // 字符串是否与正则表达式相匹配
		    boolean rs = matcher.matches();
			
		    if(rs){
		    
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				int year = 0;
				int age = 0;
				try {
					date = sdf.parse(bir);
					year = date.getYear();
					age = new Date().getYear() - year;
				} catch (ParseException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
				return age;
			}else{
				throw new IllegalAccessException("birError");
			}
	    }
		else{
			return -1;
		}
	}
	
	/**
	 * 获取药方中的相应信息
	 * 
	 * @param s
	 * 		前台数据
	 * 
	 * @return
	 * 		返回数据集合
	 */
	public static Map<String,String> getString(String s){
		String string = s.replace("*", "~");
		Map<String,String> map = new HashMap<String, String>();
		
		String[] string1 = string.split(","); // 分割开所有的逗号
		
		for (int i = 0; i < string1.length; i++) {
			String[] string2 = string1[i].split("~"); // 分割开所有的名称和数量
			
			map.put(string2[0], string2[1]);
			
		}
		return map;
	}
	
	public static void main(String[] args) {
//		for (int i = 0; i < 90000; i++) {
//			System.out.println(getDate());
//		}
//		System.out.println(getDate());
		
		System.out.println(getString("a*9,g*6,c*3"));
	}
	
}
