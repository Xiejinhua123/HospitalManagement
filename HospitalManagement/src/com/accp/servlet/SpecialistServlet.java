package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.accp.biz.SpecialistBiz;
import com.accp.demo.Specialist;
import com.alibaba.fastjson.JSON;

public class SpecialistServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(SpecialistServlet.class);
	private SpecialistBiz sd = new SpecialistBiz();
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		
		String opr = request.getParameter("add");
		if(opr == null){
			out.print("noUrl"); // 返回noURL，路径错误
		}
		if(opr.equals("add")){ // 添加专家信息
			
		}else if(opr.equals("getByTime")){ // 获取当天的专家信息
			
			List<Specialist> list = sd.getByA(null);
			String json = JSON.toJSONString(list);
			out.print(json);
			
		}else if(opr.equals("getByDepId")){ // 根据科室信息，查询当前的值班医生

			Map<String, String> map = new HashMap<String, String>();
			map.put("depId", request.getParameter("depId"));
			
			List<Specialist> list = sd.getByA(map);
			String json = JSON.toJSONString(list);
			out.print(json);
			
		}
		
		out.flush();
		out.close();
	}

}
