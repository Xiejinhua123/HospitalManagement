package com.accp.demo;

import java.util.List;

/**
 * ��װ��ҳ��
 * 
 * @author ���
 *
 * @param <T>
 * 		�βΣ���Ҫ��ҳ��ʵ����
 * 
 * @version 1.0
 */
public class Page<T> {
	
	private int pagesize; // ��ǰҳ��
	private int pagetotal; // ��ҳ��
	private int items = 10; // ��Ŀ��
	private int itemscount; // ����Ŀ��
	private List<T> list; // һҳ�Ķ���
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
		// �ڻ�ȡ����Ŀ��ʱ�� ֱ�� ��ȡ��ҳ��
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
