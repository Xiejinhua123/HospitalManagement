package com.xiao.Utilxiao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Commonxiao {
	/****
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static Boolean IsNull(String str){
		Boolean b=true;
		if(null==str||str.equals(""))b=false;
		return b;
	}
	
	public static Date StrEscapedDate(String str) throws ParseException{
		Date date=null;
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		date=sf.parse(str);
		return date;
	}

}
