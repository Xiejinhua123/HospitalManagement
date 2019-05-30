package cn.vote.action;

import java.util.ArrayList;
import java.util.List;

import cn.vote.service.AdminResourceService;

@SuppressWarnings("serial")
public class AdminResourceAction extends ActionBase {

	private AdminResourceService adminResourceService;
	private String mycars;
	private Integer adminId;
	//修改权限
	public void addresous()
	{
		try {
			String [] s=	mycars.split(",");
			List<Integer> list=new ArrayList<Integer>();
			for (String s1 : s) {
				list.add(Integer.parseInt(s1));
			}
			adminResourceService.addAdRe(adminId, list);
			System.out.println("!111");
			super.setJson("success");
		} catch (Exception e) {
			e.printStackTrace();
			super.setJson("error");
		}finally{
			super.witerJson();
		}
		
	}
	public AdminResourceService getAdminResourceService() {
		return adminResourceService;
	}
	public void setAdminResourceService(AdminResourceService adminResourceService) {
		this.adminResourceService = adminResourceService;
	}
	public String getMycars() {
		return mycars;
	}
	public void setMycars(String mycars) {
		this.mycars = mycars;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	
}
