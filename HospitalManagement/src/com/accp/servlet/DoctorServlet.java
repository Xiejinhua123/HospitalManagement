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
 * ҽ����Ϣ�߼�������
 * 
 * @author ���
 * @version 1.0
 * @time 2017.03.13
 *
 */
public class DoctorServlet extends HttpServlet {

	private Doctor doctor = null; // Ԥ�ȴ洢ҽ����Ϣ
	private DoctorBiz docb = new DoctorBiz(); // ҽ�����ҵ�������
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
		session = request.getSession(); // ��ȡȫ�ֶ���
		String opr = request.getParameter("opr");
		if(opr == null){
			out.print("noUrl");
			return;
		}
		if(opr.equals("add")){ // ���ҽ��
			/**
			 * new ������
			 * ���Ҹ�����ֵ
			 */
			Doctor doc = new Doctor();
			
			int a = docb.add(doc); // ִ�����
			
			if(a > 0)
				out.print("ִ�гɹ�����������ʽ��");
			else
				out.print("���ʧ��");
			response.sendRedirect("doctorAdd.jsp");
			
		}else if(opr.equals("update")){ // �޸�ҽ����Ϣ
			
		}else if(opr.equals("getById")){ // ��ѯһ��ҽ����Ϣ
			
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
			
		}else if(opr.equals("getPage")){ // ��ҳ��ʽ��ѯ����ҽ��
			
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
			Page<Doctor> page = docb.getPage(Integer.parseInt(pagesize), map); // ��ȡ��ǰ��ҳ�����
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
			logger.info("ҽ����¼");
			String name = request.getParameter("docName");
			String pwd = request.getParameter("docPwd");
			
			try {			
				//System.out.println("start login:"+System.currentTimeMillis());
				//logger.info("ִ�е�¼");
				Doctor doctor = docb.login(name,pwd);
				
				if(doctor == null){
					
					//�ڵ�½ǰ��ѯ��ǰ���û���Ϣ�Ƿ����
					Doctor doc = docb.getById(name);
					if(doc == null){
						out.print("noId");
						return;
					}
					out.print("pwdError"); // ����pwdError����¼ʧ�ܣ�û���û�����ѯ��
				}else if(doctor != null){			
					session.setAttribute("doctor", doctor); // ����½��Ķ�����Ϣ����ȫ������session��
					//logger.info("��¼�ɹ�");
					
					UserBiz ub = new UserBiz();
					User u = ub.getById(doctor.getDocId());
					u.setOnlineState("1001");
					int a = ub.update(u);
					
					out.print("success"); // ����success����¼�ɹ�
				}
				//System.out.println("end login:"+System.currentTimeMillis());
					
			} catch (Exception e) {
				logger.error(e.getMessage());
				out.print("null"); // ��ָ���쳣��ǰ̨����
			}
			logger.info("��¼����");
			
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
