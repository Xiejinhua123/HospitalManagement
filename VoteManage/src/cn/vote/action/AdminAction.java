package cn.vote.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.sun.org.apache.xpath.internal.operations.Bool;

import cn.vote.entity.Admin;
import cn.vote.model.AdminModel;
import cn.vote.model.AdminUpdateModel;
import cn.vote.model.Constants;
import cn.vote.service.AdminService;
import cn.vote.util.MD5;
import cn.vote.util.WebUtil;

/**
 * 负责管理员的接口
 * 
 * @author 解金化
 *
 *@date 2017.07.18
 */
public class AdminAction extends ActionBase {

	private static final long serialVersionUID = 812423346259696518L;
	private String name;
	private String pwd;
	private AdminService adminService;
	private Admin admin;
	private String manage;
	private Boolean flush;
	private String newPwd;
	/**
	 * 验证姓名是否存在
	 * 如果存在，返回json:true,如果不存在，返回json:false
	 */
	public void checkedName(){
		try{
			if( this.adminService.findByName(name) )
				super.setJson("true");
			else
				super.setJson("false");
		}catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	/**
	 * 执行登录接口
	 */
	public void dologin(){
		try{
			this.adminService.doLogin(name, pwd);
			super.setJson("success");
		}catch (Exception e) {
			super.setJson(e.getMessage());
		}finally{
			super.witerJson();
		}
	}
	
	/**
	 * 注销
	 * @return 成功返回success 失败返回fail
	 */
	public String adminlogout()
	{
		try{
			ServletActionContext.getRequest().getSession().invalidate();
			Object o=WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
			System.out.println(11);
		}catch (Exception e) {
			return "fail";
		}
		return "success";
	}
	
	public void getAllAdmin()
	{
		try{
			List<AdminModel> list=this.adminService.getAll();
			super.setJson(list);
		}catch (Exception e) {
			super.setJson(e.getMessage());
		}finally{
			super.witerJson();
		}
	}
	
	
	
	//删除管理员 
	public String delAdmin(){
		try {
			this.adminService.delAdmin(admin.getId());
			this.manage = "删除成功";
			this.flush = false;
		} catch (Exception e) {
			if( admin == null )
				this.flush = true;
			this.manage = "删除失败";
		}
		return SUCCESS;
	}
	
	//修改管理员信息
	public String updAdmin(){
		try{
			this.adminService.updateAdmin(admin);
			this.manage = "修改成功";
			this.flush = false;
		}catch (Exception e) {
			e.printStackTrace();
			if( admin == null )
				this.flush = true;
			this.manage = "修改失败";
		}
		return SUCCESS;
	}
	
	//添加
	public String addAdmin(){
		try{
			this.adminService.addAdmin( admin.getName() );
			this.manage = "添加成功";
			this.flush = false;
		}catch (Exception e) {
			if( admin == null )
				this.flush = true;
			this.manage = "添加失败";
		}
		return SUCCESS;
	}
	
	/**
	 * 根据用户编号查询用户
	 */
	public void getAdminById(){
		try{
			AdminUpdateModel a = this.adminService.getById( this.admin.getId() );
			super.setJson(a);
		}catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	public void getAdminMsg()
	{
		Object o=WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		Admin a=new Admin();
		admin=(Admin)o;
		a.setId(admin.getId());
		a.setManageAccount(admin.getManageAccount());
		a.setManagePassword(admin.getManagePassword());
		a.setName(admin.getName());
		super.setJson(a);
		super.witerJson();
	}
	public void updateAdminMes()
	{
		try {
			admin=adminService.updateAdmin(admin);
			WebUtil.setSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY, admin);
			Admin a=new Admin();
			a.setId(admin.getId());
			a.setManageAccount(admin.getManageAccount());
			a.setName(admin.getName());
			super.setJson(a);
		}catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
		
	}
	public void updatePassword()
	{
		Object o=WebUtil.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		admin=(Admin)o;
		String md5Pwd=new MD5(pwd).compute();
		try {
			if(admin.getManagePassword().equals(md5Pwd))
			{
				Admin a=new Admin();
				a.setManagePassword(new MD5(newPwd).compute());
				a.setId(admin.getId());
				admin=adminService.updateAdmin(a);
				WebUtil.setSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY,null);
				super.setJson("success");
			}else{
				super.setJson("pwdwrong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.witerJson();
		}
	}
	
	
	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String getManage() {
		return manage;
	}

	public void setManage(String manage) {
		this.manage = manage;
	}

	public Boolean getFlush() {
		return flush;
	}

	public void setFlush(Boolean flush) {
		this.flush = flush;
	}
}
