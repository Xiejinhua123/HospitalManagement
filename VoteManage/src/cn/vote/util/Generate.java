package cn.vote.util;

import java.util.Date;

/**
 * 该类用来获取用户的编号
 * 
 * @author 解金化

 * @version 1.0
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
		StringBuffer buffer = new StringBuffer(DateUtil.getDate());
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
		StringBuffer buffer = new StringBuffer(DateUtil.getDate());
		if(Integer.parseInt(departmentId) < 10){
			buffer.append("0");
		}
		buffer.append(departmentId);
		buffer.append(getRandom());
		return buffer.toString();
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
	
	public static void main(String[] args) {
		System.out.println( getId() );
	}
}
