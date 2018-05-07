package com.accp.bizdao;

import java.util.List;

import com.accp.demo.Patient;
import com.accp.util.Page;

/**
 * 患者表业务逻辑
 * 
 * @author 解金化
 * @version 1.0
 * @date 2017.04.22
 */
public interface PatientBiz {
	/**
	 * 执行登录
	 * 
	 * @param name
	 * 		名称：手机号、昵称、身份证号
	 * 		
	 * @param pwd
	 * 		密码
	 * @return
	 * 		成功返回对象，失败返回null
	 */
	public Patient login(String name,String pwd) throws Exception;
	
	/**
	 * 用户注册
	 * 
	 * 三种注册情况
	 * 昵称，手机号，身份账号
	 * 
	 * 不同的注册情况在servlet进行处理，
	 * 这里的参数已经具有完备的数据，不需要进行处理
	 * 添加 返回当前的编号
	 * 
	 * @param p
	 * 		具有完备属性的对象
	 * @return
	 * 		添加成功，返回对象，添加失败，返回null
	 */
	public Patient add(Patient p)throws Exception;
	
	/**
	 * 执行修改，用于用户完善自己的信息
	 *
	 * @param p
	 * 		脏对象
	 * 
	 * @return
	 * 		修改成功，返回true,修改失败，返回false
	 */
	public Patient update(Patient p)throws Exception;
	
	/**
	 * 执行删除
	 * 
	 * @param patId
	 * 		前台给定的参数
	 * @return
	 * 	
	 * @throws Exception
	 */
	public Boolean del(List<Integer> patId) throws Exception;
	
	/**
	 * 通过用户编号，获取用户信息
	 * 
	 * @param id
	 * 		查询的患者编号
	 * @return
	 * 		有则返回对象，没有则返回null
	 */
	public Patient getById(Integer id)throws Exception;
	
	/**
	 * 获取分页信息
	 * 
	 * @param page
	 * 		没有完整属性的page对象
	 * @param p
	 * 		查询条件构成的对象
	 * @return
	 * 		返回完整属性值得page对象
	 */
	public void getPage(Page<Patient> page,Patient p) throws Exception;
	
	/**
	 * 动态查询患者信息
	 * 
	 * @param p
	 * 		动态条件构成的对象
	 * @return
	 * 		有则返回集合，没有则返回null
	 * @throws Exception
	 */
	public List<Patient> getByColumn(Patient p) throws Exception;
}
