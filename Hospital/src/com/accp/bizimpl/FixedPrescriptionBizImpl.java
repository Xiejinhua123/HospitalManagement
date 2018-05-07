package com.accp.bizimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.accp.bizdao.FixedPrescriptionBiz;
import com.accp.dao.FixedPrescriptionDao;
import com.accp.demo.Drug;
import com.accp.demo.FixedPrescription;
import com.accp.demo.FixedSysmptoms;
import com.accp.impl.FixedPrescriptionimpl;

/**
 * 固定处方表的业务实现
 * @author xueshe01
 *
 */
public class FixedPrescriptionBizImpl implements FixedPrescriptionBiz {

	private Logger logger = Logger.getLogger(FixedPrescriptionBizImpl.class);
	private FixedPrescriptionDao fpd = new FixedPrescriptionimpl();
	
	@Override
	public List<FixedPrescription> getByFixedSysmptoms(FixedSysmptoms f) throws Exception {

		if( null == f ){
			logger.debug("根据固定症状查询固定处方失败，参数为null");
			throw new Exception("FixedPrescription getByFixedSysmptoms() parameter is null");
		}
		return fpd.getByFixedSysmptoms(f);
	}

	@Override
	public FixedPrescription getById(Integer id) throws Exception {
		if( null == id || id <= 0 ){
			logger.debug("根据编号查询固定处方失败，编号不正确");
			throw new Exception("FixedPrescription add() parameter is null");
		}
		return fpd.getById(id);
	}

	@Override
	public FixedPrescription add(FixedPrescription f) throws Exception {
		if( null == f ){
			logger.debug("添加固定处方失败，参数为null");
			throw new Exception("FixedPrescription add() parameter is null");
		}
		Object obj = fpd.add(f);
		FixedPrescription fix = getById((Integer) obj);
		return fix;
	}

	@Override
	public FixedPrescription update(FixedPrescription f) throws Exception {
		
		if( null == f || null == f.getFpid() || f.getFpid() <= 0 ){
			logger.debug("修改固定处方失败，参数为null");
			throw new Exception("FixedPrescription update() parameter is error");
		}
		
		if(fpd.update(f))
			return getById(f.getFpid());
		else
			return null;
	}

	@Override
	public List<FixedPrescription> getByDrug(Drug drug) throws Exception {
		
		if( null == drug ){
			logger.debug("根据药品查询固定处方失败，参数为null");
			throw new Exception("FixedPrescription getByDrug() parameter is null");
		}
		return fpd.getByDrug(drug);
	}

	@Override
	public boolean del(List<Integer> fixids) throws Exception {
		
		if( null == fixids || fixids.size() <= 0 ){
			logger.debug("删除固定处方失败，参数为null");
			throw new Exception("FixedPrescription del() parameter is null");
		} 
		int count = fixids.size();
		int j = 0;
		for (Integer id : fixids) {
			if( fpd.del(id) )j++;
		}
		if( j == count )return true;
		else return false;
	}

}
