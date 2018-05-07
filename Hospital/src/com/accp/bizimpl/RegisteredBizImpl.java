package com.accp.bizimpl;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.accp.bizdao.DoctorOfferBiz;
import com.accp.bizdao.PatientBiz;
import com.accp.bizdao.RegisteredBiz;
import com.accp.bizdao.UserBiz;
import com.accp.dao.RegisteredDao;
import com.accp.demo.Common;
import com.accp.demo.DoctorOffer;
import com.accp.demo.Patient;
import com.accp.demo.Registered;
import com.accp.demo.Users;
import com.accp.impl.RegisteredImpl;
import com.accp.json.RegJson;
import com.accp.json.RegisteredJson;
import com.accp.util.Generate;
import com.accp.util.Page;

/**
 *	挂号业务处理
 *
 * @author 解金化
 *
 */
public class RegisteredBizImpl implements RegisteredBiz {
	private Logger logger = Logger.getLogger(RegisteredBizImpl.class);
	private RegisteredDao registeredDao = new RegisteredImpl();
	private UserBiz userbiz = new UserBizImpl();
	private PatientBiz patientBiz = new PatientBizImpl();

	@Override
	public RegisteredJson add(String uid, Integer patid) throws Exception {
		if( null == uid || null == patid ){
			logger.debug("执行挂号，参数为null");
			throw new Exception("parameter is null");
		}

		Users users = userbiz.getById(uid);
		Patient patient = patientBiz.getById(patid);
		Registered registered = new Registered();
	
		while(true){
			String id = Generate.getId(patid.toString());
			Registered r = getById(id);
			if( null == r ){
				registered.setRegId(id);
				break;
			}
			else continue;
		}
		registered.setRegType(users.getIsSpecialist());
		registered.setUsers(users);
		registered.setPatient(patient);
		registered.setDepId(users.getDepartment().getDepId());
		registered.setIsPay(0); // 是否付款
		registered.setPayState(0); // 就诊是否付款		
		registered.setRegPrice(5.0);
		registered.setRegState("501"); // 没有处理状态
		registered.setRegTime(Generate.getDateTime()); // 获取挂号时间
		Object id = registeredDao.add(registered);

		if( null == id ){
			logger.debug("挂号失败");
			throw new Exception("exceute error");
		}
		String docName = users.getTrueName();
		String regId = (String)id;

		String depName = null;
		while(true){
			try{
				depName = Common.DICTIONA_MAP.get(users.getDepartment().getDepName()).getTypeValus();
				break;
			}catch(Exception e){
				continue;
			}
		}
		String depAddress = users.getDepartment().getDepAddress();
		RegisteredJson rs = new RegisteredJson(docName, depName, depAddress, regId);
		return rs;
	}

	@Override
	public Registered appointment(Registered r) {
		return null;
	}

	@Override
	public Boolean del(List<String> ids) throws Exception {
		/**
		 * 删除挂号信息
		 * 
		 * 首先应该删除对应的就诊信息
		 */
		
		if( null == ids || ids.size() <= 0 ){
			logger.debug("删除挂号信息失败，参数为null");
			throw new Exception("Registered del() parameter is null");
		}
		DoctorOfferBiz dob = new DoctorOfferBizImpl();
		for (String id : ids) {
			
			List<DoctorOffer> doclist = dob.getByRegistered(getById(id)); // 获取就诊集合
			if( null != doclist && doclist.size() != 0 ){
				List<Integer> list = new LinkedList<>();
				for (DoctorOffer d : doclist) {
					list.add(d.getDoid());
				}
				if( !dob.del(list) ){
					logger.debug("删除挂号信息的时候，事先删除就诊信息失败");
					throw new Exception("Registered del() error");
				}
			}
			
			if( !registeredDao.del(id) ){ // 执行删除挂号信息
				
				logger.debug("删除挂号信息失败");
				throw new Exception("Registered del() execute is error");
			}
			
		}
		
		return true;
	}

	@Override
	public Registered update(Registered r) throws Exception {
		

		if( null == r || null == r.getRegId() ){

			logger.debug("修改挂号信息失败，参数为null");
			throw new Exception("registered update() parameter is null");
		}
		
		if( registeredDao.update(r) )return getById(r.getRegId());
		else return null;
	}


	@Override
	public Registered getById(String id) throws Exception {
		if( null == id ){

			logger.debug("通过编号查询挂号信息失败，参数为null");
			throw new Exception("registered getById() parameter is null");
		}
		Registered r = new Registered();
		r.setRegId(id);
		List<Registered> list = getByColumn(r);
		if( null == list || list.size() == 0 )return null;
		else return list.get(0);
	}

	@Override
	public void getPage(Page<Registered> page, Registered r) throws Exception {
		
		if( null == page || null == page.getItems() || null == page.getPagesize()
				|| page.getItems() <= 0 || page.getPagesize() <= 0 ){
			logger.debug("分页查询挂号信息出错，分页对象出错");
			throw new Exception("Registered getPage() parameter is error");
		}
		
		registeredDao.getPage(page,r);
		
	}

	@Override
	public List<Registered> getByColumn(Registered r) throws Exception {
		return registeredDao.getByColumn(r);
	}

	@Override
	public List<RegJson> getByDoctorNoDispose(String usersId) throws Exception {
		
		if( null == usersId || usersId.length() != 12 ){
			logger.debug("根据医生编号查询没有处理的挂号信息挂号信息");
			throw new Exception("registered getByDoctorNoDispose parameter is null");
		}
		
		Registered reg = new Registered();
		reg.setUsers(userbiz.getById(usersId));
		reg.setRegState("501");
		Page<Registered> page = new Page<>();
		page.setItems(20);
		page.setPagesize(1);
		registeredDao.getPage(page, reg);
		List<Registered> list = page.getList();

		if( null != list && list.size() >= 0 ){
			
			List<RegJson> jsonlist = new LinkedList<>();
			
			for (Registered r : list) {
				jsonlist.add( 
						new RegJson(
								r.getRegId(), // 挂号编号
								r.getPatient().getPatId(), // 患者编号
								r.getPatient().getPatName() // 患者姓名
								)
						);
			}
			
			return jsonlist;
			
		}else return null;
	}

}
