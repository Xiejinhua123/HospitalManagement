package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.bizdao.DrugBiz;
import com.accp.bizimpl.DrugBizImpl;
import com.accp.demo.Drug;
import com.alibaba.fastjson.JSON;

@WebServlet("/servlet/drug")
public class DrugServlet extends HttpServlet {

	private DrugBiz drugBiz = new DrugBizImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opr = request.getParameter("opr");
		if (null == opr) {
			response.sendRedirect("../admin/page/error.html");
		}else if( opr.equals("getAll") ){
			getAll(request,response);
		}
	}
	
	/**
	 * 获取所有的药品集合
	 */
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		try {
			List<Drug> drugList = new LinkedList<>();
			Drug d = null;
			for (Drug drug : drugBiz.getAll(new Drug())) {
				d = new Drug();
				d.setDrugId(drug.getDrugId());
				d.setDrugName(drug.getDrugName());
				drugList.add(d);
			}
			out.println(JSON.toJSONString(drugList));
		} catch (Exception e) {
			out.println("error");
		}
		out.flush();
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
