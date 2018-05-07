package com.accp.demo;

import java.util.List;

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
	
	private int pagesize; // 当前页数
	private int pagetotal; // 总页数
	private int items = 10; // 条目数
	private int itemscount; // 总条目数
	private List<T> list; // 一页的对象
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Page(int pagesize, int pagetotal, int items, int itemscount,
			List<T> list) {
		super();
		this.pagesize = pagesize;
		this.pagetotal = pagetotal;
		this.items = items;
		this.itemscount = itemscount;
		this.list = list;
	}
	
	public int getPagesize() {
		return pagesize;
	}	
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	public int getPagetotal() {
		return pagetotal;
	}
	
	public int getItems() {
		return items;
	}	
	public void setItems(int items) {
		this.items = items;
	}
	
	public int getItemscount() {
		return itemscount;
	}	
	public void setItemscount(int itemscount) {
		// 在获取总条目的时候 直接 获取总页数
		this.pagetotal = (itemscount % this.items == 0)?(itemscount/this.items):(itemscount/this.items + 1);
		
		this.itemscount = itemscount;
	}
	
	public List<T> getList() {
		return list;
	}	
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
