package com.accp.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����������ȡ�û��ı��
 * 
 * @author ���
 * @version 1.0
 *
 *	@time 2017.03.09
 * 
 */
public class GenerateId {
	
	/**
	 * ͨ��ʱ���ȡ�û����
	 * @author ���
	 * @version 1.0
	 * 2017.03.09
	 * 
	 * @return
	 * 		ƴ�Ӻõı��
	 */
	public static String getId(){
		StringBuffer buffer = new StringBuffer(getDate());
		buffer.append(getRandom());
		return buffer.toString();
	}
	
	/**
	 * ͨ�������Ĳ�����Ϣ����ȡ�û����
	 * 
	 * @author ���
	 * @param departmentId
	 * 		���ű��
	 * 2017.03.09
	 * 
	 * @return
	 * 		�������Ӳ��ű�ŵ��û����
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
	 * ��ȡ��ǰʱ��ָ��Ϊ�ַ���
	 * 
	 * ������
	 * 
	 * @author ���
	 * 2017.03.09
	 * 
	 * @return
	 * 		����ƴ�Ӻõ��ַ���
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
	 * ��ȡ��ǰ��ʱ��
	 * ������ʱ����
	 * 
	 * @return
	 * 		���ص�ǰ��ʱ��
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
	 * ��ȡ���������λ����
	 * 
	 * @author ���
	 * @version 1.0
	 * @time 2017.03.10
	 * 
	 * @return
	 * 		�������ɵ���λ�����
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
	 * �������ṩ�����գ�����������
	 * 
	 * @param bir
	 * 		����
	 * 
	 * @return
	 * 		���ؼ��������
	 * 
	 * @throws IllegalAccessException
	 * 		�����쳣����ʱ�����͵Ĳ���
	 */
	public static int getAge(String bir) throws IllegalAccessException{
		
		if(bir != null){
		
			String regEx = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		    // ����������ʽ
		    Pattern pattern = Pattern.compile(regEx);
		    // ���Դ�Сд��д��
		    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(bir);
		    // �ַ����Ƿ���������ʽ��ƥ��
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
					// TODO �Զ����ɵ� catch ��
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
	 * ��ȡҩ���е���Ӧ��Ϣ
	 * 
	 * @param s
	 * 		ǰ̨����
	 * 
	 * @return
	 * 		�������ݼ���
	 */
	public static Map<String,String> getString(String s){
		String string = s.replace("*", "~");
		Map<String,String> map = new HashMap<String, String>();
		
		String[] string1 = string.split(","); // �ָ���еĶ���
		
		for (int i = 0; i < string1.length; i++) {
			String[] string2 = string1[i].split("~"); // �ָ���е����ƺ�����
			
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
