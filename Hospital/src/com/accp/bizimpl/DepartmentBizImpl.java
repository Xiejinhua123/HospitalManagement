package com.accp.bizimpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.accp.bizdao.DepartmenBiz;
import com.accp.bizdao.UserBiz;
import com.accp.dao.DepartmentDao;
import com.accp.demo.Common;
import com.accp.demo.Department;
import com.accp.demo.Users;
import com.accp.impl.DepartmentImpl;
import com.accp.util.Page;

public class DepartmentBizImpl implements DepartmenBiz {
	private  Logger logger = Logger.getLogger(DepartmentBizImpl.class);
	private DepartmentDao depdao = new DepartmentImpl();

	@Override
	public Department add(Department department) throws Exception {
		
		if( null == department ){
			logger.debug("添加用户的时候出错，参数异常");
			throw new Exception("department add() parameter is null");
		}
		
		Object pri = depdao.add(department);
		if( null == pri ){
			logger.debug("添加失败");
			throw new Exception("department add() execute error");
		}
		
		Department d = getById((Integer)pri);
		
		return d;
	}

	@Override
	public Boolean del(List<Integer> list) throws Exception {
		
		/*
		 * 删除科室需要删除所有的外键表
		 */
		
		if( null == list || list.size() == 0 ){
			logger.debug("添加失败，参数异常");
			throw new Exception("department del() parameter is null");
		}
		int boo = list.size();
		int j = 0;
		for (int i = 0; i < list.size(); i++) {
			
			Integer id = list.get(i);
			
			Department dep = getById(id);
			
			if( null == dep ){
				
				logger.debug("数据库中不存在当前的科室，不能删除");
				throw new Exception("department del() execute not find");
			}
			UserBiz ub = new UserBizImpl();
			List<Users> userlist = ub.getByDep(dep,new Users());
			List<String> userIds = new ArrayList<>();
			for (Users users : userlist) {
				userIds.add(users.getUsersId());
			}
			Boolean b = ub.del(userIds);
			
			
			if( b && depdao.del(dep.getDepId().toString())){
				j++;
			}
		}
		
		if( j == boo ){
			return true;
		}else{
			logger.debug("删除中给定数量为：" + boo +",\t实际删除数量为：" + j + "还有：" + (boo - j) + "个没有删除");
			throw new Exception("There are " + (boo - j) + " objects that are not deleted successfully");
		}
	}

	@Override
	public Department update(Department department) throws Exception {
		
		if( null == department ){
			logger.debug("科室修改，参数为null");
			throw new Exception("department update() parameter is null");
		}
		
		Boolean bool = depdao.update(department);
		
		if(bool){
			
			Department de = getById(department.getDepId());
			return de;
			
		}else{
			
			logger.debug("修改科室信息失败");
			throw new Exception("department update() execute be defeated");
		}
		
	}

	@Override
	public void getPage(Page<Department> page, Department department) throws Exception {
		
		if( null == page || page.getItems() == 0 || page.getPagesize() <= 0 ){
			
			logger.debug("科室表的分页出错，参数异常");
			throw new Exception("department getPage() parameter is error");
		}
		
		depdao.getPage(page,department);
		
	}

	@Override
	public List<Department> getByColomn(Department d) throws Exception {
		return depdao.getByColumn(d);
	}

	@Override
	public Department getById(Integer depId) throws Exception {
		
		Department dep = new Department();
		dep.setDepId(depId);
		
		List<Department> list = getByColomn(dep);
		
		if(list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public List<Department> getAll(Department d) throws Exception {
		List<Department> list = getByColomn(d);
		List<Department> jsonList = new LinkedList<Department>();
		
		Department dep = new Department();
		for (Department department : list) {
			dep = new Department();
			dep.setDepAddress(department.getDepAddress());
			dep.setDepId(department.getDepId());
			while(true){
				try{
					dep.setDepName(Common.DICTIONA_MAP.get(department.getDepName()).getTypeValus());
					break;
				}catch(Exception e){
					wait(100);
					continue;
				}
			}
			jsonList.add(dep);
		}
		return jsonList;
	}

}
