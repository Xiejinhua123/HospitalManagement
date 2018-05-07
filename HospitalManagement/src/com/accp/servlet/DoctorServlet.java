package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import sun.net.www.protocol.ftp.Handler;

import com.accp.biz.DoctorBiz;
import com.accp.biz.UserBiz;
import com.accp.demo.Doctor;
import com.accp.demo.Page;
import com.accp.demo.User;
import com.alibaba.fastjson.JSON;

/**
 * 医生信息逻辑处理类
 * 
 * @author 解金化
 * @version 1.0
 * @time 2017.03.13
 *
 */
public class DoctorServlet extends HttpServlet {

	private Doctor doctor = null; // 预先存储医生信息
	private DoctorBiz docb = new DoctorBiz(); // 医生表的业务处理对象
	private Logger logger = Logger.getLogger(DoctorServlet.class);
	HttpSession session = null;
	

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

		response.setContentType("text/html;charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		session = request.getSession(); // 获取全局对象
		String opr = request.getParameter("opr");
		if(opr == null){
			out.print("noUrl");
			return;
		}
		if(opr.equals("add")){ // 添加医生
			/**
			 * new 出对象，
			 * 并且给对象赋值
			 */
			Doctor doc = new Doctor();
			
			int a = docb.add(doc); // 执行添加
			
			if(a > 0)
				out.print("执行成功（弹出的形式）");
			else
				out.print("添加失败");
			response.sendRedirect("doctorAdd.jsp");
			
		}else if(opr.equals("update")){ // 修改医生信息
			
		}else if(opr.equals("getById")){ // 查询一个医生信息
			
			String docId = request.getParameter("docId");
			if(docId == null || docId.length() != 12){
				String json = JSON.toJSONString("noUrl");
				out.print(json);
				return;
			}
			Doctor doctor = docb.getById(docId);
			if(doctor == null){
				String json = JSON.toJSONString("nothing");
				out.print(json);
				return;
			}
			String json = JSON.toJSONString(doctor);
			out.print(json);
			
		}else if(opr.equals("getPage")){ // 分页形式查询所有医生
			
			String pagesize = request.getParameter("pagesize");
			if(pagesize == null){
				out.print("noPagesize");
				return;
			}
			Map<String,String> map = new HashMap<String, String>();
			String depId = request.getParameter("depId");
			if(depId != null){
				map.put("depId",depId);
			}
			Page<Doctor> page = docb.getPage(Integer.parseInt(pagesize), map); // 获取当前的页面对象
			String json = JSON.toJSONString(page.getList());
			out.print(json);
			
		}else if(opr.equals("getNum")){
			
			String docid = request.getParameter("docId");
			if(docid == null){
				out.print("noUrl");
				return;
			}
			if(docid.length() != 12){
				out.print("docidErrar");
				return;
			}
			int num = docb.getNum(docid);
			String json = JSON.toJSONString(num);
			out.print(json);
		}else if(opr.equals("login")){
			logger.info("医生登录");
			String name = request.getParameter("docName");
			String pwd = request.getParameter("docPwd");
			
			try {			
				//System.out.println("start login:"+System.currentTimeMillis());
				//logger.info("执行登录");
				Doctor doctor = docb.login(name,pwd);
				
				if(doctor == null){
					
					//在登陆前查询当前的用户信息是否存在
					Doctor doc = docb.getById(name);
					if(doc == null){
						out.print("noId");
						return;
					}
					out.print("pwdError"); // 返回pwdError，登录失败，没有用户被查询到
				}else if(doctor != null){			
					session.setAttribute("doctor", doctor); // 将登陆后的对象信息放入全局容器session中
					//logger.info("登录成功");
					
					UserBiz ub = new UserBiz();
					User u = ub.getById(doctor.getDocId());
					u.setOnlineState("1001");
					int a = ub.update(u);
					
					out.print("success"); // 返回success，登录成功
				}
				//System.out.println("end login:"+System.currentTimeMillis());
					
			} catch (Exception e) {
				logger.error(e.getMessage());
				out.print("null"); // 空指针异常，前台捕获
			}
			logger.info("登录结束");
			
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
	
	public void timer() {
	    Timer timer = new Timer();
//	    System.out.println(new Date().toString());
	    timer.scheduleAtFixedRate(new TimerTask() {

		public void run() {
			
			HttpSession se = new DoctorServlet().session;
			
	    	  Object obj = se.getAttribute("doctor");
	    	  if(obj == null){
	    		  System.out.println("a");
	    	  }
	      }
	    }, 1000, 5000);
	 }
}
