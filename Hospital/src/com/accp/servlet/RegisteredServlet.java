package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accp.bizdao.RegisteredBiz;
import com.accp.bizimpl.RegisteredBizImpl;

import com.accp.demo.Patient;
import com.accp.demo.Users;
import com.accp.json.RegJson;
import com.accp.json.RegisteredJson;
import com.alibaba.fastjson.JSON;

@WebServlet("/servlet/registered")
public class RegisteredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisteredBiz registeredBiz = new RegisteredBizImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opr = request.getParameter("opr");
		if( null == opr ){
			response.sendRedirect("../admin/page/error.html");
			
		}else if (opr.equals("getNoDispose")) { //获取当前医生名下的挂号详情
			getNoDispose(request,response);
			
		}else if( opr.equals("add") ){ // 执行挂号
			addRegistered(request,response);
			
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * 获取没有处理过的挂号信息
	 */
	private void getNoDispose(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Users u = null;
		if( session.getAttribute("admin") != null ){
			u = (Users) session.getAttribute("admin");
		}else{
			return;
		}
		try {
			List<RegJson> list = registeredBiz.getByDoctorNoDispose(u.getUsersId());
			String json = JSON.toJSONString(list);
			out.print(json);
		} catch (Exception e) {
			e.getMessage();
		}
		out.flush();
		out.close();
	}

	private void addRegistered(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		PrintWriter out = response.getWriter();
		
		//通过患者登录后的session获取登录信息
		Object obj = request.getSession().getAttribute("patient");
		Patient pat = null;
		if( obj != null )pat = (Patient)obj;
		else{
			response.sendRedirect("../noLogin.html");
			return;
		}
		
		Integer patId = pat.getPatId();
		String uid = request.getParameter("userId");
		if( null == uid ){
			response.sendRedirect("../patient/page/chufang.jsp");
			return;
		}
		
		RegisteredJson rs = null;
		try {
			rs = registeredBiz.add(uid, patId);
		} catch (Exception e) {
			if( ("parameter is null").equals(e.getMessage()) ){
				out.println("<script>alert('访问参数不正确，网站无法提供资源')</script>");
			}else if( ("exceute error").equals(e.getMessage()) ){
				out.println("<script>alert('挂号失败,原因未知')</script>");
			}else{
				System.out.println("抛出未知异常");
				System.out.println(e.getMessage());
			}
			return;
		}
		request.getSession().setAttribute("reg", rs);
		request.setAttribute("reg", rs);
		
		request.getRequestDispatcher("../patient/page/chufang.jsp").forward(request, response);
		out.flush();
		out.close();
	}

}
