package cn.vote.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DateUtils
{
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";
	
	public static Date getCurrentDate()
	{
		return new Date();
	}
	/**
	 * 将日期对象转换成字符串精确到秒
	 * @param date			日期对象
	 * @param formatStr		格式化
	 * @return
	 */
	public static String dateToString(Date date , String formatStr)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(date);
	}
	/**
	 * 获取当前时间转成Timestamp
	 * @return
	 * @throws ParseException 
	 */
	public static Timestamp getNowTimestamp() throws ParseException
	{
		return Timestamp.valueOf(DateUtils.dateToString(DateUtils.getNewDate(),DateUtils.YYYY_MM_DD_HH_MM_SS));
	}
	/**
	 * 获取当前时间精确到秒
	 * @return date类型
	 * @throws ParseException 
	 */
	public static Date getNewDate() throws ParseException
	{
		DateFormat df2 = DateFormat.getDateTimeInstance();//可以精确到时分秒
		String time=df2.format(new Date());
		Date d=df2.parse(time);
		return d;
	}
	//获取uuid
	 public static String getUUID(){ 
	        String s = UUID.randomUUID().toString(); 
	        //去掉“-”符号 
	        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
	} 
	public static void main(String[] args) 
	{
		
		String s=DateUtils.dateToString(new Date(), YYYY_MM_DD_HH_MM_SS);
		System.out.println(s);
		
//		//当前系统日期对象
//		Date date = new Date();
//		
//		//Calendar是专门用来修改日期中各个字段的值
//		Calendar c = Calendar.getInstance();
//		//获取这个月的第一天
//		c.setTime(date);	//初始化Calendar对象为当前日期
//		c.set(Calendar.DAY_OF_MONTH, 1);	//讲Calendar中的日期对象，的日修改成1
//		
//		System.out.println(dateToString(c.getTime(), YYYY_MM_DD));
//		
//		//获取上个月的第一天
//		c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
//		System.out.println(dateToString(c.getTime(), YYYY_MM_DD));
	}
}
