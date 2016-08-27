package com.yysj.bangtang.formbean;

import com.github.pagehelper.Page;
import com.yysj.bangtang.common.PageIndex;

public class BaseForm {

	/**
	 * 页码
	 */
	private int pageNumber=1;
	/**
	 * 每页数值
	 */
	private int pageSize=10;
	//总页数
	private int pages;
	//总记录数
	private long total;
	//当前页
	private int pageNum;
	/**
	 * 页码索引
	 */
	private PageIndex pageIndex;
	private Page page;
	public void setPage(Page page){
		this.page = page;
		this.pages = page.getPages();//总页数
		this.total =page.getTotal();//总记录数
		this.pageSize=page.getPageSize();//每页显示页码数
		this.pageNum=page.getPageNum();//当前页
		pageIndex = PageIndex.getPageIndex(10, this.pageNum, this.pages);
	}
	
	public Page getPage() {
		return page;
	}
	
	public PageIndex getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(PageIndex pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
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
