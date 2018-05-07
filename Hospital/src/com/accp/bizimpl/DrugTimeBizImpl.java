package com.accp.bizimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.accp.bizdao.DrugTimeBiz;
import com.accp.dao.DrugTimeDao;
import com.accp.demo.Drug;
import com.accp.demo.DrugTime;
import com.accp.impl.DrugTimeImpl;
import com.accp.util.Page;

public class DrugTimeBizImpl implements DrugTimeBiz {

	private Logger logger = Logger.getLogger(DrugTimeBizImpl.class);
	private DrugTimeDao drugtimedao = new DrugTimeImpl();
	
	@Override
	public DrugTime add(DrugTime d) throws Exception {
		
		if( null == d ){
			logger.debug("条件过期时间失败，参数不正确");
			throw new Exception("drugtime add() parameter is null");
		}
		
		Object id = drugtimedao.add(d);
		
		return getById((Integer) id);
	}

	@Override
	public Boolean del(List<Integer> idlist) throws Exception {
		
		if( null == idlist || idlist.size() == 0){
			logger.debug("删除过期时间失败,参数不正确");
			throw new Exception("drugtime del() parame is null");
		}
		int count = idlist.size();
		int j = 0;
		for (Integer id : idlist) {
			if(drugtimedao.del(id))j++;
		}
		if(j == count)return true;
		else return false;
	}

	@Override
	public Boolean update(DrugTime d) throws Exception {
		return null;
	}

	@Override
	public Boolean update(Integer drugId, int number, Boolean bool) throws Exception {
		return null;
	}

	@Override
	public void getPage(Page<DrugTime> page, DrugTime drugtime, Boolean bool) throws Exception {
		
		if( bool == null || null == page || page.getItems() <= 0 || page.getPagesize() <= 0 ){
			logger.debug("分页查询过期时间失败，参数异常");
			throw new Exception("drugtime getPage() parameter is null");
		}
		
		drugtimedao.getPage(page,drugtime,bool);
		
	}

	@Override
	public DrugTime getById(Integer drugTimeId) throws Exception {

		if( null == drugTimeId ||  drugTimeId <= 0){
			logger.debug("通过编号查询药品过期时间失败，参数为null");
			throw new Exception("deugTime getById() parameter is null");
		}
		
		DrugTime d = new DrugTime();
		d.setDrugTimeId(drugTimeId);
		List<DrugTime> list = getByColumn(d);
		if( null == list || list.size() == 0 )
			return null;
		else
			return list.get(0);
	}

	@Override
	public List<DrugTime> getByColumn(DrugTime d) {
		
		List<DrugTime> list = drugtimedao.getByColumn(d);
		return list;
	}

	@Override
	public List<DrugTime> getByDrug(Drug drug) throws Exception {
		
		if( null == drug ){
			logger.debug("通过药品获取药品的过期时间失败，参数为null");
			throw new Exception("drugtime getByDrug() parameter is null");
		}
		
		List<DrugTime> list = drugtimedao.getByDrug(drug);
	
		return list;
	}

}
