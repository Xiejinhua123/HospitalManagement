package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.bizdao.DepartmenBiz;
import com.accp.bizimpl.DepartmentBizImpl;
import com.accp.demo.Department;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/servlet/department")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmenBiz departmenBiz = new DepartmentBizImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opr = request.getParameter("opr");
		if (null == opr) {
			response.sendRedirect("../admin/page/error.html");
		}
		else if (opr.equals("Department")) { // 获取全部科室
			getDeop(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


	/**
	 * 获取科室信息
	 */
	private void getDeop(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		Department d = new Department();
		try {
			List<Department> Deplist = departmenBiz.getAll(d);
			if ( null == Deplist || Deplist.size() == 0 ) {
				out.print("kong");
			} else {
				out.print(JSON.toJSONString(Deplist));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		out.flush();
		out.close();
	}
}
