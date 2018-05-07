package com.accp.bizimpl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.accp.bizdao.RoleBiz;
import com.accp.bizdao.UserBiz;
import com.accp.dao.UserDao;
import com.accp.demo.Common;
import com.accp.demo.Department;
import com.accp.demo.UserRole;
import com.accp.demo.Users;
import com.accp.impl.UserImpl;
import com.accp.json.UserJson;
import com.accp.util.Generate;
import com.accp.util.Page;

public class UserBizImpl implements UserBiz {

	private Logger logger = Logger.getLogger(UserBizImpl.class);
	private UserDao usersdao = new UserImpl();
	
	@Override
	public Users usersLogin(String name, String pwd) throws Exception {
		
		if( null == name || name.length() != 12 ){
			logger.debug("用户登录，参数为空");
			throw new NullPointerException("UsersLogin() NullPointerException");
		}
		Users u = new Users();
		u.setUsersId(name);
		u.setUserPassword(pwd);
		List<Users> list = usersdao.getByColumn(u);
		if(list == null||list.size()<=0){ // 登录失败 进行null验证
			u = new Users();
			u.setUsersId(name);
			List<Users> u1 = usersdao.getByColumn(u); 
			
			if(u1 != null)
				throw new Exception("UsersLogin() name is null");  // 验证用户名为null 
			else
				throw new Exception("UsersLogin() pwd is error");  // 验证用户密码错误
		}
		Users user = list.get(0);
		if( user.getOnlineState().equals("1001") ){
			throw new Exception("have login");
		}
		return user;
	}

	@Override
	public Users usersAdd(Users users, List<Integer> list) throws Exception {
		
		if( null == users ){
			logger.debug("添加的时候参数是空的");
			throw new Exception("UsersAdd() Users is null");
		}
		
		while(true){
			String Usersid = Generate.getId(); // 自动获取用户的编号
			Users u = new Users();
			u.setUsersId(Usersid);
			List<Users> Userslist = usersdao.getByColumn(u); // 通过获取的编号查询是否在数据库中存在
			if(Userslist != null) continue; // null 为不存在  !null 存在  存在继续
			else break; // 不存在进行添加
		}
		if( null != list && list.size() != 0 ){
			//用当前的用户和角色信息构建用户角色对象，并放入用户对象
			RoleBiz rb = new RoleBizImpl();
			UserRole ur = null;
			List<UserRole> urlist = new LinkedList<>();
			for (Integer rid : list) {
				ur = new UserRole();
				ur.setRoles(rb.getById(rid));
				ur.setUsers(users);
				urlist.add(ur);
			}
			Set<UserRole> userRoles = new HashSet<>();
			userRoles.addAll(urlist);
			users.setUserRoles(userRoles);
		}
		
		Object obj = usersdao.add(users);
		
		if( null ==obj ){
			logger.debug("添加的时候执行数据库后失败");
			throw new Exception("UsersAdd() execute be defeated");
		}else return getById(obj.toString());

	}
	
	@Override
	public Boolean del(List<String> id) throws Exception {
		
		if( null == id || id.size() == 0 ){
			
			logger.debug("删除用户的时候没有给定用户的编号");
			throw new Exception("UsersDel() null parameter");
		}
		
		/**
		 * 删除用户得时候需要删除用互相关联的某些表中的信息
		 */
		
	
		boolean b=true;
		for (String Usersid : id) {
			if( null ==  Usersid || Usersid.length() != 12 ){
				logger.debug("当前给定的用户编号不正确");
			}
			if(usersdao.del(Usersid)==false) b=false;
		}
		if(b){
			return b;
		}
		else
		{
		logger.debug("在删除用户的时候没有全部删除");
		return false;
		}
		
	}

	@Override
	public Boolean update(Users u) throws Exception {
		
		if( null == u ){
			logger.debug("修改的时候，没有给定正确修改对象");
			throw new Exception("UsersUpdate() parameter is null");
		}
		
		boolean a = usersdao.update(u);
		
		if( a ){
			return true;
		}
		
		else return false;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Page<Users> getPage(Page page,Users u) throws Exception {

		
		if(page.getItems() == null || page.getPagesize() == null || null == u){
			logger.debug("分页查询，参数异常");
			throw new Exception("getPage() parameter error");
		}
		
		String sql = Generate.getSql(u);
		
		usersdao.getPage(page, sql, Generate.getParams(u));
		

		return null;
	}

	@Override
	public Users getById(String id) throws Exception {
		if( null == id || id.length() != 12 ){
			logger.debug("通过用户编号查询的时候参数不正确");
			throw new Exception("UsersgetById() parameter error"+id);
		}
		Users u = new Users();
		u.setUsersId(id);
		List<Users> list = usersdao.getByColumn(u);
		
		if(null == list){
			logger.debug("在数据库中不存在当前的用户");
			throw new Exception("UsersgetById() execute Users not find");
		}
		
		return list.get(0);
	}

	@Override
	public List<Users> getByColumn(Users u) throws Exception {
		return usersdao.getByColumn(u);
	}

	@Override
	public List<UserJson> getByDep(Department dep) throws Exception {
		
		List<Users> list = getByDep(dep,new Users());
		
		if( null != list && list.size() >= 0 ){
			List<UserJson> usList = new LinkedList<>();
			for (Users users : list) {
				if( users.getOnlineState().equals("1001") ){
					UserJson us = new UserJson();
					
					us.setUserName(users.getTrueName());
					us.setUserId(users.getUsersId());
					us.setDuty(Common.DICTIONA_MAP.get(users.getDuty()).getTypeValus());
					
					usList.add(us);
				}
			}
			return usList;
		}else return null;
	}
	
	@Override
	public List<Users> getByDep(Department dep,Users u) throws Exception {
		if( null == dep ){
			logger.debug("根据部门查询用户失败,参数为null");
			throw new Exception("users getByDep() paraneter is null");
		}
		u.setDepartment(dep);
		u.setOnlineState("1001");
		
		List<Users> list = getByColumn(u);
		
		return list;
	}

}
