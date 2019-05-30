package cn.vote.util;

import java.util.Arrays;

/**
 * 算法
 * @author 解金化
 *	@date 
 */
public class ArithmeticUtil {
	
	/**
	 * 给定一个数组，为当前数组元素进行排序
	 * 
	 * 排序规则，从首字母开始
	 * 
	 * 首字符一样，根据第二个，以此类推
	 * 
	 * @param strs
	 * 		给定的数组
	 * @return
	 * 		排序之后的数组
	 */
	public String[] sort( String[] strs ){
		
		Arrays.sort(strs);
		
		return strs;
		
	}
}
