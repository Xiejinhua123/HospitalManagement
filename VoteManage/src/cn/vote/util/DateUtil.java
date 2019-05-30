package cn.vote.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 操作时间类型的封装
 * 
 * @author 解金化
 * 
 * @version 1.0
 * 
 * @date 2017-06-26
 *
 */
public class DateUtil {

	/**
	 * 给定时间字符串转换为时间<br/>
	 * 
	 * 要求格式必须为 yyyy-MM-dd HH:mm:ss<br/>
	 * 
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
	public static Date getDateByString(String data,String cha) throws IllegalAccessException,IndexOutOfBoundsException, ParseException{
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
		
		String[] bigTimes = bigTime.split(cha);
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
		if( data.length() == 10 ){
			StringBuffer sb = new StringBuffer();
			sb.append("yyyy");
			sb.append(cha);
			sb.append("MM");
			sb.append(cha);
			sb.append("dd");
			sdf = new SimpleDateFormat(sb.toString());
		}
		else{
			String[] smails = smailTime.split(":");
			if( smails.length != 3 )throw new IllegalAccessError("参数不正确");
			int h = Integer.parseInt(smails[0]);
			int mo = Integer.parseInt(smails[1]);
			int s = Integer.parseInt(smails[2]);
			if( h < 0 || h > 12 )throw new IllegalAccessError("小时数超出范围");
			if( mo < 0 || mo > 60 )throw new IllegalAccessError("分钟数超出范围");
			if( s < 0 || s > 60 )throw new IllegalAccessError("秒数超出范围");
			
			StringBuffer sb = new StringBuffer();
			sb.append("yyyy");
			sb.append(cha);
			sb.append("MM");
			sb.append(cha);
			sb.append("dd HH:mm:ss");
			sdf = new SimpleDateFormat(sb.toString());
		}
		
		Date date = sdf.parse(data);
		return date;
	}
	
	/**
	 * 获取当前的时间<br/>
	 * 年月日时分秒
	 * 
	 * @return
	 * 		返回当前的时间
	 */
	@SuppressWarnings("deprecation")
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
	public static String getDate(){
		Date d = new Date();
		
		StringBuffer str = new StringBuffer();
		int year = d.getYear() + 1900;
		int month = d.getMonth() + 1;
		int date = d.getDate();
		int hou = d.getHours();
		int m = d.getMinutes();
		int s = d.getSeconds();
		
		str.append(year);

		if(month < 10){
			str.append("0");
		}
		str.append(month);
		if(date < 10){
			str.append("0");			
		}
		str.append(date);
		if( hou < 10 )
			str.append(0);
		str.append(hou);
		if( m < 10 )
			str.append(0);
		str.append(m);
		if( s < 10 )
			str.append(0);
		str.append(s);
		return str.toString();
	}
	public static void main(String[] args) {
		try {
			System.out.println( new Date().getTime() );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
