package cn.vote.dao;

import cn.vote.entity.Users;
import cn.vote.model.UserModel;
import cn.vote.util.Page;

import java.util.List;


public interface UserDao {
	
	
	
	public boolean addUser(Users u);
	
	/**
	 * 修改用户信息
	 * @param u 用户脏对象非
	 */
	public boolean updateUser(Users u);
	
	/**
	 * 删除用户
	 * @param userId 根据用户id删除用户
	 * @return
	 */
	public boolean delUser(Users u);
	
	/**
	 * 查询所有
	 * 
	 * @return
	 * 		查询到的结果
	 */
	public Long getAll();
	/**
	 * 分页查询用户根据用户姓名
	 * @param page
	 * @param u 查询条件
	 * @return
	 */
	public List<Users> getPage(Page<UserModel> page,String name,String tj);
	
	
	
	
	/**
	 * 投票排行榜
	 * @return
	 */
	List<Users> gettotal(Page<UserModel> page, String name);
	
	/**
	 * 这个方法用来验证编号是否存在
	 * 
	 * @param id
	 * 		需要验证的编号
	 * 
	 * @return
	 * 		从数据库中查询出的编号
	 */
	public String checkedId( String id );
	
	/**
	 * 通过用户编号获取用户信息
	 * @param id
	 * 		编号
	 * @return
	 * 		用户
	 */
	public Users getById( String id );
	
	public Users doLogin(String name,String pwd);
	/**
	 * 模糊查询条件下的用户人数
	 * @param name
	 * @return
	 */
	public Long getNumByName(String name);
	
	
	/**
	 * 投票排行
	 * @param j 
	 * @param i 
	 * @return
	 */
	List<Users> getVoteTen(int i, int j);

	public List<Users> getUserByUserName(String name);

	

	
	
	
}
