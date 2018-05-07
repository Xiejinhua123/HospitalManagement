package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.accp.bizdao.DoctorOfferBiz;
import com.accp.bizdao.DrugBiz;
import com.accp.bizimpl.DoctorOfferBizImpl;
import com.accp.bizimpl.DrugBizImpl;
import com.accp.bizimpl.RegisteredBizImpl;
import com.accp.demo.DoctorOffer;
import com.accp.demo.Drug;
import com.accp.demo.Prescription;
import com.accp.demo.Registered;
import com.accp.demo.Users;
import com.alibaba.fastjson.JSON;
import com.xiao.Utilxiao.Commonxiao;

@SuppressWarnings("serial")
@WebServlet("/servlet/docoff")
public class DoctorOfferServlet extends HttpServlet {
	
	private DoctorOfferBiz docoffBiz = new DoctorOfferBizImpl();
	
	private Logger logger=Logger.getLogger(DoctorOfferServlet.class);
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opr = request.getParameter("opr");
		if (null == opr) {
			response.sendRedirect("../admin/page/error.html");
		}
		else if(opr.equals("add"))
		{
			add(request,response);
		}
		else if(opr.equals("getDrug"))
		{
			getDrug(request,response);
			
		}else if(opr.equals("getDrugByZ")){
			getDrugByZ(request,response);
		}
	}
	
	/**
	 * 根据给定的症状模糊查询药品信息
	 */
	private void getDrugByZ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String m = request.getParameter("m");
		if( null == m ){
			out.print("null");
			return;
		}
		Drug d = new Drug();
		d.setDrugSymptom(m);
		try {
			List<Drug> list = new DrugBizImpl().getAll(d);
			out.println(JSON.toJSONString(list));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		out.flush();
		out.close();
	}

	/**
	 * 根据处方获取药品集合
	 */
	protected void getDrug(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String docId = req.getParameter("m");
		
		if( null == docId ){
			out.print("null");
			return;
		}

		Map<String,List<Drug>> map=null;
		try {
			map = new DrugBizImpl().getBySys(Integer.parseInt(docId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(map!=null) out.println(JSON.toJSONString(map));
		else out.print("not drug");
		
		out.flush();
		out.close();
	}
	//添加
	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();

		String regId=req.getParameter("regId"); // 挂号编号
		String symptom=req.getParameter("symptom"); // 症状字符串
		String[] drugs = req.getParameterValues("drugs"); // 药品集合
		
		try {
			Users u=(Users) req.getSession().getAttribute("admin"); // 当前登录对向，有可能null指针异常
			
			ArrayList<Prescription> doc = docoffBiz.add(regId, u, symptom,drugs);

			out.println( JSON.toJSONString(doc) );
			
		} catch (Exception e) {
			out.println("shibai");
		}
		
		out.flush();
		out.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
