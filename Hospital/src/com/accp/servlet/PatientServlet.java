package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.accp.bizdao.PatientBiz;
import com.accp.bizimpl.PatientBizImpl;
import com.accp.demo.Patient;
import com.alibaba.fastjson.JSON;

@WebServlet("/servlet/patient")
public class PatientServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PatientBiz patientBiz = new PatientBizImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String opr = request.getParameter("opr");
		
		if (null == opr) {
			response.sendRedirect("../admin/page/error.html");

		} else if (opr.equals("getById")) { // 通过编号获取用户信息
			getById(request, response);

		}else if (opr.equals("patLogin")) { // 患者登陆
			patLogin(request, response);
			
		}else if(opr.equals("zhuce")) // 患者注册
		{
			zhuce(request,response);
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void zhuce(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		PatientBizImpl pz=new PatientBizImpl();
		
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String card=request.getParameter("card");
		String tel=request.getParameter("tel");
		String sex=request.getParameter("sex");
		String born=request.getParameter("born");
		String address = request.getParameter("address");
		String bz=request.getParameter("bz");
		String bs=request.getParameter("bs");
		
		Patient p=new Patient();
		if(name!="") p.setPatName(name);
		if(pwd!="")p.setPatPassword(pwd);
		if(born!=""){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date = null;
			try {
				date = sdf.parse(born);
			} catch (ParseException e) {
				System.out.println("事件转换异常");
			} 
			p.setPatBirthday(date);
		}
		if(card!="") p.setPatCard(card);
		if(tel != "") p.setPatPhone(tel);
		if(sex !="")p.setPatSex(sex);
		if(address != "")p.setPatAddress(address);
		if(bz != "")p.setPatSymotoms(bz);
		if(bs!="")p.setGeneticDisorders(bs);
		Patient p1=null;
		String e = null;
		try {
			p1=pz.add(p);
			if(p1 != null)
			{
				String json=JSON.toJSONString(p1);
				e = json;
			}
			else out.print("noapat");
		} catch (Exception ea) {
			e = ea.getMessage();
		}finally {
			System.out.println(e);
			out.print(e);
			out.flush();
			out.close();
		}
		
	}
	/**
	 * 通过用户编号查询用户
	 */
	private void getById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String json = "";
		String patId = request.getParameter("patId");
		Patient p = null;
		try {
			p = patientBiz.getById(Integer.parseInt(patId));
		} catch (NumberFormatException e) {
			json = JSON.toJSONString("没有用户");
			out.println(json);
			return;
		} catch (Exception e) {
			if (e.getMessage().equals("patient getById() parameter is error")) {
				json = JSON.toJSONString("NullPointerException");
				out.print(json);
				return;
			}
		}
		json = JSON.toJSONString(p);
		out.println(json);
	}

	/**
	 * 患者登录
	 */
	private void patLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Patient pat = null;
		String json = "";
		try {
			pat = patientBiz.login(name, pwd);
			request.getSession().setAttribute("patient", pat);
			
			request.getSession().setMaxInactiveInterval(60*60*3); // 患者登录在三个小时后失效
			
			System.out.println("patientservlet session内的数据" + request.getSession().getAttribute("patient"));
			json = "yes";
		} catch (Exception e) {
			if( e.getMessage().equals("name is not found") ){
				json = "name";
			}else if (e.getMessage().equals("pwd is error")){
				json = "pwd";
			}else if ( ("have login").equals(e.getMessage()) ){
				json = "have login";
			}else{
				json = "error";
			}
		}finally{
			out.println(JSON.toJSONString(json));
			out.flush();
			out.close();
		}
	}
}
