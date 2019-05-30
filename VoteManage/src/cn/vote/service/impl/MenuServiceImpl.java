package cn.vote.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.vote.dao.AdminResourceDao;
import cn.vote.dao.ResourceDao;
import cn.vote.entity.Admin;
import cn.vote.entity.AdminResource;
import cn.vote.entity.Resource;
import cn.vote.model.Constants;
import cn.vote.model.MenuModel;
import cn.vote.service.MenuService;
import cn.vote.util.WebUtil;

public class MenuServiceImpl implements MenuService {

	private AdminResourceDao adminResourceDao;

	private ResourceDao resourceDao;

	private StringBuffer sb = new StringBuffer();
	private StringBuffer sbc = new StringBuffer();

	@Override
	public List<MenuModel> getMenu() throws Exception {

		Admin admin = null;
		try {
			admin = (Admin) WebUtil
					.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		} catch (Exception e) {
			throw new Exception("noLogin");
		}

		// 获取到的是当前登录的用户的所有权限信息
		List<AdminResource> list = this.adminResourceDao.selectByAdmin(admin
				.getId());

		// 获取到权限模型
		List<MenuModel> mms = new LinkedList<MenuModel>();
		for (AdminResource ar : list) {
			if(ar.getResource().getResStatic()==1)continue;
			Resource r = ar.getResource();
			MenuModel mm = new MenuModel();
			mm.setAddress(r.getResAddress());
			mm.setGrade(r.getResGrade());
			mm.setId(r.getId());
			mm.setName(r.getResName());
			try {
				mm.setParId(r.getResourceByParent().getId());
			} catch (Exception e) {
				mm.setParId(null);
			}
			mm.setResIco(r.getResIco());
			mms.add(mm);
		}
		return mms;
	}

	/**
	 * 将当前对象装换为一段html代码
	 * 
	 * @return html代码
	 */
	@Override
	public String toHtml(List<MenuModel> list) throws Exception {
		this.sb = new StringBuffer();
		List<MenuModel> noOne = new ArrayList<MenuModel>();
		noOne.addAll(list);
		for (MenuModel m : list) {
			if (m.getGrade() == 1) {
				noOne.remove(m);
			}
		}
		for (MenuModel m : list) {
			/**
			 * 在这里只循环一级菜单
			 * 
			 * 剩下的二级包括三级等菜单信息，将通过ajax 异步调用执行
			 * 
			 */
			if (m.getGrade() == 1) {
				if (m.getAddress() != null)
					this.sb.append("<li><a href='" + m.getAddress() + "?resId="
							+ m.getId() + "'><i class='fa " + m.getResIco()
							+ " fa-fw'></i> " + m.getName() + "</a>");
				else
					// sb.append("<li><a href='javascript:void(0)' onmousemove='getGridMenu("
					// + m.getId() + " , this)'><i class='fa " + m.getResIco() +
					// " fa-fw'></i>" + m.getName() +
					// "<span class='fa arrow'></span></a></li>");
					sb.append("<li><a href='javascript:void(0)'><i class='fa "
							+ m.getResIco() + " fa-fw'> </i> " + m.getName()
							+ "<span class='fa arrow'></span></a>");
				this.getChildrenHTML(noOne, m.getId());
				this.sb.append("</li>");
			}
		}
		return sb.toString();
	}

	/**
	 * 递归算法
	 * 
	 * 用来组建菜单
	 * 
	 * 该方法将不涵盖以及菜单，如果是一级菜单的话，需要从集合中单独拿出来进行循环
	 * 
	 * 循环一级菜单，循环期间调用该递归方法
	 * 
	 * @param list
	 *            需要的数据库中查询出来的所有集合
	 * 
	 * @param parentId
	 *            父级编号
	 */
	private void getChildrenHTML(List<MenuModel> list, int parentId) {
		this.sbc.append("<ul class='nav nav-second-level'>");
		for (MenuModel m : list) {
			if (m.getParId() == parentId) {
				this.sbc.append("<li><a href='" + m.getAddress() + "?resId="
						+ m.getId() + "'><i class='fa "+ m.getResIco() +" fa-fw'> </i> " + m.getName() + "</a>");
				getChildrenHTML(list, m.getId());
				this.sbc.append("</li>");
			}
		}
		this.sbc.append("</ul>");

		if (this.sbc.toString().indexOf(
				"<ul class='nav nav-second-level'></ul>") > -1) {
			String a = this.sbc.toString().replaceAll(
					"<ul class='nav nav-second-level'></ul>", "");
			this.sbc = new StringBuffer(a);
		}

		this.sb.append(this.sbc);
		this.sbc = new StringBuffer();
	}

	@Override
	public void toSessionList(List<MenuModel> list) throws Exception {
		String menu = this.toHtml(list);
		Integer[] menuId = new Integer[list.size()];
		for (int i = 0; i < list.size(); i++) {
			menuId[i] = list.get(i).getId();
		}
		// 登录用户菜单
		WebUtil.setSessionAttribute(Constants.SESSION_LOGIN_MENUHTML, menu);
		// 登录用户权限编号
		WebUtil.setSessionAttribute(Constants.SESSION_LOGIN_MENUID, menuId);
	}

	public AdminResourceDao getAdminResourceDao() {
		return adminResourceDao;
	}

	public void setAdminResourceDao(AdminResourceDao adminResourceDao) {
		this.adminResourceDao = adminResourceDao;
	}

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
}
