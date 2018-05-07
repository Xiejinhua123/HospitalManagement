package com.accp.bizimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.accp.bizdao.NewsBiz;
import com.accp.dao.NewsDao;
import com.accp.demo.News;
import com.accp.impl.NewsImpl;
import com.accp.util.Page;

public class NewsBizImpl implements NewsBiz {

	private Logger logger = Logger.getLogger(NewsBizImpl.class);
	private NewsDao newdao = new NewsImpl();
	
	@Override
	public News add(News news) throws Exception {
		if( null == news ){
			logger.debug("添加新闻失败，参数为null");
			throw new Exception("news add() parameter is null");
		}
		Object id = newdao.add(news);
		return getById((Integer) id);
	}

	@Override
	public Boolean del(List<Integer> ids) throws Exception {
		if( null == ids || ids.size() <= 0 ){
			logger.debug("删除新闻失败，参数异常");
			throw new Exception("news del() parameter error");
		}
		int i = 0;
		int count = ids.size();
		
		for (Integer id : ids) {
			if( newdao.del(id) )i++;
		}
		if( i == count )return true;
		else return false;
	}

	@Override
	public News update(News news) throws Exception {
		
		if( null == news || null == news.getNewId() || news.getNewId() <= 0 ){
			logger.debug("修改新闻失败，参数异常");
			throw new Exception("news update() parameter error");
		}
		Boolean bool = newdao.update(news);
		if(bool)return getById(news.getNewId());
		else return null;
	}

	@Override
	public void getPage(Page<News> page, News n) throws Exception {
		
		if( null == page || page.getItems() <= 0 || page.getPagesize() <= 0 ){
			logger.debug("分页查询新闻失败，参数异常");
			throw new Exception("news getPage() parameter error");
		}
		
		newdao.getPage(page,n);
		
	}

	@Override
	public News getById(Integer id) throws Exception {
		if( null == id || id <= 0 ){
			logger.debug("通过编号查询新闻失败，参数异常");
			throw new Exception("news getById() parameter is null");
		}
		return null;
	}

	@Override
	public List<News> getByColumn(News n) throws Exception {
		return newdao.getByCoulumn(n);
	}

}
