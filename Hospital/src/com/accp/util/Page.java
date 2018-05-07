package com.accp.util;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 封装分页类
 * 
 * @author 解金化
 *
 * @param <T>
 * 		形参，需要分页的实体类
 * 
 * @version 1.0
 */
public class Page<T> {
	
	private Integer pagesize=1; // 当前页数
	private Integer pagetotal; // 总页数
	private Integer items = 10; // 条目数
	private Integer itemscount; // 总条目数
	private List<T> list; // 一页的对象
	private String listJson; // 将集合转换成为一个json
	
	
	public String getListJson() {
		return listJson;
	}
	public void setListJson(String listJson) {
		this.listJson = listJson;
	}
	public Page() {
		super();
	}
	public Page(Integer pagesize, Integer pagetotal, Integer items, Integer itemscount, List<T> list, String listJson) {
		super();
		this.pagesize = pagesize;
		this.pagetotal = pagetotal;
		this.items = items;
		this.itemscount = itemscount;
		this.list = list;
		this.listJson = listJson;
	}
	public Integer getPagesize() {
		return pagesize;
	}	
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	
	public Integer getPagetotal() {
		return pagetotal;
	}
	
	public void setPagetotal(Integer pagetotal) {
		this.pagetotal = pagetotal;
	}
	public Integer getItems() {
		return items;
	}	
	public void setItems(Integer items) {
		this.items = items;
	}
	
	public Integer getItemscount() {
		return itemscount;
	}	
	public void setItemscount(Integer itemscount) {
		// 在获取总条目的时候 直接 获取总页数
		setPagetotal( (itemscount % this.items == 0)?(itemscount/this.items):(itemscount/this.items + 1) );
		this.itemscount = itemscount;
	}
	
	public List<T> getList() {
		return list;
	}	
	public void setList(List<T> list) {
		setListJson(JSON.toJSONString(list));
		this.list = list;
	}	
}
