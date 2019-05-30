package cn.vote.service;

import java.util.List;

/**
 * 为管理员分配权限信息
 * 
 * @author 解金化
 *	
 * @date 2017.08.08
 *
 */
public interface AdminResourceService {

	/**
	 * 为用户添加权限
	 * 
	 * @param adminId
	 * 		需要添加权限的用户的编号
	 * @param resIds
	 * 		需要添加的权限的集合
	 * 
	 * @throws Exception
	 * 		添加失败抛出异常
	 */
	public void addAdRe( Integer adminId , List<Integer> resIds ) throws Exception;
	
	/**
	 * 删除用户的权限信息
	 * 
	 * 根据用户的编号
	 * 
	 * @param admingId
	 * 		用户编号
	 * @throws Exception
	 * 		删除失败抛出异常
	 */
	public void deleteByAdminId( Integer admingId ) throws Exception;
	
	/**
	 * 根据编号删除用户的分配权限信息
	 * 
	 * @param id
	 * 		编号
	 * @throws Exception
	 * 		删除失败跑出异常
	 */
	public void deleteById( Integer id ) throws Exception;
}
