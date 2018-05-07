package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.accp.bizdao.RoleBiz;
import com.accp.bizdao.UserBiz;
import com.accp.bizimpl.DepartmentBizImpl;
import com.accp.bizimpl.PrivilegeBizImpl;
import com.accp.bizimpl.RoleBizImpl;

import com.accp.bizimpl.UserBizImpl;
import com.accp.demo.Common;
import com.accp.demo.Department;
import com.accp.demo.Privilege;
import com.accp.demo.Roles;
import com.accp.demo.Users;
import com.accp.json.UserJson;
import com.accp.util.Page;
import com.alibaba.fastjson.JSON;

@WebServlet(urlPatterns = "/servet/user")
public class UserServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(UserServLet.class);
	private UserBiz ul = new UserBizImpl();
	private RoleBiz rz = new RoleBizImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServLet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ace = request.getParameter("ac");
		if (null == ace)
			response.sendRedirect("../admin/page/error.html");

		else if (ace.equals("login")) {
			login(request, response);
			
		} else if (ace.equals("Writeoff")) {
			writeoff(request, response);

		} else if (ace.equals("Authority")) {
			authority(request, response);

		} else if (ace.equals("getPage")) {
			getPagg(request, response);
			
		} else if (ace.equals("delUser")) {
			delUser(request, response);

		} else if (ace.equals("delUsers")) {// 删除所有选中用户
			delUsers(request, response);

		} else if (ace.equals("getUser")) {// 获取用户
			getUser(request, response);

		} else if (ace.equals("Editinformation")) {
			getEdit(request, response);

		} else if (ace.equals("editsave")) {
			getEditSave(request, response);

		} else if (ace.equals("addUser")) { // 添加用户
			getAddUser(request, response);

		} else if (ace.equals("addsave")) {
			getaddsave(request, response);

		} else if (ace.equals("getRole")) {
			getRole(request, response);

		} else if (ace.equals("getUserByDep")) {
			getUserByDep(request, response);
			
		} else if (ace.equals("Editinformation")) {
			getEdit(request, response);
			
		} else if (ace.equals("editsave")) {
			getEditSave(request, response);
			
		} else if (ace.equals("addUser")) {
			getAddUser(request, response);
			
		} else if (ace.equals("addsave")) {
			getaddsave(request, response);
			
		} else if (ace.equals("getRole")) {
			getRole(request, response);
			
		}else if (ace.equals("getUse1")) {
			getUser1(request, response);
			
		}else if(ace.equals("update"))
		{
			try {
				update(request, response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ParseException {
		UserBizImpl ub=new UserBizImpl();
		DepartmentBizImpl db=new DepartmentBizImpl();
		String userId=request.getParameter("userId");
		String name=request.getParameter("name");
		String idCard=request.getParameter("IdCard");
		String TelePhone=request.getParameter("TelePhone");
		String OfficePhone=request.getParameter("OfficePhone");
		String email=request.getParameter("Email");
		String sex=request.getParameter("sex");
		String onjobState=request.getParameter("OnjobState");
		String dep=request.getParameter("dep");
		String type=request.getParameter("type");
		String duty=request.getParameter("duty");
		String sr=request.getParameter("sr");
		Department de=null;
		if(dep!=null)
			try {
				de=db.getById(Integer.parseInt(dep));
			} catch (Exception e) {
				e.printStackTrace();
			}
		Users u=new Users();
		u.setTrueName(name);
		u.setIdCard(idCard);
		u.setDocSex(sex);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
	    Date date=null;
	    if(sr!=null) 
	    {
	    date = df.parse(sr);
	    u.setDocBirthday(date);
    	}
	    u.setUsersId(userId);
		u.setTelePhone(TelePhone);
		u.setOfficePhone(OfficePhone);
		u.setOnjobState(onjobState);
		u.setEmail(email);
		u.setDepartment(de);
		if(type!=null ) u.setIsSpecialist(type);
		u.setDuty(duty);
		boolean b=true;
		try {
			b = ub.update(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Users us=null;
		try {
			 us=ub.getById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(b) {
			request.setAttribute("u", us );
			request.getRequestDispatcher("../admin/page/queryUser.jsp").forward(request, response);
		}
		else
		{
			logger.error("update() 修改角色失败");
		}
	}
	private void getUser1(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("userId");
		Users u = null;
		try {
			u = ul.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(u!=null)
		{
			String date=u.getDocBirthday().toString();
			DateFormat df=new SimpleDateFormat(date);
			request.setAttribute("u", u);
			request.getRequestDispatcher("../admin/page/update_user.jsp").forward(request, response);
		}
		else {
			logger.error("getUser1()获取角色失败");
		}

	}
	private void getRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String json = "";
		PrintWriter out = response.getWriter();
		// HttpSession session=request.getSession();
		List<Roles> list = null;
		try {
			Roles r = new Roles();
			list = rz.getByColumn(r);
			request.setAttribute("list", list);
			if (null != list && list.size() > 0)
				json = JSON.toJSONString(list);
			else
				json = JSON.toJSONString("nothing");
			// session.setAttribute("getRole", list);
			// response.sendRedirect("../admin/page/addUsers.jsp");
		} catch (Exception e) {
			logger.error("在增加用户时获取角色失败");
			json = JSON.toJSONString("nothing");
		}

		out.println(json);
		out.flush();
		out.close();
	}

	private void getAddUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Users u = (Users) session.getAttribute("admin");
		Department dep = new Department();
		List<Roles> r = null;
		if (u != null) {
			request.setAttribute("r", r);
			request.setAttribute("u", u);
			try {
				request.getRequestDispatcher("/admin/page/addUsers.jsp").forward(request, response);
			} catch (Exception e) {
				logger.error("编辑用户信息页面跳转错误！");
			}
		} else
			response.sendRedirect("../admin/login.html");
		out.flush();
		out.close();
	}

	/***
	 * 增加用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void getaddsave(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Users u = (Users) session.getAttribute("admin");
		if (u != null) {
			String name = request.getParameter("name");
			String idCard = request.getParameter("idCard");
			String sex = request.getParameter("sex");
			Users users = new Users();
			users.setTrueName(name);
			users.setIdCard(idCard);
			Date da = new Date();
			users.setCreateTime(da);
			users.setDocSex(sex);
			String[] str = request.getParameterValues("Role");
			List<Integer> list = new ArrayList<Integer>();
			if (null != str && str.length > 0) {
				for (int i = 0; i < str.length; i++) {
					list.add(Integer.parseInt(str[i]));
				}
			}

			try {
				if (list.size() <= 0)
					list = null;
				Users us = ul.usersAdd(users, list);
				response.sendRedirect("/servet/user?ac=Editinformation");
			} catch (Exception e) {
				response.sendRedirect("/servet/user?ac=Editinformation");
			}

		} else
			response.sendRedirect("../admin/login.html");
		out.flush();
		out.close();
	}

	/***
	 * 编辑个人信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void getEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		UserBiz uz=new UserBizImpl();
		Users u= (Users) session.getAttribute("admin");
		String json="";
		if (u != null) {
			try {
				u=uz.getById(u.getUsersId());
				json=JSON.toJSONString(u);
			} catch (Exception e1) {
				logger.error("编辑个人信息错误");
				json=JSON.toJSONString("nothing");
			}
			request.setAttribute("u", u);
		} else
			json=JSON.toJSONString("nothing");
		out.flush();
		out.close();
	}

	/***
	 * 保存编辑
	 */
	private void getEditSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		UserBiz uz=new UserBizImpl();
		Users u = (Users) session.getAttribute("admin");
		String sid=request.getParameter("id");
		if (u != null) {
			String name = request.getParameter("name");
			String idCard = request.getParameter("idCard");
			String sex = request.getParameter("sex");
			String DocBirthday = request.getParameter("DocBirthday");
			String TelePhone = request.getParameter("TelePhone");
			String OfficePhone = request.getParameter("OfficePhone");
			String OnjobState = request.getParameter("OnjobState");
			String Email = request.getParameter("Email");
			Users users = new Users();
			users.setTrueName(name);
			users.setIdCard(idCard);
			Date date = null;
			Date da = new Date();
			if (com.xiao.Utilxiao.Commonxiao.IsNull(DocBirthday)) {
				try {
					date =com.xiao.Utilxiao.Commonxiao.StrEscapedDate(DocBirthday);
				} catch (ParseException e) {
					logger.error("修改个人信息时生日转换错误");
				}
			}
			users.setModifyTime(da);
			users.setDocSex(sex);
			users.setDocBirthday(date);
			users.setTelePhone(TelePhone);
			users.setOfficePhone(OfficePhone);
			users.setOnjobState(OnjobState);
			users.setEmail(Email);
 			users.setUsersId(sid);
			try {
				boolean b = ul.update(users);
				response.sendRedirect("../servet/user?ac=Editinformation");
			} catch (Exception e) {
				response.sendRedirect("../servet/user?ac=Editinformation");
			}
		} else
			response.sendRedirect("../admin/login.html");
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 删除单个用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void delUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("uid");
		List<String> list = new ArrayList<String>();
		list.add(userId);
		boolean b = true;
		try {
			b = ul.del(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (b) {
			getPagg(request, response);
		} else
			out.print("false");
		out.flush();
		out.close();
	}

	/**
	 * 删除选中用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void delUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		List<String> list = new ArrayList<String>();
		String[] userId = request.getParameterValues("userId");
		for (String string : userId) {

			list.add(string);
		}
		boolean b = true;
		try {
			b = ul.del(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (b) {
			getPagg(request, response);
		}

		else
			out.print("false");
		out.flush();
		out.close();
	}

	/**
	 * 显示用户
	 */
	private void getPagg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		Users users = new Users();
		String userId = request.getParameter("userId"); // 用户编号
		String trueName = request.getParameter("trueName"); // 用户真实姓名
		String depId = request.getParameter("name"); // 部门编号
		String pageSize = request.getParameter("pagesize"); // 获取当前页码
		String pageItems = request.getParameter("pageitems"); // 获取当前的一页条数

		if ("" != userId)
			users.setUsersId(userId);
		if ("" != trueName)
			users.setTrueName(trueName);
		if ("" != depId && !depId.equals("全部")) {
			try {
				Department dep = new DepartmentBizImpl().getById(Integer.parseInt(depId));
				users.setDepartment(dep);
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Page<UserJson> page = new Page<>();
		if (null != pageSize && "" != pageSize)
			page.setPagesize(Integer.parseInt(pageSize));
		if (null != pageItems && "" != pageItems)
			page.setItems(Integer.parseInt(pageItems));
		try {
			ul.getPage(page, users);
			out.print(JSON.toJSONString(page));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			out.println(JSON.toJSONString(""));
		}
		out.flush();
		out.close();
	}

	/**
	 * 登录
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String json = "";
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		try {
			Users u = ul.usersLogin(name, pwd);
			session.setAttribute("admin", u);
			session.setMaxInactiveInterval(10);
			json = JSON.toJSONString("success");
		} catch (Exception e) {
			if (e.getMessage().equals("UsersLogin() NullPointerException"))
				json = JSON.toJSONString("1");
			if (e.getMessage().equals("UsersLogin() name is null"))
				json = JSON.toJSONString("2");
			if (e.getMessage().equals("UsersLogin() pwd is error"))
				json = JSON.toJSONString("3");
			if( e.getMessage().equals("have login") )
				json = JSON.toJSONString("4");
			logger.error("用户登录时错误 ！ " + e.getMessage());
		}
		out.println(json);
		out.flush();
		out.close();
	}

	/**
	 * 注销
	 */
	private void writeoff(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Users u = (Users) session.getAttribute("admin");
		if (null != u) {
			
			session.removeAttribute("admin");
			session.invalidate();
			response.sendRedirect("../admin/login.html");
		}
	}

	/**
	 * 权限
	 */
	private void authority(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Object obj = session.getAttribute("privilege");
		List<Privilege> list = null;
		if( null == obj ){
			Users user = (Users)session.getAttribute("admin");
			try {
				list = new PrivilegeBizImpl().getPriByUsers(user);
				session.setAttribute("privilege", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else list = (List<Privilege>)obj;
		out.println(JSON.toJSONString(list));
		out.flush();
		out.close();
	}

	/**
	 * 通过用户编号获取用户信息
	 */
	private void getUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("userId");
		Users u = null;
		try {
			u = ul.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("u", u);
		response.getWriter().print(true);
		request.getRequestDispatcher("../admin/page/queryUser.jsp").forward(request, response);

	}

	/**
	 * 通过科室获取用户
	 */
	private void getUserByDep(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();

		String id = request.getParameter("depId");
		String type = request.getParameter("type");
		Integer depId = null;
		if (id != null) {
			depId = Integer.parseInt(id);
		} else
			logger.error("getUser() id is null");

		DepartmentBizImpl d = new DepartmentBizImpl();
		Department dep = null;
		try {
			dep = d.getById(depId);// 根据科室Id查询科室
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == dep) {
			out.print(JSON.toJSONString("no"));
		}
		UserBizImpl ub = new UserBizImpl();
		Users u = new Users();
		u.setOnlineState("1001");
		u.setDepartment(dep);// 用户集合
		if( null != type ){
			u.setIsSpecialist(type); // 这是选择专家号或者是普通号
		}
		List<UserJson> list = null;
		try {
//			list = ub.getByDep(dep);// 根据科室查询用户
			List<Users> renlist = ub.getByColumn(u);
			list = new LinkedList<>();
			
			for (Users users : renlist) {
				UserJson us = new UserJson();
				
				us.setUserName(users.getTrueName());
				us.setUserId(users.getUsersId());
				while(true){
					String tyoe = null;
					try{
						tyoe = Common.DICTIONA_MAP.get(users.getIsSpecialist()).getTypeValus();
						logger.error(tyoe);
						us.setIsSpecialist(tyoe);
						break;
					}catch(Exception e){
						wait(1000);
						continue;
					}
				}
				list.add(us);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String json =JSON.toJSONString( list);
	
		if(json.equals("[]"))
		{
			logger.error("getUser() list is null");
		} 
		out.print(json);
		out.flush();
		out.close();
	}


}
