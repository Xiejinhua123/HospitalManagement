package com.accp.bizimpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.accp.bizdao.PrescriptionBiz;

import com.accp.bizdao.DoctorOfferBiz;
import com.accp.dao.DoctorOfferDao;
import com.accp.demo.DoctorOffer;
import com.accp.demo.Drug;
import com.accp.demo.Prescription;
import com.accp.demo.Registered;
import com.accp.demo.Users;
import com.accp.impl.DoctorOfferImpl;
import com.accp.util.Page;

public class DoctorOfferBizImpl implements DoctorOfferBiz {
	
	private Logger logger = Logger.getLogger(DoctorOfferBiz.class);
	private DoctorOfferDao docoffdao = new DoctorOfferImpl();

	@Override
	public ArrayList<Prescription> add(String regId,Users u,String symptom,String[] drugs) throws Exception {
		
		if( null == regId || null == u || null == symptom || null == drugs ){
			logger.error("doctoroffer add() parameter is null");
			throw new Exception("parameter null");
		}
		
		Registered reg = new RegisteredBizImpl().getById(regId);
		DoctorOffer docoff = new DoctorOffer();
		docoff.setUsers(u);
		docoff.setRegistered(reg);
		docoff.setSymptom(symptom);
		
		DoctorOffer d = (DoctorOffer) docoffdao.add(docoff);
		List<Prescription> pres = new LinkedList<>();
		for (String string : drugs) {
			Drug drug = new Drug();
			drug.setDrugName(string);
			List<Drug> list = new DrugBizImpl().getAll(drug);
			if( null == list || list.size() <= 0 ){
				continue;
			}
			Prescription p = new Prescription();
			p.setDoctorOffer(d);
			p.setDrug(list.get(0));
			pres.add( new PrescriptionBizImpl().add(p) );
		}
		ArrayList<Prescription> apres = new ArrayList<>();
		for (Prescription p : pres) {
			Prescription pre = new Prescription();
			pre = p;
			pre.setDrugNum(0);
			pre.setDrugUnit(null);
			apres.add(pre);
		}
		return apres;
	}

	@Override
	public Boolean del(List<Integer> list) throws Exception {
		if(null == list || list.size() == 0){
			logger.debug("删除就诊信息的时候出错，参数是null的");
			throw new Exception("doctoroff del() parameter is null");
		}
		int count = list.size();
		int j = 0;
		for (Integer id : list) {
			
			DoctorOffer docoff = getById(id);
			
			PrescriptionBiz pb = new PrescriptionBizImpl();
			
			List<Prescription> pres = pb.getByDocoff(docoff); // 获取当前的就诊信息下的处方
			List<Integer> preids = new ArrayList<>();
			for (Prescription p : pres) {
				preids.add(p.getPreId());
			}
			Boolean bool = pb.del(preids);
			if(bool){
				
				boolean b = docoffdao.del(id.toString());
				if(b)j++;
				
			}else{
				logger.debug("删除就诊信息对应的处方信息的时候执行出错");
			}
		}
		if(j == count)return true;
		else return false;
	}

	@Override
	public void getPage(Page<DoctorOffer> page, DoctorOffer docoff) throws Exception {
		
		if(page.getItems() <= 0 || page.getPagesize() <= 0){
			logger.debug("分页查询就诊信息出错，分页对象不正确");
			throw new Exception("doctoroffer getPage() parameter is null");
		}
		
		docoffdao.getPage(page,docoff);
		
	}

	@Override
	public DoctorOffer getById(Integer id) throws Exception {
		if( null == id ){
			logger.debug("编号查询就诊，参数为null");
			throw new Exception("doctoroffer getById() parameter is null");
		}
		DoctorOffer d = new DoctorOffer();
		d.setDoid(id);
		List<DoctorOffer> list = getByColumn(d);
		if(null == list || list.size() == 0)
			return null;
		else
			return list.get(0);
	}
	
	@Override
	public List<DoctorOffer> getByColumn(DoctorOffer docoff) throws Exception {
		
		List<DoctorOffer> list = docoffdao.getByColumn(docoff);
		
		if( null == list || list.size() == 0 )
			return null;
		else 
			return list;
	}

	@Override
	public List<DoctorOffer> getByRegistered(Registered byId) throws Exception {

		if( null == byId ){
			
		}
		
		return null;
	}

}
