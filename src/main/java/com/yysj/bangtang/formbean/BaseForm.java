package com.yysj.bangtang.formbean;

public class BaseForm {

	/**
	 * 页码
	 */
	private int pageNumber=1;
	/**
	 * 每页数值
	 */
	private int pageSize=10;
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
