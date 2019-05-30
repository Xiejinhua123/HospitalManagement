package cn.vote.dao;

import java.util.List;

import cn.vote.entity.AdminResource;

/**
 * 用户分配角色
 * 
 * @author 解金化
 *
 *	@date 2017.08.06
 *
 */
public interface AdminResourceDao {

	/**
	 * 分配权限
	 * @param ar
	 * 		权限实体 
	 */
	void insert(AdminResource ars);
	
	/**
	 * 根据编号删除
	 * 
	 * @param id
	 * 		编号
	 */
	public void delete(Integer id);
	
	/**
	 * 根据用户的编号，删除用户的所有分配角色
	 * 
	 * @param id
	 * 		用户编号
	 */
	public void deleteByAdminId( Integer id );
	
	/**
	 * 根据用户查询该用户所有的权限
	 * 
	 * @param adminId
	 * 		用户编号
	 * 
	 * @return
	 * 		查询到的用户的权限实体
	 */
	public void update(AdminResource ar);
	
	public List<AdminResource> selectByAdmin( Integer adminId);

	/**
	 * 根据编号获取分配信息
	 * 
	 * @param id
	 * 		分配编号
	 * @return
	 * 		获取到的实体信息
	 */
	AdminResource getById( Integer id );

	/**
	 * 根据权限信息查询分配信息
	 * 
	 * @param id
	 * 		编号
	 * @return
	 * 		获取到的集合
	 */
	List<AdminResource> getByResId(Integer id);

	/**
	 * 获取当前用户的权限，并规定需要的权限等级
	 * 
	 * @param id
	 * 		用户编号
	 * 
	 * @param i
	 * 		权限等级
	 * @return
	 * 		查询到的信息
	 */
	List<AdminResource> selectByAdminAndGrade(Integer id, int i);
	/**
	 * 获取当前用户权限的子集权限
	 * 
	 * @param id
	 * 		用户编号
	 * 
	 * @param i
	 * 		权限等级
	 * 
	 * @param parent
	 * 		父级id
	 * 
	 * @return
	 * 		查询到的信息
	 */
	List<AdminResource> selectByAdminAndGradeAndParent(Integer id, int i,int parent);
	/**
	 * 获取当前用户权限的子集权限
	 * 
	 * @param id
	 * 		用户编号
	 * 
	 * @param i
	 * 		权限等级
	 * @return
	 * 		查询到的信息
	 */
	List<AdminResource> selectByAdminAndParent(Integer id, int parent);
}
