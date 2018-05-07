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

import org.apache.log4j.Logger;

import com.accp.bizdao.PrescriptionBiz;
import com.accp.bizimpl.PrescriptionBizImpl;
import com.accp.demo.Prescription;
import com.accp.demo.Users;
import com.alibaba.fastjson.JSON;


/**
 * Servlet implementation class PrescriptionServlet
 */
/***
 * 处方
 * @author Administrator
 *
 */
@WebServlet("/servlet/prescription")
public class PrescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PrescriptionBiz prescriptionBiz = new PrescriptionBizImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrescriptionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opr = request.getParameter("opr");
		if( null == opr ){
			response.sendRedirect("../admin/page/error.html");
			
		}else if( opr.equals("getPreByReg") ){ // 通过挂号编号查循处方信息
			getPreByReg(request,response);
		}
		/***
		 * 根据挂号编号查询处方
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/***
	 * 根据挂号编号查询处方
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void getPreByReg(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		PrintWriter out = response.getWriter();
		
		String regid = request.getParameter("regid");
		String json = null;
		try {
			json = prescriptionBiz.getPreByReg(regid);
		} catch (Exception e) {
			
		}
		
		out.println(json);
		out.flush();
		out.close();
	}

	
}
