package cn.vote.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import cn.vote.dao.AdminResourceDao;
import cn.vote.dao.ResourceDao;
import cn.vote.entity.Admin;
import cn.vote.entity.AdminResource;
import cn.vote.entity.Resource;
import cn.vote.model.Constants;
import cn.vote.model.ResModel;
import cn.vote.model.ResourceModel;
import cn.vote.service.ResourceService;
import cn.vote.util.WebUtil;

/**
 * 权限部分的增删改查
 * 
 * @author 解金化
 * @date 2017.08.08
 * 
 */
public class ResourceServiceImpl implements ResourceService {

	private ResourceDao resourceDao;
	private AdminResourceDao adminResourceDao;

	@Override
	public void addRes(Resource res) throws Exception {
		if (null == res || null == res.getResName()
				|| null == res.getResAddress()) {
			throw new Exception("添加权限信息失败，权限信息不完整");
		}
		Admin allocationAdmin = null;
		try {
			allocationAdmin = (Admin) WebUtil
					.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		} catch (Exception e) {
			throw new Exception("noLogin");
		}
		Date date = new Date();
		res.setAdminByCreateId(allocationAdmin);
		res.setUpdateTime(date);
		res.setAdminByUpdateId(allocationAdmin);
		res.setCreateTime(date);
		res.setAdminByUpdateId(allocationAdmin);
		res.setUpdateTime(date);
		res.setResStatic(0);
		try {
			this.resourceDao.insert(res);
		} catch (Exception e) {
			throw new Exception("添加权限信息失败，执行数据库添加失败");
		}
	}

	@Override
	public void update(Resource res) throws Exception {

		if (null == res || null == res.getId()) {
			throw new Exception("修改权限信息失败，权限信息不完整");
		}
		Admin allocationAdmin = null;
		try {
			allocationAdmin = (Admin) WebUtil
					.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		} catch (Exception e) {
			throw new Exception("noLogin");
		}

		res.setAdminByUpdateId(allocationAdmin);
		res.setUpdateTime(new Date());

		try {
			this.resourceDao.update(res);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("修改权限信息失败，修改数据库失败");
		}
	}
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	@Override
	public ResModel getByid(Integer id) throws Exception {

		if (null == id) {
			throw new Exception("通过编号获取权限失败，编号为null");
		}

		Resource res = null;
		try {
			res = this.resourceDao.getById(id);
		} catch (Exception e) {
			throw new Exception(" 根据编号查询数据库中权限信息失败，数据库执行失败 ");
		}
		ResModel resm = new ResModel();
		resm.setCreateName(res.getAdminByCreateId().getName());
		resm.setCreateTime(sdf.format(res.getCreateTime()).replace('T', ' '));
		resm.setId(res.getId());
		resm.setName(res.getResName());
		resm.setResAddress(res.getResAddress());
		resm.setUpdateName(res.getAdminByUpdateId().getName());
		resm.setUpdateTime(sdf.format(res.getUpdateTime()).replace('T', ' '));
		resm.setResRank(res.getResGrade());
		try {
			resm.setParentId(res.getResourceByParent().getId());
		} catch (Exception e) {
			resm.setParentId(null);
		}
		if (res.getResGrade() != 1) {
			resm.setParentId(res.getResourceByParent().getId());
		}

		return resm;
	}

	@Override
	public List<ResModel> getAll() throws Exception {
		Admin allocationAdmin = null;
		try {
			allocationAdmin = (Admin) WebUtil
					.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		} catch (Exception e) {
			throw new Exception("noLogin");
		}
		List<Resource> list = new ArrayList<Resource>();
		try {
			List<AdminResource> l = this.adminResourceDao
					.selectByAdmin(allocationAdmin.getId());
			for (AdminResource a : l) {
				list.add(a.getResource());
			}
		} catch (Exception e) {
			throw new Exception("查询所有的权限信息失败");
		}
		List<ResModel> rs = new LinkedList<ResModel>();
		for (Resource r : list) {
			ResModel rm = new ResModel();
			rm.setCreateName(r.getAdminByCreateId().getName());
			rm.setCreateTime( sdf.format(r.getCreateTime() ).replace('T', ' '));
			rm.setId(r.getId());
			rm.setDeletes(r.getResStatic().toString());
			rm.setName(r.getResName());
			rm.setResAddress(r.getResAddress());
			rm.setUpdateName(r.getAdminByUpdateId().getName());
			rm.setUpdateTime(sdf.format(r.getUpdateTime()).replace('T', ' '));
			rm.setResRank(r.getResGrade());
			if (rm.getDeletes().equals("1")) {
				rm.setOptions("<button type='button' class='btn btn-default' data-toggle='modal'  onclick='updateClick();'>修改</button> "
						+ " <button type='button' class='btn btn-primary' data-toggle='modal'  onclick='aclick();'>删除</button>");
			} else if (allocationAdmin.getRank() == 1) {
				rm.setOptions("<button type='button' class='btn btn-default' data-toggle='modal' data-target='#update' onclick='updateClick("
						+ r.getId()
						+ ");'>修改</button> "
						+ " <button type='button' class='btn btn-primary' data-toggle='modal' data-target='#delete' onclick='aclick("
						+ r.getId() + ");'>删除</button>");
			} else {
				rm.setOptions("无权操作");
			}
			rs.add(rm);
		}
		return rs;
	}

	@Override
	public List<ResourceModel> ajaxGetAll(Integer resGrade) throws Exception {

		if (resGrade == null || resGrade < 2) {
			throw new Exception("获取父级权限失败，权限等级不是2级以上");
		}

		Admin allocationAdmin = null;
		try {
			allocationAdmin = (Admin) WebUtil
					.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		} catch (Exception e) {
			throw new Exception("noLogin");
		}
		List<Resource> list = new ArrayList<Resource>();
		try {
			List<AdminResource> l = this.adminResourceDao
					.selectByAdminAndGrade(allocationAdmin.getId(),
							(resGrade - 1));
			for (AdminResource a : l) {
				list.add(a.getResource());
			}
		} catch (Exception e) {
			throw new Exception("查询所有的权限信息失败");
		}// 获取当前用户的所有权限

		List<ResourceModel> rs = new LinkedList<ResourceModel>();
		for (Resource r : list) {
			ResourceModel rm = new ResourceModel();
			rm.setId(r.getId());
			rm.setName(r.getResName());
			rs.add(rm);
		}
		return rs;
	}

	/**
	 * 编辑用户时，获取1集权限
	 */
	@Override
	public List<ResourceModel> ajaxlevel1(Integer resGrade, Integer adminId)
			throws Exception {

		Admin allocationAdmin = null;
		try {
			allocationAdmin = (Admin) WebUtil
					.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		} catch (Exception e) {
			throw new Exception("noLogin");
		}
		// 获取当前用户的所有权限
		List<Resource> list = new ArrayList<Resource>();
		try {
			List<AdminResource> l = this.adminResourceDao
					.selectByAdminAndGrade(allocationAdmin.getId(), resGrade);
			for (AdminResource a : l) {
				list.add(a.getResource());
			}
		} catch (Exception e) {
			throw new Exception("查询所有的权限信息失败");
		}

		// 选中用户权限
		List<Resource> list1 = new ArrayList<Resource>();
		try {
			List<AdminResource> l2 = this.adminResourceDao
					.selectByAdminAndGrade(adminId, resGrade);
			for (AdminResource a : l2) {
				list1.add(a.getResource());
			}
		} catch (Exception e) {
			throw new Exception("查询所有的权限信息失败");
		}

		List<ResourceModel> rs = new LinkedList<ResourceModel>();

		if (list1.size() < 1) {
			for (Resource r : list) {
				ResourceModel rm = new ResourceModel();
				rm.setId(r.getId());
				rm.setName(r.getResName());
				rm.setAddress(r.getResAddress());
				rm.setStatu(3);
				rs.add(rm);
			}
		}

		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getId() == list1.get(i).getId()) { // 父级子级都有
					ResourceModel rm = new ResourceModel();
					rm.setId(list.get(j).getId());
					rm.setName(list.get(j).getResName());
					rm.setAddress(list.get(j).getResAddress());
					rm.setStatu(1);
					rs.add(rm);
					break;
				}
				if (j == list.size() - 1
						&& list.get(j).getId() != list1.get(i).getId()) { // 父级没有
																			// 子级有
					ResourceModel rm = new ResourceModel();
					rm.setId(list1.get(i).getId());
					rm.setName(list1.get(i).getResName());
					rm.setAddress(list1.get(i).getResAddress());
					rm.setStatu(1);
					rs.add(rm);
					continue;
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j).getId() == list.get(i).getId()) {
					break;
				}
				if (j == list1.size() - 1
						&& list1.get(j).getId() != list.get(i).getId()) { // 父级有
																			// 子级没有
					ResourceModel rm = new ResourceModel();
					rm.setId(list.get(i).getId());
					rm.setName(list.get(i).getResName());
					rm.setAddress(list.get(i).getResAddress());
					rm.setStatu(3);
					rs.add(rm);
					continue;
				}
			}
		}

		// for (Resource r : list) {
		// ResourceModel rm = new ResourceModel();
		// rm.setId(r.getId());
		// rm.setName(r.getResName());
		// rs.add(rm);
		// }
		return rs;
	}

	@Override
	public List<ResourceModel> getLevel2(Integer parent) throws Exception {
		if (parent == null)
			throw new Exception("参数为空");
		Admin allocationAdmin = null;
		try {
			allocationAdmin = (Admin) WebUtil
					.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		} catch (Exception e) {
			throw new Exception("noLogin");
		}
		List<Resource> list = new ArrayList<Resource>();
		try {
			List<AdminResource> l = this.adminResourceDao
					.selectByAdminAndParent(allocationAdmin.getId(), parent);
			for (AdminResource a : l) {
				list.add(a.getResource());
			}
			List<ResourceModel> rs = new LinkedList<ResourceModel>();
			for (Resource r : list) {
				ResourceModel rm = new ResourceModel();
				rm.setId(r.getId());
				rm.setName(r.getResName());
				rm.setAddress(r.getResAddress());
				rs.add(rm);
			}
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询所有的权限信息失败");
		}
	}

	/**
	 * 编辑用户时，获取子集权限
	 */
	@Override
	public List<ResourceModel> getLevel(Integer parent, Integer resGrade,
			Integer adminId) throws Exception {
		if (parent == null)
			throw new Exception("参数为空");
		Admin allocationAdmin = null;
		try {
			allocationAdmin = (Admin) WebUtil
					.getSessionAttribute(Constants.SESSION_LONG_ADMIN_KEY);
		} catch (Exception e) {
			throw new Exception("noLogin");
		}
		List<Resource> list = new ArrayList<Resource>();
		try {
			List<AdminResource> l = this.adminResourceDao
					.selectByAdminAndGradeAndParent(allocationAdmin.getId(),
							resGrade, parent);
			for (AdminResource a : l) {
				list.add(a.getResource());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询所有的权限信息失败");
		}// 获取当前用户的所有权限

		List<Resource> list1 = new ArrayList<Resource>();
		try {
			List<AdminResource> l = this.adminResourceDao
					.selectByAdminAndGradeAndParent(adminId, resGrade, parent);
			for (AdminResource a : l) {
				list1.add(a.getResource());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询所有的权限信息失败");
		}

		List<ResourceModel> rs = new LinkedList<ResourceModel>();
		if (list1.size() < 1) {
			for (Resource r : list) {
				ResourceModel rm = new ResourceModel();
				rm.setId(r.getId());
				rm.setGreadeId(resGrade + 1);
				rm.setName(r.getResName());
				rm.setAddress(r.getResAddress());
				rm.setStatu(3);
				rs.add(rm);
			}
		}

		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getId() == list1.get(i).getId()) { // 父级子级都有
					ResourceModel rm = new ResourceModel();
					rm.setId(list.get(j).getId());
					rm.setGreadeId(resGrade + 1);
					rm.setName(list.get(j).getResName());
					rm.setAddress(list.get(j).getResAddress());
					rm.setStatu(1);
					rs.add(rm);
					break;
				}
				if (j == list.size() - 1
						&& list.get(j).getId() != list1.get(i).getId()) { // 父级没有
																			// 子级有
					ResourceModel rm = new ResourceModel();
					rm.setId(list1.get(i).getId());
					rm.setName(list1.get(i).getResName());
					rm.setGreadeId(resGrade + 1);
					rm.setAddress(list1.get(i).getResAddress());
					rm.setStatu(1);
					rs.add(rm);
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j).getId() == list.get(i).getId()) {
					break;
				}
				if (j == list1.size() - 1
						&& list1.get(j).getId() != list.get(i).getId()) { // 父级有
																			// 子级没有
					ResourceModel rm = new ResourceModel();
					rm.setId(list.get(i).getId());
					rm.setGreadeId(resGrade + 1);
					rm.setName(list.get(i).getResName());
					rm.setAddress(list.get(i).getResAddress());
					rm.setStatu(3);
					rs.add(rm);
				}
			}
		}

		// for (Resource r : list) {
		// ResourceModel rm = new ResourceModel();
		// rm.setId(r.getId());
		// rm.setName(r.getResName());
		// rm.setAddress(r.getResAddress());
		// rs.add(rm);
		// }
		return rs;
	}

	@Override
	public void delete(Integer id) throws Exception {

		if (id == null) {
			throw new Exception("删除权限失败，提供的删除编号为空");
		}
		List<AdminResource> list = this.adminResourceDao.getByResId(id);
		for (AdminResource a : list) {
			this.adminResourceDao.delete(a.getId()); // 获取到外键关联表中数据并执行删除
		}
		Resource r = new Resource();
		r.setId(id);
		r.setResStatic(1);

		this.update(r); // 权限信息不能删除，将状态修改为不可用状态
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

}
