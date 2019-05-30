package cn.vote.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.vote.dao.AdminDao;
import cn.vote.dao.AdminResourceDao;
import cn.vote.dao.ResourceDao;
import cn.vote.entity.Admin;
import cn.vote.model.AdminModel;
import cn.vote.model.AdminUpdateModel;
import cn.vote.model.Constants;
import cn.vote.service.AdminService;
import cn.vote.service.MenuService;
import cn.vote.util.DateUtils;
import cn.vote.util.MD5;
import cn.vote.util.WebUtil;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao adminDao;
	
	private ResourceDao resourceDao;
	
	private AdminResourceDao adminResourceDao;
	
	private MenuService menuService;
	
	@Override
	public void doLogin(String name, String pwd) throws Exception {
		
		if( null == name || null == pwd ){
			throw new Exception("管理员登录账号密码发生错误");
		} 
		
		ServletActionContext.getRequest().getSession().removeAttribute(Constants.SESSION_LOGIN_MENUHTML);
		
		pwd = new MD5(pwd).compute();
		List<Admin> list = adminDao.login(name, pwd);
		if( null == list || list.size() <= 0 ){
			throw new Exception("noLogin");
		}else{
			if( list.get(0).getDeleted() == 0 ){
				WebUtil.setSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY ,list.get(0));
				this.menuService.toSessionList( this.menuService.getMenu() );
			}else{
				throw new Exception("state");
			}
		}
	}

	@Override
	public Admin addAdmin(String name) throws Exception {

		if( null == name || name.length() <= 0 ){
			throw new Exception("管理员添加下级管理员失败，用户名为null");
		}
		Admin allocationAdmin = null;
		try{
			allocationAdmin = (Admin) WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		}catch (Exception e) {
			throw new Exception("noLogin");
		}
		Date date = new Date();
		Admin admin = new Admin();
		admin.setAdminByCreateId(allocationAdmin);
		admin.setAdminByUpdateId(allocationAdmin);
		admin.setCreateTime( date );
		admin.setDeleted(0);
		admin.setUpdateTime( date );
		admin.setRank(allocationAdmin.getRank() + 1);
		admin.setName(name);
		admin.setManagePassword(new MD5("123456").compute());
		admin.setManageAccount(name);
		try{
			this.adminDao.insert(admin);
		}catch (Exception e) {
			throw new Exception("添加管理员用户异常，数据库执行失败");
		}
		return admin;
	}
	
	@Override
	public Boolean findByName(String name) throws Exception {
		return adminDao.checkName(name);
	}

	@Override
	public List<AdminModel> getAll() throws Exception {
		Admin allocationAdmin = null;
		try{
			allocationAdmin = (Admin) WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		}catch (Exception e) {
			throw new Exception("noLogin");
		}
		
		List<Admin> list=adminDao.getAll();
		List<AdminModel> list1=new ArrayList<AdminModel>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		for (Admin admin : list) {
			if(admin.getId().equals(allocationAdmin.getId())){
				continue;
			}
			AdminModel a=new AdminModel();
			if( admin.getRank() < allocationAdmin.getRank() ){
				continue;
			}else if( admin.getRank().equals( allocationAdmin.getRank() ) ){
				a.setNoOption(true);
			}else{
				a.setNoOption(false);
			}
			a.setId(admin.getId());
			a.setName(admin.getName());
			a.setCreateTime( sdf.format(admin.getCreateTime()).replace('T', ' ') );
			a.setUpdTime( sdf.format(admin.getUpdateTime()).replace('T', ' ') );
			a.setRank(admin.getRank());
			a.setCreateName(admin.getAdminByCreateId().getName());
			a.setUpdName(admin.getAdminByUpdateId().getName());
			a.setDeldetes(admin.getDeleted().toString());
			list1.add(a);
		}
		return list1;
	}
	
	@Override
	public void delAdmin(Integer adminId) throws Exception {
		if(adminId==null)
			throw new Exception("删除管理员失败，当前参数为null");
		this.adminResourceDao.deleteByAdminId(adminId);
		Admin a = new Admin();
		a.setId(adminId);
		a.setDeleted(1);
		a.setAdminByUpdateId((Admin)WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY));
		this.updateAdmin(a);
	}

	@Override
	public Admin updateAdmin(Admin a) throws Exception {
		if( null == a || a.getId() == null ) throw new Exception("修改管理员信息失败，当前参数为null");
		try {
			Admin admin= (Admin) WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
			if(admin.getDeleted().equals("1"))return null;
			a.setUpdateTime(DateUtils.getNewDate());
			a.setAdminByUpdateId(admin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		adminDao.updateAdmin(a);
		Admin a1=adminDao.getById(a.getId());
		return a1;
	}
	
	@Override
	public AdminUpdateModel getById(Integer id) throws Exception {
		if( id == null )
			throw new Exception("通过编号查询管理员失败，参数为null");

		Admin a = this.adminDao.getById( id );
		AdminUpdateModel am = new AdminUpdateModel();
		am.setId(a.getId());
		am.setManageAccount(a.getManageAccount());
		am.setName(a.getName());
		am.setRank(a.getRank());
		return am;
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

	public AdminResourceDao getAdminResourceDao() {
		return adminResourceDao;
	}

	public void setAdminResourceDao(AdminResourceDao adminResourceDao) {
		this.adminResourceDao = adminResourceDao;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
}
