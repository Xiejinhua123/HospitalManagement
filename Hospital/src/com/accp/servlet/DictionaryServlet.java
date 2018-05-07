package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.accp.bizimpl.DictionaryBizImpl;
import com.accp.demo.Common;
import com.accp.demo.Dictionary;
import com.alibaba.fastjson.JSON;
@WebServlet(urlPatterns = "/servlet/dic")
public class DictionaryServlet extends HttpServlet{
	private static final long serialVersionUID = 2102093566774116360L;
	private Logger logger = Logger.getLogger(UserServLet.class);
	private DictionaryBizImpl db=new DictionaryBizImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ac=req.getParameter("ac");
		if( ac.equals("getDic") )
		{
			getDic(req, resp);
		}
		else if(ac.equals("GroupByTypeName"))
		{
			GroupByTypeName(req, resp);
		}else if(ac.equals("getByName"))
		{
			getByName(req, resp);
		}else if(ac.equals("getById"))
		{
			getById(req, resp);
		}else if(ac.equals("addDic"))
		{
			addDic(req, resp);
		}else if(ac.equals("delByTypeName"))
		{
			delByTypeName(req, resp);
		}
		else if(ac.equals("delById"))
		{
			delById(req, resp);
		}else if(ac.equals("updateType"))//修改类型名称
		{
			update(req, resp);
		}else if(ac.equals("updateValue"))
		{
			updateValue(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
	protected void getById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String id=req.getParameter("id");
		Dictionary d=null;
		if(id!=null)
		{
			try {
				d=db.getById(Integer.parseInt(id));
			} catch (NumberFormatException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(d!=null)out.println(JSON.toJSONString(d));
			else out.print("noll");
		}
		else logger.error("getById() 参数为空");
		out.flush();
		out.close();
	}
	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String oldName=req.getParameter("oldName");
		String typeName=req.getParameter("newName");
		Dictionary d=new Dictionary();
		boolean b=false;
		if(typeName!=null && oldName!=null && typeName!="" && oldName!="")
		{
			try {
				b=db.updateTypeName(oldName, typeName);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(b) out.print("true");
		else out.print("false");
		out.flush();
		out.close();
	}
	protected void delById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String id=req.getParameter("id");
		boolean b=false;
		if(id!=null)
		{
			List<Integer> list=new ArrayList<Integer>();
			list.add(Integer.parseInt(id));
			try {
				b=db.del(list);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(b) out.print("true");
			else out.print("false");
		}
		else
		{
			logger.error("delById()参数为空");
		}
		out.flush();
		out.close();
	}
	protected void delByTypeName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String typeName=req.getParameter("name");
		boolean b=false;
		if(typeName!=null)
		{
			try {
				b=db.delByTypeName(typeName);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(b) out.print("true");
			else out.print("false");
		}
		else
		{
			logger.error("delByTypeName()参数为空");
		}
		out.flush();
		out.close();
	}
	protected void updateValue(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		System.out.println("nihao");
		String id=req.getParameter("id");
		String typeCode=req.getParameter("typeCode");
		String typeName=req.getParameter("typeName");
		String typeValues=req.getParameter("typeValues");
		String isVisible=req.getParameter("isVisible");
		String memo=req.getParameter("memo");
		Dictionary d=new Dictionary();
		if(typeCode!=null&&typeCode!="")d.setTypeCode(typeCode);
		if(typeName!=null&&typeName!="")d.setTypeName(typeName);
		if(typeValues!=null&&typeValues!="")d.setTypeValus(typeValues);
		if(isVisible!=null&&isVisible!="")d.setIsVisible(Integer.parseInt(isVisible));
		if(memo!=null&&memo!="")d.setMemo(memo);
		d.setDicId(Integer.parseInt(id));
		Dictionary d1=null;
		try {
			d1=db.update(d);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(d1!=null)
		{
			out.println(JSON.toJSONString(d1));
		}
		else 
		{
			out.println("shibai");
		}
		out.flush();
		out.close();
	}
	protected void addDic(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String typeCode=req.getParameter("typeCode");
		String typeName=req.getParameter("typeName");
		String typeValues=req.getParameter("typeValues");
		String isVisible=req.getParameter("isVisible");
		String memo=req.getParameter("memo");
		Dictionary d=new Dictionary();
		if(typeCode!=null&&typeCode!="")d.setTypeCode(typeCode);
		if(typeName!=null&&typeName!="")d.setTypeName(typeName);
		if(typeValues!=null&&typeValues!="")d.setTypeValus(typeValues);
		if(isVisible!=null&&isVisible!="")d.setIsVisible(Integer.parseInt(isVisible));
		if(memo!=null&&memo!="")d.setMemo(memo);
		Dictionary d1=null;
		try {
			d1=db.add(d);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(d1!=null)
		{
			out.println(JSON.toJSONString(d1));
		}
		else 
		{
			out.println("shibai");
		}
		out.flush();
		out.close();
	}
	protected void getByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		DictionaryBizImpl db=new DictionaryBizImpl();
		String name=req.getParameter("type");
		Dictionary d=new Dictionary();
		if(name!=null) d.setTypeName(name);
		List<Dictionary> list=null;
		try {
			list=db.getByColumn(d);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(list!=null)
		{
			String json=JSON.toJSONString(list);
			out.print(json);
		}
		else out.print("no dic");
		out.flush();
		out.close();
	}
	/*
	 * 获取typeName
	 */
	protected void GroupByTypeName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		DictionaryBizImpl db=new DictionaryBizImpl();
		List<String> list=null;
		try {
			list=db.getTypeName();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(list!=null) out.print(JSON.toJSONString(list));
		else
		{
			out.print(JSON.toJSONString("list is null"));
			logger.error("GroupByTypeName() list is null");
		}
		out.flush();
		out.close();
		
	}
	/**
	 * 根据typename查询
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getDic(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String typeName = req.getParameter("typename");
		List<Dictionary> list=new LinkedList<>();
		if( null != typeName){
			Map<String, Dictionary> map = null;
			while(true){
				try{
					map = Common.DICTIONA_MAP;
					break;
				}catch(Exception e){
					continue;
				}
			}
			for (Dictionary dic : map.values()) {
				if( dic.getTypeName().equals(typeName) ){
					list.add(dic);
				}
			}
		}else{
			DictionaryBizImpl db=new DictionaryBizImpl();
			try {
			list=db.getAll(new Dictionary());
			} catch (Exception e) {
				e.getMessage();
			}
		}
		String json=JSON.toJSONString(list);
		if(json!=null)
		{
			out.println(json);
		}
		else
		{
			logger.error("getDic() list is null"); 
		}
		out.flush();
		out.close();
	}

}
