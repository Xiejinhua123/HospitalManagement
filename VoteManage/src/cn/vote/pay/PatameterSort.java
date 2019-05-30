package cn.vote.pay;

import java.lang.reflect.Field;
import java.util.Arrays;

import cn.vote.util.MD5;

public class PatameterSort {
	/**
	 * 参数排序
	 * 
	 * @param p
	 * 		参数对象
	 * @return
	 * 		排序之后的参数字符串
	 */
	private String sort( Parameters p ) throws Exception{
		
		Field[] files = p.getClass().getDeclaredFields();
		String[] patams = new String[files.length]; // 用来接收参数列表，最后为参数列表排序
		
		//开始获取当前的参数对象中非null的参数名称数组
		int j = 0; // 参数数组下标
		for (int i = 0; i < files.length; i++) {
			
			Field field = files[i];
			try{			
				field.setAccessible(true); // 设置私有属性可以访问
				
				Object value = field.get( p ); //获取当前对象的相对应属性值
				
				if( null == value )continue;
				
				patams[j] = field.getName(); // 获取非null参数列表
				j++;
				
			} catch (Exception e) {
				throw new Exception("获取非null参数数组出错");
			}
		} // 获取参数数组结束
		
		
		//开始进行数组排序
		//其中a数组是为了将当前参数数组中的null位置去掉
		String[] a = new String[j];
		for (int i = 0; i < a.length; i++) {
			a[i] = patams[i];
		}
		patams = a;
		Arrays.sort(patams);
		//数组排序结束
		
		//开始拼接参数字符串
		StringBuffer sb = new StringBuffer();
		for (int k = 0; k < patams.length; k++) {
			for (int i = 0; i < files.length; i++) {
				Field field = files[i];
				if( patams[k].equals( field.getName() ) )
					try {
						sb.append( "&" + patams[k] + "=" + field.get( p ) );
					} catch ( Exception e ) {
						throw new Exception("拼接排序后参数出错");
					}
			}
		}
		String parm = sb.toString();
		parm = parm.substring(1, parm.length() - 1);
		//参数字符串拼接结束
		
		
		return parm;
	}
	
	public static void main(String[] args) throws Exception {
		String b = "971876247369669bdd863b505396b4d6";
		System.out.println(b.length());
		
		Parameters p = new Parameters();
		p.setApp_id("aaa");
		p.setChannel("Channel");
		p.setDescription("Description");
		p.setExtra("Extra");
		p.setIp("ip");
		p.setNotify_url("Notify_url");
		p.setOut_trade_no("out_trade_no");
		p.setSubject("subject");
		p.setTotal_fee(100);
		p.setReturn_url("return_url");
		p.setSign("sign");
		
		PatameterSort ps = new PatameterSort();
		String s = ps.sort(p);
		System.out.println(s);
		s = new MD5(s).compute();
		System.out.println(s);
	}
}
