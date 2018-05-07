package com.accp.bizimpl;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.accp.bizdao.DoctorOfferBiz;
import com.accp.bizdao.PrescriptionBiz;
import com.accp.bizdao.RegisteredBiz;
import com.accp.dao.PrescriptionDao;
import com.accp.demo.DoctorOffer;
import com.accp.demo.Drug;
import com.accp.demo.Prescription;
import com.accp.demo.Registered;
import com.accp.impl.PrescriptionImpl;
import com.accp.json.DoctorOfferJson;
import com.accp.json.DrugJson;
import com.alibaba.fastjson.JSON;
import com.xiao.Utilxiao.Commonxiao;

/**
 * 处方的业务处理
 * @author xueshe01
 *
 */
public class PrescriptionBizImpl implements PrescriptionBiz {

	private Logger logger = Logger.getLogger(PrescriptionBizImpl.class);
	private PrescriptionDao pd = new PrescriptionImpl();
	private DoctorOfferBiz docoffBiz = new DoctorOfferBizImpl();
	private RegisteredBiz registeredBiz = new RegisteredBizImpl();
	
	@Override
	public List<Prescription> getByDocoff(DoctorOffer docoff) throws Exception {
		
		if( null == docoff || null == docoff.getDoid() || docoff.getDoid() == 0  ){
			
			logger.debug("根据就诊信息查询处方信息失败，参数为null");
			throw new NullPointerException("Prescription getByDocoff() paramter is null");
			
		}
		
		List<Prescription> list = pd.getByDocoff(docoff);
		
		if(null == list || list.size() == 0)return null;
		else return list;
	}

	@Override
	public List<Prescription> getByDrug(Drug drug) throws Exception {
		
		if( null == drug || null == drug.getDrugId() || drug.getDrugId() == 0  ){			
			logger.debug("根据药品查询处方信息失败，参数为null");
			throw new NullPointerException("Prescription getByDrug() paramter is null");
		}
		
		List<Prescription> list = pd.getByDrug(drug);
		
		if(null == list || list.size() == 0)return null;
		else return list;
	}

	@Override
	public Prescription getById(Integer preId) throws Exception {
		
		if( null == preId || preId == 0 ){
			logger.debug("根据编号查询处方信息失败，参数为null");
			throw new NullPointerException("Prescription getById() paramter is null");
		}
		
		Prescription p = pd.getById(preId);		
		return p;
	}

	@Override
	public Prescription add(Prescription p) throws Exception {
		
		if( null == p ){
			
			logger.debug("添加处方信息失败，参数为null");
			throw new Exception("Prescription add() parameter is null");
		}
		
		Object id = pd.add(p);
		if( null == null ) return null;
		else return getById((Integer) id);
	}

	@Override
	public Boolean del(List<Integer> pres) throws Exception {
		if( null == pres || pres.size() == 0 ){
			logger.debug("删除处方信息失败，参数为null");
			throw new Exception("Prescription del() parameter is null");
		}
		int count = pres.size();
		int j = 0;
		for (Integer id : pres) {
			if( pd.del(id) )j++;
		}
		if( j == count )return true;
		else return false;
	}

	@Override
	public Prescription update(Prescription p) throws Exception {
		
		if( null == p ){
			logger.debug("修改处方信息失败，参数为null");
			throw new Exception("Prescription update() parameter is null");
		}
		if( pd.update(p) ){
			return getById(p.getPreId());
		}
		else return null;
	}

	@Override
	public String getPreByReg(String regid) throws Exception {
		if( null == regid ){
			logger.debug("通过挂号编号查循处方失败，参数为null");
			throw new Exception("nullParameter");
		}

		DoctorOfferJson docoffjson = new DoctorOfferJson();
		
		Registered reg = registeredBiz.getById(regid); //根据挂号编号获取挂号对象
		
		List<DoctorOffer> list = docoffBiz.getByRegistered(reg); // 根据挂号对象，获取就诊集合
		
		if( null != list && list.size() >= 0 ){
			
			DoctorOffer doc = list.get(0);
 			
			List<Prescription> prelist = pd.getByDocoff(doc); // 通过挂号信息获取处方信息
			DrugJson drugjson = new DrugJson();
			
			if( null != prelist && prelist.size() >= 0 ){
				
				List<DrugJson> druglist = new LinkedList<>(); // 获取处方中的药品的json集合
				for (Prescription pl : prelist) { // 循环处方信息获取处方中的药品信息
					
//					docoffjson.setName(pl.getDrug().getDrugName());
//					docoffjson.setNumber(pl.getDrugNum());
//					docoffjson.setPrice(pl.getDrug().getDrugPrice());
//					docoffjson.setStandard(pl.getDrug().getSpecification());
//					docoffjson.setUnit(pl.getDrug().getDrugBigUnit()); 
					
					drugjson.setName(pl.getDrug().getDrugName());
					drugjson.setNumber(pl.getDrugNum());
					drugjson.setPrice(pl.getDrug().getDrugPrice());
					drugjson.setStandard(pl.getDrug().getSpecification());
					drugjson.setUnit(pl.getDrugUnit());
					druglist.add(drugjson);
					
				}
				docoffjson.setPatient(JSON.toJSONString(reg.getPatient()));
				docoffjson.setRegisteredid(JSON.toJSONString(reg));
				docoffjson.setDoid(doc.getDoid());
				docoffjson.setSymptom(doc.getSymptom());
				docoffjson.setUsersName(doc.getUsers().getTrueName());
				
				docoffjson.setDrugJson(JSON.toJSONString(druglist));
 			}
		}else{
			return null;
		}
		return JSON.toJSONString(docoffjson);
	}

	@Override
	public List<Prescription> getUsersId(String id) throws Exception {
		// TODO 自动生成的方法存根
		List<Prescription> list=null;
		if(Commonxiao.IsNull(id))
		{
			list=pd.getUsersId(id);
		}
		return list;
	}
}
