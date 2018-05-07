package com.accp.bizimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accp.bizdao.DrugBiz;
import com.accp.bizdao.DrugTimeBiz;
import com.accp.bizdao.FixedPrescriptionBiz;
import com.accp.bizdao.PrescriptionBiz;
import com.accp.dao.DrugDao;
import com.accp.dao.DrugTimeDao;
import com.accp.demo.DoctorOffer;
import com.accp.demo.Drug;
import com.accp.demo.DrugTime;
import com.accp.demo.FixedPrescription;
import com.accp.demo.Prescription;
import com.accp.impl.DrugImpl;
import com.accp.impl.DrugTimeImpl;
import com.accp.util.Page;

public class DrugBizImpl implements DrugBiz {
	
	private Logger logger = Logger.getLogger(DrugBiz.class);
	private DrugDao drugdao = new DrugImpl();
	private DrugTimeDao drugTimeDao = new DrugTimeImpl();

	@Override
	public Drug addDrug(Drug d) throws Exception {
		
		if( null == d ){
			logger.debug("再添加药品信息的时候出现错误，参数是null的");
			throw new Exception("drug add() parameter is null");
		}
		
		Object id = drugdao.add(d);
		
		Drug drug = getDrugById((Integer)id);
		
		return drug;
	}

	@Override
	public Drug updateDrug(Drug d) throws Exception {
		
		if( null == d || null == d.getDrugId() ){
			logger.debug("修改药品信息失败，药品主键或者药品是null的");
			throw new Exception("deug update() parameter is null");
		}
		
		boolean bool = drugdao.update(d);
		
		if(bool){
			Drug drug = getDrugById(d.getDrugId());
			return drug;
		}
		else
			return null;
	}

	@Override
	public Boolean delDrug(List<Integer> drugId) throws Exception {
		/*
		 * 删除药品表 
		 * 1、删除过期时间
		 * 2、删除固定处方
		 * 3、删除处方
		 * 4、删除药品
		 */
		
		if( null == drugId || drugId.size() <= 0 ){
			logger.debug("删除药品的时候出错，参数为null");
			throw new Exception("deug del() param is null");
		}
		
		for (Integer drigid : drugId) {
			
			Drug drug = getDrugById(drigid); // 药品实体
			
			DrugTimeBiz dtb = new DrugTimeBizImpl(); // 获取过期时间的处理对象
			List<DrugTime> list = dtb.getByDrug(drug);
			List<Integer> idlist = new ArrayList<>();
			for (DrugTime d : list) {
				idlist.add(d.getDrugTimeId());
			}
			if(!dtb.del(idlist)){
				logger.debug("删除药品前删除过期时间出错，不能正确删除");
				throw new Exception("deug del() before delDrugTime() execute error");
			}
			
			FixedPrescriptionBiz fb = new FixedPrescriptionBizImpl(); // 固定处方的处理对象
			List<FixedPrescription> fixlist = fb.getByDrug(drug);
			List<Integer> fixids = new ArrayList<>();
			for (FixedPrescription f : fixlist) {
				fixids.add(f.getFpid());
			}
			if(!fb.del(fixids)){
				logger.debug("删除药品前删除固定处方出错，不能正确删除");
				throw new Exception("deug del() before delFixedPrescription() execute error");
			}
			
			PrescriptionBiz pb = new PrescriptionBizImpl(); // 处方表的处理对象
			List<Prescription> prelist = pb.getByDrug(drug); // 根据药品查询处方
			List<Integer> preids = new ArrayList<>();
			for (Prescription p : prelist) {
				preids.add(p.getPreId());
			}
			if(!pb.del(preids)){
				logger.debug("删除药品前删除处方出错，不能正确删除");
				throw new Exception("deug del() before delPrescription() execute error");
			}
			
			if(!drugdao.del(drigid.toString())){
				logger.debug("删除药品出错，不能正确删除");
				throw new Exception("deug del() before deldrug() execute error");
			}
		}
		
		return true;
	}

	@Override
	public Drug getDrugById(Integer id) throws Exception {
		if( null == id || id <= 0 ){
			logger.debug("根据编号获取药品出错，参数不正确");
			throw new Exception("deug getById() prameter is null");
		}
		Drug d = new Drug();
		d.setDrugId(id);
		List<Drug> list = getAll(d);
		if(list == null || list.size() == 0)return null;
		return list.get(0);
	}

	@Override
	public void getPage(Page<Drug> page, Drug drug) throws Exception {
		
		if(page.getItems() <= 0 || page.getPagesize() <= 0){
			logger.debug("分页查询药品出错");
			throw new Exception("deug getPage() execute is error");
		}
		
		drugdao.getPage(page,drug);
		
	}

	@Override
	public List<Drug> getAll(Drug d) throws Exception {
		
		List<Drug> list = drugdao.getByColumn(d);
		for (Drug drug : list) {
			int num = drugTimeDao.getDrugNum(drug);
			drug.setNumber(num);
		}
		if( null == list )		
			return null;
		else 
			return list;
	}

	@Override
	public Map<String, List<Drug>> getBySys(Integer doid) throws Exception {
		
		if( null == doid ){
			logger.debug("查询处方信息出错");
			throw new Exception("Drug getBySys() parameter is null");
		}
		DoctorOffer docoff = new DoctorOfferBizImpl().getById(doid);
		if( null == docoff ){
			logger.debug("没有查询到就诊信息");
			throw new Exception("Drug getBySys() getDocOff execute error");
		}
		String string = docoff.getSymptom();
		if( null == string ){
			logger.debug("当前的就诊没有症状");
			throw new Exception("Drug getBySys() getDocOff No symptoms");
		}
		String[] sys = string.split("，");
		/**
		 * 根据当前给定的病症信息给出处理的药品<br/>
		 * 
		 * 模糊查询，并且要根据症状返回需要的集合
		 */
		Map<String, List<Drug>> map = new HashMap<>();
		if( null == sys || sys.length == 0 ){ // 如果给定的参数为null，name就是查询所有药品
			List<Drug> list = getAll(new Drug());
			List<Drug> renList = new LinkedList<>();
			if( null == list || list.size() == 0 ){
				logger.debug("获取全部信息失败");
				throw new Exception("getAll error");
			}
			for (Drug d : list) {
				Drug drug = new Drug();
				drug.setDrugId(d.getDrugId());
				drug.setDrugName(d.getDrugName());
				drug.setDrugAlias(d.getDrugAlias());
				renList.add(drug);
			}
			map.put("all", renList);
			
		}else{ // 如果给定的参数不是null的,就进行模糊查询
			
			List<Drug> list = null;
			List<Drug> renList = null;
			Drug d1 = new Drug();
			for (String s : sys) {
				
				d1.setDrugSymptom(s);
				
				list = getAll(d1);
				renList = new LinkedList<>();
				
				if( null != list && list.size() > 0 ){ // 如果没有查到结果				
					for (Drug d : list) {
						Drug drug = new Drug();
						drug.setDrugId(d.getDrugId());
						drug.setDrugName(d.getDrugName());
						drug.setDrugAlias(d.getDrugAlias());
						drug.setNumber(d.getNumber());
						renList.add(drug);
					}
					map.put(s, renList);
				}
			}
			
		}
		return map;
	}

}
