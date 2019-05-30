package cn.vote.dao;

import java.util.List;

import cn.vote.entity.Admin;

public interface AdminDao {
	/**
	 * 登录
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 成功返回登录对象失败返回null
	 */
	public List<Admin> login(String name,String pwd);
	
	/**
	 * 检查用户名是否存在
	 * @param name 
	 * @return
	 */
	public boolean  checkName(String name);
	/**
	 * 添加用户
	 * @param u新建对象用户
	 * @return
	 */

	/**
	 * 添加admin用户
	 * 
	 * @param a
	 * 		需要添加的对象
	 */
	public void insert(Admin a);

	/**
	 * 通过管理员的编号，查询管理员的信息
	 * 
	 * @param adminId
	 * 		管理员编号
	 * @return
	 * 		查询到的管理原信息
	 */
	public Admin getById(Integer adminId);
	//查询全部管理员
	public List<Admin> getAll();
	
	void updateAdmin(Admin a);
	
	void addAdmin(Admin a);
}
