package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.accp.biz.DoctorOfferBiz;
import com.accp.biz.PrescriptionBiz;
import com.accp.demo.Doctor;
import com.accp.demo.DoctorOffer;
import com.accp.demo.Page;
import com.accp.demo.Prescription;
import com.alibaba.fastjson.JSON;

/**
 * ��������ɾ�Ĳ�
 * 
 * @author ���
 * @version 1.0
 * @date 2017.03.13
 *
 */
public class DoctorOfferServlet extends HttpServlet {
	
	private Logger logger = Logger.getLogger(DoctorOfferServlet.class);
	private DoctorOfferBiz dd = new DoctorOfferBiz(); // �����
	private PrescriptionBiz pb = new PrescriptionBiz(); // ������

	/**
	 * Constructor of the object.
	 */
	public DoctorOfferServlet() {
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
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		
		String opr = request.getParameter("opr");
		if(opr == null){
			String json = JSON.toJSONString("noUrl");
			out.print(json);
			return;
		}
		if(opr.equals("add")){ // ��Ӿ�����Ϣ
			
			DoctorOffer docoff = null;
			Doctor d = (Doctor) session.getAttribute("doctor");
			try {
				docoff = new DoctorOffer(
						d.getDocId(), 
						Integer.parseInt(request.getParameter("regId")), 
						request.getParameter("sympton"));				
			} catch (NumberFormatException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				logger.debug(e.getMessage());
				out.print("��ǰ��Ϣ����");
			}
			
			try {
				dd.add(docoff); // ��Ӿ����
				
				//1.��ȡҩƷ�� ͨ��ҩƷ���ƣ���ȡҩƷ���
				
				String[] drugName = request.getParameterValues("drugName");
				for(int i = 0; i < drugName.length;i++){
					System.out.println(drugName[i]);
				}
				return;
				
				//2.��ȡ���Ӧ��ҩƷ����
				
				//String[] drugNum = request.getParameterValues("drugNum");
				
				//3.���ɼ��ϣ�����Щ�����е���Ϣ�����봦����
				
				
				
				
				
				//Prescription p = new Prescription(dd.getByRegId(docoff.getRegId()).getdOId(), drugId);
				//pb.add(null);
			} catch (NullPointerException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				logger.debug(e.getMessage());
				out.print(e.getMessage());
			}
			
		}else if(opr.equals("getPage")){ // ��ҳ��ѯ����
			
			int pagesize = 0;
			try{
				pagesize = Integer.parseInt(request.getParameter("pagesize"));
			}catch (Exception e) {
				// TODO: handle exception
				out.print("������Ϣ����ȷ" + e.getMessage());
				return;
			}
			if(pagesize <= 0){
				out.print("������Ϣ����ȷ,����������ύ" );
				return;
			}
			Page<DoctorOffer> page = null;
			try {
				 page = dd.getPage(pagesize, null); // ��ȡ��ҳ��Ϣ
				 String json = JSON.toJSONString(page.getList());
				 out.print(json);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(opr.equals("getByDoc")){ // ����ҽ����ѯ
			
			String docid = request.getParameter("docid");
			if(docid == null || docid.length() != 12){
				out.print("��ǰ������ȷ������������ύ");
				return;
			}
			Map<String,String> map = new HashMap<String, String>(); // ��ȡ��ѯ����
			map.put("DocId", docid); // ���������Ͳ�ѯ����
			
			int pagesize = 0;
			try{
				pagesize = Integer.parseInt(request.getParameter("pagesize"));
			}catch (Exception e) {
				// TODO: handle exception
				out.print("������Ϣ����ȷ" + e.getMessage());
				return;
			}
			if(pagesize <= 0){
				out.print("������Ϣ����ȷ,����������ύ" );
				return;
			}
			
			try {
				Page<DoctorOffer> page = dd.getPage(pagesize, map);
				String json = JSON.toJSONString(page.getList());
				out.print(json);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				out.print(e.getMessage());
			}
			
		}else if(opr.equals("getByReg")){ // ���ݿ��Ҳ�ѯ
			String docid = request.getParameter("regid");
			if(docid == null || docid.length() != 12){
				out.print("��ǰ������ȷ������������ύ");
				return;
			}
			Map<String,String> map = new HashMap<String, String>(); // ��ȡ��ѯ����
			map.put("RegId", docid); // ���������Ͳ�ѯ����
			int pagesize = 0;
			try{
				pagesize = Integer.parseInt(request.getParameter("pagesize"));
			}catch (Exception e) {
				out.print("������Ϣ����ȷ" + e.getMessage());
				return;
			}
			if(pagesize <= 0){
				out.print("������Ϣ����ȷ,����������ύ" );
				return;
			}
			try {
				Page<DoctorOffer> page = dd.getPage(pagesize, map);
				String json = JSON.toJSONString(page.getList()); 
				out.print(json);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				out.print(e.getMessage());
			}
		}else if(opr.equals("getByRegId")){
			String regId = request.getParameter("regid");
			DoctorOffer d = dd.getByRegId(Integer.parseInt(regId));
			String json = JSON.toJSONString(d);
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
