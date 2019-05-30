package cn.vote.service;

import java.util.List;

import cn.vote.entity.Resource;
import cn.vote.model.ResModel;
import cn.vote.model.ResourceModel;

/**
 * 权限实体的业务处理
 * 
 * @author 解金化
 * 
 * @date 2017.08.09
 * 
 */
public interface ResourceService {

	/**
	 * 添加权限信息
	 * 
	 * @throws Exception
	 * 		添加失败，抛出异常
	 */
	public void addRes( Resource res ) throws Exception;
	
	/**
	 * 修改权限信息
	 * 
	 * @param res
	 * 		需要修改的权限实体
	 * @throws Exception
	 * 		修改失败 抛出异常
	 */
	public void update( Resource res ) throws Exception;
	
	/**
	 * 通过编号查询详细的权限信息
	 * 
	 * @param id
	 * 		权限编号
	 * @return
	 * 		权限实体
	 * @throws Exception
	 */
	public ResModel getByid( Integer id ) throws Exception;

	/**
	 * 查询显示所有的权限信息
	 * 
	 * 当前登录人员拥有的权限  自己才能查看，在这里加入权限判断
	 * 
	 * @return
	 * 		返回权限模型集合
	 * @throws Exception
	 * 		查询失败抛出异常
	 */
	public List<ResModel> getAll() throws Exception;
	
	/**
	 * 查询所有的权限信息，在给用户添加权限的时候进行查询
	 * 
	 * @param resGrade
	 * 		需要查询的权限等级
	 * 
	 * @return
	 * 		查询到的具体信息
	 * 
	 * @throws Exception
	 * 		查询失败，抛出异常
	 */
	List<ResourceModel> ajaxGetAll(Integer resGrade) throws Exception;

	/**
	 * 删除权限
	 * 
	 * @param id
	 * 		需要删除的权限信息的编号
	 */
	public void delete(Integer id) throws Exception;

	List<ResourceModel> ajaxlevel1(Integer resGrade, Integer adminId)
			throws Exception;

	/**
	 * 根据父级权限查询编辑用户的权限
	 * @param parent
	 * @return
	 * @throws Exception 
	 */

	List<ResourceModel> getLevel(Integer parent, Integer resGrade,
			Integer adminId) throws Exception;

	/**
	 * 根据一级权限查询下面的二级权限
	 * @param parent
	 * @return
	 * @throws Exception 
	 */

	List<ResourceModel> getLevel2(Integer parent) throws Exception;
}
