package cn.vote.util;

import java.util.List;

/**
 * 分页对象，封装信息
 * 
 * @author 解金化
 *
 * @param <T>
 * 		任意类型
 */
public class Page<T> {
	
	private Integer pageSize=1; // 第几页 非null
	private Integer total; // 总条目
	private Integer items = 10; // 每页多少行
	private Integer pageCount; // 总页数
	private List<T> rows; // 条目信息 非null
	
	/**
	 * 获取页码
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * 设置页码
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 获取总条数
	 */
	public Integer getTotal() {
		return total;
	}
	/**
	 * 设置总条数
	 */
	public void setTotal(Integer total) {
		setPageCount( (total % this.items == 0)?(total/this.items):(total/this.items + 1) );
		this.total = total;
	}
	/**
	 * 获取条目信息
	 */
	public List<T> getRows() {
		return rows;
	}
	/**
	 * 设置条目信息
	 */
	public void setRows(List<T> list) {
		this.rows = list;
	}
	/**
	 * 获取每页条目数量
	 */
	public Integer getItems() {
		return items;
	}
	/**
	 * 设置每页条目数量
	 */
	public void setItems(Integer items) {
		this.items = items;
	}
	/**
	 * 获取总页数
	 */
	public Integer getPageCount() {
		return pageCount;
	}
	/**
	 * 设置总页数
	 */
	public void setPageCount(Integer pageCount) {
		
		this.pageCount = pageCount;
	}
	
}
