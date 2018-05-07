package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.accp.biz.DepartmentBiz;
import com.accp.demo.Department;
import com.accp.demo.Page;
import com.alibaba.fastjson.JSON;

/**
 * 科室信息的逻辑处理类
 * 
 * @author 解金化
 * @version 1.0
 * @time 2017.03.13
 *
 */

public class DepartmentServlet extends HttpServlet {
	
	private DepartmentBiz depbiz = new DepartmentBiz(); // 科室信息表的增删改查对象
	private Logger logger = Logger.getLogger(DepartmentServlet.class);

	/**
	 * Constructor of the object.
	 */
	public DepartmentServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(); // 获取当前全局session对象
		
		String opr = request.getParameter("opr");
		if(opr == null){
			out.print("访问路径错误");
			return;
		}
		if(opr.equals("add")){ // 添加科室信息
			
			String depName = request.getParameter("depName");
			String depAddress = request.getParameter("depAddress");
			
			if(depName.equals("") || depAddress.equals("")){
				out.print("当前科室信息不能为空");
				return;
			}
			Department d = new Department(depName, depAddress);
			try {
				
				int a = depbiz.add(d);
				out.print(a);
				
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print(e.getMessage());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print(e.getMessage());
			}
			
		}else if(opr.equals("del")){ // 删除科室信息
			
			int id = Integer.parseInt(request.getParameter("id"));
			if(id < 0){
				out.print("没有需要删除的科室信息");
				return;
			}
			try {
				int a = depbiz.del(id);
				if(a > 0)
					out.print("删除成功");
				else
					out.print("删除失败");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print(e.getMessage());
			}
			
		}else if(opr.equals("update")){ // 修改科室信息
			
		}else if(opr.equals("getById")){ // 获取单个科室信息
			
			Department dep = null; // 事先存储当前的科室信息
			try {
				String depId = request.getParameter("depId");
				System.out.println(depId);
				dep = depbiz.getById(Integer.parseInt(depId)); // 访问数据库，获取科室信息
				String json = JSON.toJSONString(dep);
				out.print(json);
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print(e.getMessage());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print(e.getMessage());
			}
			
			
		}else if(opr.equals("list")){ // 分页形式查询所有科室信息
			
			try {
				int pagesize = 0; 
					pagesize = Integer.parseInt(request.getParameter("pagesize"));
				Page<Department> page = depbiz.getPage(pagesize);
				//request.setAttribute("list", page.getList());
				//request.getRequestDispatcher("list.jsp").forward(request, response);
				out.print(page.getList());
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				out.print(e.getMessage());
				logger.debug(e.getMessage());
			} catch (NumberFormatException e){
				out.print(e.getMessage());
				logger.debug(e.getMessage());
			}
			
			
		}else if(opr.equals("getByReg")){
			
			String regType = request.getParameter("regType");
			List<Department> list = new ArrayList<Department>();
			Map<String,String> map = new HashMap<String, String>();
			if(regType.equals("401")){
				map.put("Specialist","a");
			}
			list = depbiz.getAll(map);
			if(list == null){
				out.print("noDep");
				return;
			}
			String json = JSON.toJSONString(list);
			out.print(json);
		}
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
