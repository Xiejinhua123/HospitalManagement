package com.accp.dao.impl;

import java.util.List;
import java.util.Map;

import com.accp.dao.NewsDao;
import com.accp.dbpool.BaseDao;
import com.accp.demo.News;
import com.accp.demo.Page;

public class NewsImpl extends BaseDao implements NewsDao {

	public <T> int add(T t) {
		// TODO 自动生成的方法存根
		News n=(News)t;
		//id自动生成
		String sql="if not exists(select * from News where NewId=?) insert into News values(?)";
		return 0;
	}

	public int del(String id) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public <T> int update(T t) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public Page<News> getPage(int pagesize, Map<String, String> map) {
		// TODO 自动生成的方法存根
		return null;
	}

	public List<News> getById(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
