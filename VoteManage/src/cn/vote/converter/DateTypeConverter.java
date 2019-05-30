package cn.vote.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateTypeConverter extends StrutsTypeConverter {

	private static final String dateType="yyyy-MM-dd HH:mm:ss";
	private static final String date="yyyy-MM-dd";
	private static final SimpleDateFormat format= new SimpleDateFormat(dateType);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(date);
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toType) {
		if( toType == java.util.Date.class){
			try{
				if( !"".equals(values[0].trim()) )
					
					return format.parse(values[0]);
				
				}catch( Exception e ){
					try {
						return dateFormat.parse(values[0]);
					} catch (Exception e2) {
						return values[0];
					}
				}
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object value) {
		if( value instanceof java.util.Date){ 
			
			return format.format((Date)value);
		}
		return null;
	}
	
}
