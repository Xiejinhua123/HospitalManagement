package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.accp.biz.RegisteredBiz;
import com.accp.demo.Doctor;
import com.accp.demo.Page;
import com.accp.demo.Patient;
import com.accp.demo.Registered;
import com.alibaba.fastjson.JSON;

/**
 * �Һ���Ϣ�߼�������
 * 
 * @author ���
 * @version 1.0
 * @date 2017.03.13
 */
public class RegiteredServlet extends HttpServlet {
	
	private Logger logger = Logger.getLogger(RegiteredServlet.class); // ��־�ļ�
	private RegisteredBiz rb = new RegisteredBiz();

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
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String opr = request.getParameter("opr");
		if(opr == null){
			String json = JSON.toJSONString("noUrl");
			out.print(json);// ����noURL,��ǰ·������
			return;
		}
		
		if (opr.equals("add")){ // �Һ�
			if(session.getAttribute("patient") == null){
				String json = JSON.toJSONString("noPatient");
				out.print(json); // û�е�½
				return;
			}
			
			Patient pat = (Patient)session.getAttribute("patient");
			int patId = pat.getPatId();	
						
			String docId = request.getParameter("docId");
			if(docId.length() != 12 || docId == null){
				String json = JSON.toJSONString("noDoc");
				out.print(json); // û��ҽ��
				return;
			}
			
			String depId = request.getParameter("depId");
			if(depId.length() < 0 || depId == null){
				String json = JSON.toJSONString("noDep");
				out.print(json); // û�п���
				return;
			}
			
			String regType = request.getParameter("regType");
			if(depId.length() < 0 || depId == null){
				String json = JSON.toJSONString("noType");
				out.print(json); // û�йҺ�����
				return;
			}			
			
			Registered registered = new Registered();
			registered.setDocId(docId);
			registered.setDepId(Integer.parseInt(depId));
			registered.setPatId(patId);
			registered.setRegType(regType);
			
			int a = rb.add(registered);
			if(a > 0){
				String json = JSON.toJSONString(a);
				out.print(json);
			}else{
				String json = JSON.toJSONString("nothing");
				out.print(json);
			}
			
		}else if(opr.equals("getById")){ // ͨ���Һű�Ż�ȡ��ǰ�û��ĹҺ���Ϣ
			
			
			
		}else if(opr.equals("list")){ // ��ҳ��ʽ��ѯ���еĹҺ���Ϣ
			out.print("");
		}else if(opr.equals("getByDoc")){
			String docId = request.getParameter("docId");
			if(docId == null){
				out.print("�������");
				return;
			}
			String pagesize = request.getParameter("pagesize");
			if(pagesize == null){
				out.print("ҳ�����");
				return;
			}
			
			Map<String, String> map=new HashMap<String, String>();
			map.put("DocId", docId);			
			try {
				Page<Registered> page=rb.getPage(Integer.parseInt(pagesize), map);
				String json = JSON.toJSONString(page.getList());
				out.print(json);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print(e.getMessage());
				logger.debug(e.getMessage());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print(e.getMessage());
				logger.debug(e.getMessage());
			}
		}else if(opr.equals("getNoDispose")){
			Object obj = session.getAttribute("doctor");
			if(obj == null){
				String json = JSON.toJSONString("noDoctor");
				out.print(json);
				return;
			}
			String doctorId = ((Doctor)session.getAttribute("doctor")).getDocId();
			try {
				List<Registered> list = rb.getNoDispose(doctorId);
				String json = JSON.toJSONString(list);
				out.print(json);
			} catch (IllegalAccessException e) {
			}
		}
		
		out.flush();
		out.close();
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
