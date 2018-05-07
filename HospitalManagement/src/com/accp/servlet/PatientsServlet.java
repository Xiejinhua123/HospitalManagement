package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.accp.biz.PatientBiz;
import com.accp.dao.PatientDao;
import com.accp.demo.Page;
import com.accp.demo.Patient;
import com.alibaba.fastjson.JSON;

/**
 * 	患者信息的操作
 * 
 * @author 解金化
 *@version 1.0
 *
 *2017.03.09
 */
public class PatientsServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(PatientsServlet.class); // 日志对象
	private PatientBiz pb = new PatientBiz(); // 患者表的增删改查对象
	Patient patient = null; // 预先存储当前登录的患者对象
	
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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); // 获取当前的全局对象session
			
		String opr = request.getParameter("opr");
		
		if(opr == null)
			response.sendRedirect("/charisma-master/login.jsp"); // 如果咩有任何请求参数，直接跳转到登录页面
					
		if (opr.equals("login")) { // 患者登录
			String name = request.getParameter("patName");
			String pwd = request.getParameter("patPwd");
			
			try {			
				//System.out.println("start login:"+System.currentTimeMillis());
				//logger.info("执行登录");
				patient = pb.login(name, pwd); // 执行登录	
				
				if(patient == null){
					
					//在登陆前查询当前的用户信息是否存在
					Boolean bool = pb.exists(name);
					if(!bool){
						out.print("noName");
						return;
					}
					
					out.print("pwdError"); // 返回pwdError，登录失败，没有用户被查询到
				}else if(patient != null){				
					session.setAttribute("patient", patient); // 将登陆后的对象信息放入全局容器session中
					//logger.info("登录成功");
					out.print("success"); // 返回success，登录成功
				}
				//System.out.println("end login:"+System.currentTimeMillis());
					
			} catch (Exception e) {
				logger.error(e.getMessage());
				out.print("null"); // 空指针异常，前台捕获
			}
		}else if(opr.equals("update")){ // 修改患者信息
			
			// new 出对象，并给对象赋值
			Patient p = (Patient)session.getAttribute("patient");
			
			try {
				
				int a = pb.update(p);	// 执行修改操作
				if(a > 0)
					request.getRequestDispatcher("返回个人列表界面").forward(request, response);
				else
					request.getRequestDispatcher("<%=basePath%>/update.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				
				out.print("信息提交有误");
				
			} 
			
		}else if(opr.equals("add")){ // 患者注册
			
			//new 出对象，并给对象赋值
			//值从前台获取
			Patient p = new Patient();
			
			String name = request.getParameter("PatName");
			String phone = request.getParameter("PatPhone");
			String idcard = request.getParameter("PatIdCard");
			String pwd = request.getParameter("PatPwd");
			
			if(name != null){
				p.setPatNickname(name);
			}
			if(phone != null){
				p.setPatPhone(phone);
			}
			if(idcard != null){
				p.setPatCard(idcard);
			}
			
			p.setPatPassword(pwd);
			
			try {
				
				int a = pb.add(p);	// 执行添加操作
				
				if(a > 0){
					String json = JSON.toJSONString("success");
					out.print(json);
				}
				else{
					String json = JSON.toJSONString("nothing");
					out.print(json);
				}
				
			} catch (Exception e) {			
								
				String json = JSON.toJSONString(e.getMessage());
				out.print(json);
				
			} 
			
		}else if(opr.equals("list")){ // 查询所有患者信息
			
			int pagesize = 0; // 当前页数
			try{
				pagesize = Integer.parseInt(request.getParameter("pagesize")); // 获取前台传入页码参数
			}catch(Exception e){
				out.print("<a href='<%=basePath%>/Patients?opr=list&pagesize=1'>访问出错，点击重新加载</a>");
			}
			
			Page<Patient> page = pb.getAll(pagesize);
			request.setAttribute("page", page);
			request.getRequestDispatcher("<%=basePath%>/patientList.jsp").forward(request, response);
			
		}else if(opr.equals("getById")){
			String patId = request.getParameter("patId");
			if(patId == null){
				String json = JSON.toJSONString("noPatId");
				out.print(json);
				return;
			}
			try {
				Patient p = pb.getById(patId);
				String json = JSON.toJSONString(p);
				out.print(json);
			} catch (IllegalAccessException e) {
				// TODO 自动生成的 catch 块
				String json = JSON.toJSONString("noPatId");
				out.print(json);
				return;
			}
		}
		//out.flush();
		//out.close();
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

		doGet(request, response);
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
