package com.accp.bizdao;

import java.util.List;

import com.accp.demo.Privilege;
import com.accp.demo.RolePrivilege;
import com.accp.demo.Roles;

/**
 * 角色权限业务处理
 * 
 * @author xueshe01
 *
 */
public interface RolePrivilegeBiz {

	/**
	 * 为角色添加权限<br/>
	 * 
	 * @param rolid
	 * 		角色编号
	 * @param list
	 * 		需要添加的权限编号
	 * 
	 * @return
	 * 		添加成功返回true，添加失败返回false
	 */
	public boolean roleAddPri(Integer rolid,List<Integer> list) throws Exception;
	
	/**
	 * 删除角色的部分（勾选）权限信息<br/>
	 * 
	 * 事务处理<br/>
	 * 
	 * @param rolid
	 * 		角色编号
	 * @param priId
	 * 		勾选的需要删除的权限列表 
	 * @return
	 * 		事务提交返回true ， 事务回滚返回false
	 */
	public Boolean roleDelPri(Integer rolid,List<Integer> priId) throws Exception;
	
	/**
	 * 删除角色的全部权限信息<br/>
	 * 
	 * 事务处理<br/>
	 * 
	 * @param rolid
	 * 		角色编号
	 * 
	 * @return
	 * 		事务提交返回true ， 事务回滚返回false
	 */
	public Boolean roleDelPri(Integer rolid) throws Exception;
	
	/**
	 * 修改角色的权限<br/>
	 * 
	 * 在修改的时候，事先删除所有的权限<br/>
	 * 
	 * 然后再将当前的所有权限信息添加<br/>
	 * 
	 * 同时需要修改角色表“最后一次修改时间”一列<br/>
	 * 
	 * @param rolid
	 * 		需要修改的角色编号
	 * @param priId
	 * 		勾选的所有的权限编号
	 * @return
	 * 		事务提交返回true，事务回滚返回false
	 */
	public Boolean updatePri(Integer rolid,List<Integer> priId) throws Exception;
	
	/**
	 * 根据角色信息查询当前角色的所有角色权限信息<br/>
	 * 
	 * @param r
	 * 		角色对象
	 * @return
	 * 		角色对应的权限的实体对象
	 */
	public List<RolePrivilege> getByRole(Roles r) throws Exception;
	
	/**
	 * 通过权限编号获取所有角色权限信息
	 * 
	 * @param p
	 * 		权限对象
	 * @return
	 * @throws Exception
	 */
	public List<RolePrivilege> getByPriilege(Privilege p) throws Exception;
	
	/**
	 * 通过角色和权限获取绑定信息
	 * @param r
	 * 		角色对象
	 * @param p
	 * 		权限对象
	 * @return
	 * 		绑定信息集合
	 * @throws Exception
	 */
	public RolePrivilege getByRolePrivilege(Roles r,Privilege p) throws Exception;
	
	/**
	 * 通过编号查询角色权限对象
	 * 
	 * @param id
	 * 		编号
	 * @return
	 * 		有则返回对象，没有返回null
	 * @throws Exception
	 */
	public RolePrivilege getById(Integer id) throws Exception;

}
