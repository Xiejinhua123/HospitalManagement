package cn.vote.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/**
 * 用于在session中存取数据
 * 
 * @author 解金化
 * 
 * @date 2017.07.15
 * 
 * @version 1.0
 *
 */
public class WebUtil {
	/**
	 * 给定需要从session中获取的参数
	 * @param params
	 * 		存在session中的键值
	 * @return
	 * 		session中的对象
	 */
	public static Object getSessionAttribute(String params){
		return getSession().getAttribute(params);
	}
	
	/**
	 * 向session中添加信息
	 * @param parms
	 * 		添加对象的键值
	 * @param obj
	 * 		添加的对象
	 */

	public static void setSessionAttribute( String parms , Object obj ){
		getSession().setAttribute(parms, obj);
	}
	
	/**
	 * 获取session
	 * @return
	 */
	private static HttpSession getSession(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		return session;
	}
	
	/**
	 * 从cookie中获取数据
	 * @param params cookie中储存的键值
	 * @return cookie对象
	 */
	public static Object getCookieAttribute(String params)
	{
		HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies)
        {
            if(cookie.getName().equals(params))
            {
                return cookie.getValue();
            }
        }
		return null;
	}
	
	/**
	 * 向cookie中添加信息
	 * @param name 键
	 * @param value	值
	 */
	public static void setCookieAttribute(String name,String value)
	{
		Cookie cookie = new Cookie(name, value);
        ServletActionContext.getResponse().addCookie(cookie);
	}
	
	/**
	 * 该方法用来在业务层发起http请求
	 * 
	 * @param URL
	 * 		请求地址
	 * @param method
	 * 		请求方式：<br/>
	 * 		取值范围：  ["GET","POST","HEAD","OPTIONS","PUT","DELETE","TRACE"] 
	 * @param map
	 * 		参数情况，map的键是当前请求中需要的参数名称，值是参数需要的值<br/>
	 * 		其中的键值对，只允许字符串类型的信息传输，并不允许其他类型
	 * @return
	 * 		从当前的请求中将流中信息解析为一个缓冲区并且返回
	 * @throws IOException
	 * 		有可能发生在解析路径，或者解析流的时候出现错误，需要捕捉异常并进行处理
	 */
	public static StringBuffer sendHttp(String URL , String method ,  Map<String,String> map) throws IOException{

		StringBuffer sbf = new StringBuffer(URL);
			
		if( null != map && map.size() > 0 ){
			
			int i = 0;
			for (String s : map.keySet()) {
				if( i ==0 ){
					sbf.append("?" + s + "=" + map.get(s));
				}else{
					sbf.append("&" + s + "=" + map.get(s)); 
				}
				i++;
			}
		}
		URL getUrl = new URL( sbf.toString() );
		// 根据拼凑的URL，打开连接，URL.openConnection函数会根据URL的类型，
		// 返回不同的URLConnection子类的对象，这里URL是一个http，因此实际返回的是HttpURLConnection
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod( method );
		
		// 进行连接，但是实际上get request要在下一句的connection.getInputStream()函数中才会真正发到
		// 服务器
		connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		connection.connect();
		// 取得输入流，并使用Reader读取
	    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));// 设置编码,否则中文乱码
		String lines;
		StringBuffer sb = new StringBuffer();
		while ((lines = reader.readLine()) != null) {
			sb.append( lines );
		}
		return sb;
	}
}
