package cn.vote.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ActionBase extends ActionSupport {

	/**
	 * json字符串
	 */
	private String json;

	/**
	 * 获取json字符串
	 * @return
	 * 		返回json字符串
	 */
	public String getJson() {
		return json;
	}

	/**
	 * 设置json字符串<br/>
	 * 
	 * 基于struts2的json转换
	 * 
	 * @param obj
	 * 		给定任意类型，转换json字符串
	 */
	public void setJson(Object obj) {
		try {
			this.json = JSONUtil.serialize(obj);
			
		} catch (JSONException e) {
			e.printStackTrace();
			this.json = null;
		}
	}

	/**
	 * 向前端页面上传入json字符串
	 */
	public void witerJson(){
		
		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(StrutsStatics.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			if( null == out ){
				out = response.getWriter();
			}
			if( null != json ){
				out.print(json);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally{
			if( null != out ){
				out.flush();
				out.close();
			}
		}
	}
}