package com.accp.biz;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import com.accp.dao.UserDao;
import com.accp.dao.impl.UserImpl;
import com.accp.demo.Page;
import com.accp.demo.User;
import com.accp.tools.GenerateId;

/**
 * 该类用来进行用户的业务处理
 * 
 * @author 解金化
 * @version 1.0
 *
 *2017.03.09
 */
public class UserBiz {
	
	private Logger logger = Logger.getLogger(UserBiz.class); 
	private UserDao userdao = new UserImpl();
	
	/**
	 * 执行添加用户操作
	 * 
	 * @param u
	 * 		需要添加的用户的封装对象
	 * 
	 * @return
	 * 		返回执行操作数据库影响的行数
	 * 
	 * @throws Exception
	 * 		传入空值，抛出异常
	 */
	public int add(User u) throws Exception{
		
		if(u == null){
			
			logger.error("添加用户，空值异常");
			throw new Exception("添加用户时候，传入参数有误，空值");
			
		}else{
			List<String> list = userdao.getAllId(); // 在数据库中读出所有的用户编号
			
			String id = GenerateId.getId(); // 系统生成用户编号
			
			boolean b = false;
			
			do{
				b = false; // 假设没有相同的id生成
				for (String str : list) {
					
					if(str.equals(id)){
						b = true;
						id = GenerateId.getId();
						break;
					}									
				}
			}while(b);
			
			u.setUserId(id); // 为添加的用户生成一个用户id
			int a = userdao.add(u);
			return a;
			
		}
	}
	
	/**
	 * 用来删除用户
	 * 
	 * @param id
	 * 		需要删除的用户的编号
	 * 
	 * @return
	 * 		返回数据库的执行结果
	 * 
	 * @throws Exception
	 * 		参数异常进行处理
	 */
	public int del(String id) throws Exception{
		
		if(id == null || id.length() != 12){
			
			logger.debug("删除用户，参数传递不正确");
			throw new Exception("用户编号填写不正确");
			
		}else{
			
			int a = userdao.del(id);
			return a;
			
		}		
		
	}
	
	/**
	 * 执行用户修改
	 * 
	 * @author 解金化
	 * 
	 * @param u
	 * 		需要修改的用户的对象
	 * 
	 * @return
	 * 		返回数据库的影响行数
	 * 
	 * @throws Exception
	 * 		如果传入参数为空，抛出异常
	 */
	public int update(User u) throws Exception{
		
		if(u == null){
			logger.debug("修改用户信息时候，传入参数为空");
			throw new Exception("没有正确的用户被修改");
		}
		int a = userdao.update(u);
		return a;
	}
	
	/**
	 * 管理员查询所有用户
	 * 分页查询
	 * 
	 * @author 解金化
	 * 
	 * @param pagesize
	 * 		当前页码
	 * 
	 * @return
	 * 		返回当前页的对象
	 * 
	 * @throws NullPointerException
	 * 		页码空值异常
	 * 
	 * @throws SQLException
	 * 		数据库异常
	 */
	public Page<User> getPage(int pagesize,Map<String, String> map) throws NullPointerException,SQLException{
		
		if(pagesize <= 0){
			logger.debug("页码传入失败");
			throw new NullPointerException("页码为空");
		}
		Page<User> pages = userdao.getPage(pagesize,map); // 执行查询
		return pages;
		
	}
	
	/**
	 * 通过用户编号查询单个用户信息
	 * 
	 * @param id
	 * 		用户编号
	 * 
	 * @return
	 * 		返回单个用户对象
	 * 
	 * @throws Exception
	 * 		参数传递有错
	 */
	public User getById(String id) throws Exception{
		
		if(id == null || id.length() != 12){
			logger.debug("查询单个用户信息，id传入错误");
			throw new Exception("当前用户编号不正确");
		}
		List<User> list = userdao.getById(id);
		User u = null;
		for (User user : list) {
			u = user;
		}
		return u;
		
	}
	
		
}
