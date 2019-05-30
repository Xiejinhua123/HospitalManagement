package cn.vote.dao;

import java.util.List;

import cn.vote.entity.Resource;

/**
 * 权限实体的增删改查
 * 
 * @author 解金化
 *
 */
public interface ResourceDao {

	/**
	 * 添加权限信息
	 * 
	 * @param res
	 * 		权限实体
	 */
	public void insert( Resource res );
	
	/**
	 * 修改权限
	 * 
	 * @param res
	 * 		需要修改的实体信息
	 * @throws Exception 
	 */
	public void update( Resource res ) throws IllegalArgumentException, IllegalAccessException, Exception;
	
	/**
	 * 根据权限的编号，查询编号信息
	 * 
	 * @param id
	 * 		编号
	 * @return
	 * 		查询到的实体信息
	 */
	public Resource getById( Integer id );
	
	/**
	 * 获取所有的权限信息，多用在为用户分配权限的时候
	 * 
	 * @return
	 * 		获取到的权限的集合信息
	 */
	public List<Resource> getAll();
	
	/**
	 * 根据管理员id获取用户权限
	 * @param userId
	 * @return
	 */

	List<Resource> getByUserId(Integer adminId);
	
	/**
	 * 通过父级编号  查询当前所有权限信息
	 * 
	 * @param parentId
	 * 		父级编号
	 * @return
	 * 		查询到的权限详情
	 */
	List<Resource> getByParentId(Integer parentId);
}
