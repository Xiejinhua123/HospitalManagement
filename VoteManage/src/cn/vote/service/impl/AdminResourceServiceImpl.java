package cn.vote.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import cn.vote.dao.AdminDao;
import cn.vote.dao.AdminResourceDao;
import cn.vote.dao.ResourceDao;
import cn.vote.entity.Admin;
import cn.vote.entity.AdminResource;
import cn.vote.model.Constants;
import cn.vote.service.AdminResourceService;
import cn.vote.util.WebUtil;

/**
 * 分配权限
 * 
 * @author 解金化
 *
 */
public class AdminResourceServiceImpl implements AdminResourceService {

	private Logger log = Logger.getLogger(AdminResourceServiceImpl.class);
	
	private AdminResourceDao adminResourceDao;
	private AdminDao adminDao;
	private ResourceDao resourceDao;
	
	@Override
	public void addAdRe(Integer adminId, List<Integer> resIds)
			throws Exception {
		
		if( null == adminId || null == resIds || resIds.size() <= 0 ){
			log.info("为管理员分配权限失败，被分配人的编号为null");
			throw new Exception("nullpoint");
		}
		
		Admin admin = this.adminDao.getById( adminId );
		
		Admin allocationAdmin = null;
		try{
			allocationAdmin = (Admin) WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		}catch (Exception e) {
			throw new Exception("noLogin");
		}
		
		if( allocationAdmin.getRank() > admin.getRank() ){
			throw new Exception("分配人员权限不足，不能进行权限分配");
		}
		deleteByAdminId(adminId);
		this.deleteByAdminId(adminId);
		
		for (Integer id : resIds) {
			AdminResource ar = new AdminResource();
			ar.setAdminByAdminId(admin);
			ar.setAdminByAllocationId(allocationAdmin);
			ar.setAllocationTime(new Date());
			ar.setResource(this.resourceDao.getById(id));
			try{
				this.adminResourceDao.insert(ar);
			}catch (Exception e) {
				e.printStackTrace();
				throw new Exception("分配权限失败");
			}
		}
	}

	@Override
	public void deleteByAdminId(Integer adminId) throws Exception {
		if( null == adminId ){
			throw new Exception("在删除用户的所有权限的时候失败，提供的参数是空的");
		}
		
		Admin allocationAdmin = null;
		try{
			allocationAdmin = (Admin) WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		}catch (Exception e) {
			throw new Exception("操作人员没有登录");
		}
		
		if( allocationAdmin.getRank() >= this.adminDao.getById(adminId).getRank() ){
			throw new Exception("删除权限时候，操作人员的权限不足，不允许删除");
		}
		this.adminResourceDao.deleteByAdminId(adminId);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		if( null == id ){
			throw new Exception("在删除用户的所有权限的时候失败，提供的参数是空的");
		}
		
		Admin allocationAdmin = null;
		try{
			allocationAdmin = (Admin) WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		}catch (Exception e) {
			throw new Exception("操作人员没有登录");
		}
		
		if( allocationAdmin.getRank() <= this.adminResourceDao.getById(id).getAdminByAdminId().getRank() ){
			throw new Exception("删除权限时候，操作人员的权限不足，不允许删除");
		}
		this.adminResourceDao.delete(id);
	}

	
	
	
	
	public AdminResourceDao getAdminResourceDao() {
		return adminResourceDao;
	}

	public void setAdminResourceDao(AdminResourceDao adminResourceDao) {
		this.adminResourceDao = adminResourceDao;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

}
