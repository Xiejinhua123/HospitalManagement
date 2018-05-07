package com.accp.bizimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.accp.bizdao.DrugBiz;
import com.accp.bizdao.FixedPrescriptionBiz;
import com.accp.bizdao.FixedSysmptomsBiz;
import com.accp.dao.FixedSysmptomsDao;
import com.accp.demo.Drug;
import com.accp.demo.FixedPrescription;
import com.accp.demo.FixedSysmptoms;
import com.accp.impl.FixedSysmptomsImpl;
import com.accp.util.Page;

/**
 * 固定症状表的业务处理
 * @author xueshe01
 *
 */
public class FixedSysmptomsBizImpl implements FixedSysmptomsBiz {

	private Logger logger = Logger.getLogger(FixedSysmptomsBizImpl.class);
	private FixedSysmptomsDao fsd = new FixedSysmptomsImpl();
	
	@Override
	public FixedSysmptoms add(FixedSysmptoms f, List<Integer> drugId) throws Exception {
		
		if( null == f ){
			logger.debug("添加固定处方出错，参数为null");
			throw new Exception("FixedSysmptoms add() parameter is null");
		}
		
		Object id = fsd.add(f);
		FixedSysmptoms fixedSysmptoms = getById((Integer) id);
		DrugBiz db = new DrugBizImpl();
		FixedPrescriptionBiz fpd = new FixedPrescriptionBizImpl();
		
		if( drugId != null ){			
			for (Integer did : drugId) {				
				Drug drug = db.getDrugById(did);
				FixedPrescription fp = new FixedPrescription();
				fp.setDrug(drug);
				fp.setFixedSysmptoms(fixedSysmptoms);
				fpd.add(fp);				
			}			
		}		
		return getById((Integer) id);
	}

	@Override
	public Boolean del(List<Integer> id) throws Exception {
		return null;
	}

	@Override
	public Boolean update(FixedSysmptoms f, List<Integer> drugIds) throws Exception {
		return null;
	}

	@Override
	public void getPage(Page<FixedSysmptoms> page, FixedSysmptoms f) throws Exception {
		if( null == page || page.getItems() <= 0 || page.getPagesize() <= 0 ){
			logger.debug("添加固定处方出错，参数为null");
			throw new Exception("FixedSysmptoms getPage() parameter error");
		}

		fsd.getPage(page,f);
		
	}

	@Override
	public FixedSysmptoms getById(Integer id) throws Exception {
		if( null == id || id <= 0 ){
			logger.debug("通过编号查询固定处方出错，参数为null");
			throw new Exception("FixedSysmptoms getById() parameter error");
		}
		FixedSysmptoms f = new FixedSysmptoms();
		f.setFsid(id);
		List<FixedSysmptoms> list = getByColumn(f);
		if( null == list || list.size() == 0 )
			return null;
		else return list.get(0);
	}

	@Override
	public List<FixedSysmptoms> getByColumn(FixedSysmptoms f) throws Exception {
		
		List<FixedSysmptoms> list = fsd.getByColumn(f);		
		return list;
	}

}
