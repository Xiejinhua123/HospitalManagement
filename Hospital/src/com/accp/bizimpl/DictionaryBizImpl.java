package com.accp.bizimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.accp.bizdao.DictionaryBiz;
import com.accp.dao.DictionaryDao;
import com.accp.demo.Dictionary;
import com.accp.impl.DictionaryImpl;
import com.accp.util.Page;

/**
 * 数据字典表的业务处理
 * @author 解金化
 * @date 2017.05.09
 *
 */
public class DictionaryBizImpl implements DictionaryBiz {

	private Logger logger = Logger.getLogger(DictionaryBizImpl.class);
	private DictionaryDao dicdao = new DictionaryImpl();
	@Override
	public Dictionary add(Dictionary dictionary) throws Exception {
		
		if( null == dictionary ){
			
			logger.debug("添加数据字典，参数为null");
			throw new Exception("dictionary add() parameter is null");
		}
		
		Dictionary d = (Dictionary) dicdao.add(dictionary);
		
		if( null == d)
			return null;
		else
			return d;
	}

	@Override
	public Boolean del(List<Integer> dicId) throws Exception {
		
		if( null == dicId || dicId.size() <= 0 ){
			logger.debug("删除数据字典失败，参数为null");
			throw new Exception("dictionary del() parameter is null");
		}
		
		int count = dicId.size();
		int j = 0;
		for (Integer integer : dicId) {
		boolean	b=dicdao.del(integer);
		if(b) j++;
		}
		
		if(j == count)return true;
		else return false;
	}

	@Override
	public Dictionary update(Dictionary diction) throws Exception {
		
		if( null == diction ){
			logger.debug("修改数据字典失败，参数为null");
			throw new Exception("dictionary update() parameter is null");
		}
		
		boolean bo = dicdao.update(diction);
		
		if(bo){
			Dictionary dic = getById(diction.getDicId());
			return dic;
		}
		else
		return null;
	}

	@Override
	public void getPage(Page<Dictionary> page,Dictionary dic) throws Exception {
		
		if(page.getItems() <= 0 || page.getPagesize() <= 0){
			logger.debug("分页查询数据字典失败，分页对象不正确");
			throw new Exception("dictionary getPage() parameter is null");
		}
		
		dicdao.getPage(page,dic);
		
	}

	@Override
	public Dictionary getById(Integer id) throws Exception {
		
		Dictionary dic = new Dictionary();
		dic.setDicId(id);
		List<Dictionary> d = getByColumn(dic);
		
		if(null == d || d.size() == 0){
			return null;
		}else		
			return d.get(0);
	}

	@Override
	public List<Dictionary> getByColumn(Dictionary d) throws Exception {
		
		List<Dictionary> list = dicdao.getByColumn(d);
		if( null == list || list.size() == 0 )
			return null;
		else
			return list;
	}

	@Override
	public List<Dictionary> getAll(Dictionary d) throws Exception {
		return getByColumn(d);
	}

	@Override
	public List<String> getTypeName() throws Exception {
		
		List<Dictionary> list = getByColumn(new Dictionary());
		List<String> dicNames = new ArrayList<String>();
		for (Dictionary dic : list) {
			String typename = dic.getTypeName();
			Boolean boole = true; // 假设没有相同的
			for (String name : dicNames) { // 数组中的对象
				if( name.equals(typename) ){ // 数组中对象跟返回对象相比
					boole = false; // 有相同的
					break;
				}
			}
			if( boole ){ // 如果没有
				dicNames.add(dic.getTypeName());
			}			
		}
		return dicNames;
	}

	@Override
	public Boolean updateTypeName(String oldName, String newName) throws Exception {
		
		if( null == oldName || null == newName || oldName.length() == 0 || newName.length() == 0 ){
			logger.debug("修改类型名称失败，参数为null");
			throw new Exception("updateTypeName() paramter is null");
		}
		
		if( oldName.equals(newName) ){
			return true;
		}

		Dictionary dic = new Dictionary();
		dic.setTypeName(oldName);
		
		List<Dictionary> list = getByColumn(dic);
		
		if( null != list && list.size() > 0 ){
			
			for (Dictionary d : list) {
				d.setTypeName(newName);
			}
			return true;
			
		}else
		
		return false;
	}

	@Override
	public boolean delByTypeName(String typeName) throws Exception {
		if( null == typeName ){
			logger.debug("删除数据字典失败，参数为null");
			throw new Exception("dictionary del() parameter is null");
		}
			boolean bo = dicdao.delByTypeName(typeName);
		
		if(bo)return true;
		else return false;
	}

}
