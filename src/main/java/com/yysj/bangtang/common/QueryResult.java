package com.yysj.bangtang.common;

import java.util.List;

/**
 * 分页查询返回的对象
 * @author xcitie
 *
 * @param <T>
 */
public class QueryResult<T> {
	/**
	 * 分页返回的对象集合
	 */
	private List<T> resultlist;
	/**
	 *  查询记录总个数
	 */
	private long totalrecord;
	public List<T> getResultlist() {
		return resultlist;
	}
	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}
	public long getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
	}
}
