package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.accp.biz.DoctorOfferBiz;
import com.accp.biz.DrugBiz;
import com.accp.biz.PrescriptionBiz;
import com.accp.biz.RegisteredBiz;
import com.accp.demo.Doctor;
import com.accp.demo.DoctorOffer;
import com.accp.demo.Prescription;
import com.accp.demo.Registered;
import com.accp.tools.GenerateId;
import com.alibaba.fastjson.JSON;

/**
 * 这个servelt执行处方的增删改查
 * 
 * @author xueshe01
 *
 */
public class PrescriptionServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(PrescriptionServlet.class); 
	
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
		HttpSession session = request.getSession();
		
		String opr = request.getParameter("opr");
		if(opr == null){
			String json = JSON.toJSONString("UrlError");
			out.print(json);
			return;
		}
		
		if(opr.equals("add")){ // 添加
			
			String s = request.getParameter("yaofang"); // 药方
			String rid = request.getParameter("rid"); // 挂号编号
			String sympton = request.getParameter("sympton"); // 症状
			String docid = ((Doctor)session.getAttribute("doctor")).getDocId(); // 医生编号
			
			DoctorOffer docoff = new DoctorOffer();
			docoff.setDocId(docid);
			docoff.setRegId(Integer.parseInt(rid));
			docoff.setSympton(sympton);
			
			int a = new DoctorOfferBiz().add(docoff);
			int doid = 0;
			doid = (new DoctorOfferBiz().getByRegId(Integer.parseInt(rid))).getdOId();
			Map<String,String> map = GenerateId.getString(s);
			
			for (String str : map.keySet()) {
				
				int drugId = new DrugBiz().getDrugId(str);
				
				Prescription p = new Prescription(doid, drugId, Integer.parseInt(map.get(str)));
				new PrescriptionBiz().add(p);
			}
			
			Registered r = new RegisteredBiz().getById(Integer.parseInt(rid));
			r.setRegState("503");
			new RegisteredBiz().update(r);
			
			String json = JSON.toJSONString("success");
			out.print(json);
			
		}else if("getDrugByDoId".equals(opr)){
			String doid = request.getParameter("doid");
			if(doid != null){
				int id = Integer.parseInt(doid);
				List<Prescription> list = new PrescriptionBiz().getList(id);
				String json = JSON.toJSONString(list);
				out.print(json);
			}
		}
		else if("getDrugByDoIda".equals(opr)){
			
			String doid = request.getParameter("doid");
			if(doid != null){
				int id = Integer.parseInt(doid);
				List<Prescription> list = new PrescriptionBiz().getList(id);
				request.setAttribute("list", list);
				request.getRequestDispatcher("JSP/yaofang.jsp").forward(request, response);
			}
			
		}
		
		out.flush();
		out.close();
	}

}
