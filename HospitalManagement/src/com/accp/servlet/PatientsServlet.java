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
 * 	������Ϣ�Ĳ���
 * 
 * @author ���
 *@version 1.0
 *
 *2017.03.09
 */
public class PatientsServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(PatientsServlet.class); // ��־����
	private PatientBiz pb = new PatientBiz(); // ���߱����ɾ�Ĳ����
	Patient patient = null; // Ԥ�ȴ洢��ǰ��¼�Ļ��߶���
	
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
		HttpSession session = request.getSession(); // ��ȡ��ǰ��ȫ�ֶ���session
			
		String opr = request.getParameter("opr");
		
		if(opr == null)
			response.sendRedirect("/charisma-master/login.jsp"); // ��������κ����������ֱ����ת����¼ҳ��
					
		if (opr.equals("login")) { // ���ߵ�¼
			String name = request.getParameter("patName");
			String pwd = request.getParameter("patPwd");
			
			try {			
				//System.out.println("start login:"+System.currentTimeMillis());
				//logger.info("ִ�е�¼");
				patient = pb.login(name, pwd); // ִ�е�¼	
				
				if(patient == null){
					
					//�ڵ�½ǰ��ѯ��ǰ���û���Ϣ�Ƿ����
					Boolean bool = pb.exists(name);
					if(!bool){
						out.print("noName");
						return;
					}
					
					out.print("pwdError"); // ����pwdError����¼ʧ�ܣ�û���û�����ѯ��
				}else if(patient != null){				
					session.setAttribute("patient", patient); // ����½��Ķ�����Ϣ����ȫ������session��
					//logger.info("��¼�ɹ�");
					out.print("success"); // ����success����¼�ɹ�
				}
				//System.out.println("end login:"+System.currentTimeMillis());
					
			} catch (Exception e) {
				logger.error(e.getMessage());
				out.print("null"); // ��ָ���쳣��ǰ̨����
			}
		}else if(opr.equals("update")){ // �޸Ļ�����Ϣ
			
			// new �����󣬲�������ֵ
			Patient p = (Patient)session.getAttribute("patient");
			
			try {
				
				int a = pb.update(p);	// ִ���޸Ĳ���
				if(a > 0)
					request.getRequestDispatcher("���ظ����б����").forward(request, response);
				else
					request.getRequestDispatcher("<%=basePath%>/update.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				
				out.print("��Ϣ�ύ����");
				
			} 
			
		}else if(opr.equals("add")){ // ����ע��
			
			//new �����󣬲�������ֵ
			//ֵ��ǰ̨��ȡ
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
				
				int a = pb.add(p);	// ִ����Ӳ���
				
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
			
		}else if(opr.equals("list")){ // ��ѯ���л�����Ϣ
			
			int pagesize = 0; // ��ǰҳ��
			try{
				pagesize = Integer.parseInt(request.getParameter("pagesize")); // ��ȡǰ̨����ҳ�����
			}catch(Exception e){
				out.print("<a href='<%=basePath%>/Patients?opr=list&pagesize=1'>���ʳ���������¼���</a>");
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
				// TODO �Զ����ɵ� catch ��
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
