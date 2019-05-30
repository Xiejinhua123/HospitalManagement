package cn.vote.util;

import java.lang.reflect.Field;

public class ParamCheck {

	/**
	 * 变量非空验证
	 * 
	 * @param t
	 * 		需要验证的变量
	 * @param parms
	 * 		不需要验证的列的数组
	 * @return
	 * 		如果是含有空值，返回false<br/>
	 * 		如果没有空值，返回true
	 */
	public static <T> Boolean checked( T t, String[] parms ){
		
		Field[] proms = t.getClass().getDeclaredFields(); // 获取属性对象
		
		outer:for (int i = 0; i < proms.length; i++) { // 循环获取当前的用户对象属性的值
			
			proms[i].setAccessible(true); // 设置允许访问private属性
			
			if( null != parms && parms.length > 0 ){
				for (String string : parms) {
					if( proms[i].getName().equals( string ) ){
						continue outer;
					}
				}
			}
			try {
				if( null == proms[i].get( t ) ){
					return false;
				}
			} catch (Exception e){
				System.out.println("class:ParamCheck --> checked():非空验证失败：" + e.getMessage() );
			}
		}
		return true;
	}
	
}
