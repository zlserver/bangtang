package com.yysj.bangtang.common;

import java.util.LinkedHashMap;

/**
 * 分页查询参数
 * @author xcitie
 *
 */
public class ScrollQuery {
	/**
	 * 开始查询的位置从0开始
	 */
	private int firstindex;
	/**
	 * 一页的最大记录数
	 */
	private int maxresult;
	/**
	 * 查询条件，"o.xxxx=? and o.xxx like ?"
	 */
	private String where;
	/**
	 * 查询条件占位符对应的参数值
	 */
	private Object[] queryParams;
	/**
	 * 排序条件 key为属性，value为asc或desc
	 */
	private LinkedHashMap<String, String> orderby;
	public int getFirstindex() {
		return firstindex;
	}
	public void setFirstindex(int firstindex) {
		this.firstindex = firstindex;
	}
	public int getMaxresult() {
		return maxresult;
	}
	public void setMaxresult(int maxresult) {
		this.maxresult = maxresult;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public Object[] getQueryParams() {
		return queryParams;
	}
	public void setQueryParams(Object[] queryParams) {
		this.queryParams = queryParams;
	}
	public LinkedHashMap<String, String> getOrderby() {
		return orderby;
	}
	public void setOrderby(LinkedHashMap<String, String> orderby) {
		this.orderby = orderby;
	}
	
}
