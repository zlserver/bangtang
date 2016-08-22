package com.yysj.bangtang.formbean;

/**
 * 条件查询用户表单
 * @author xcitie
 *
 */
public class QueryClientForm extends BaseForm{

	/**
	 * 查询标识
	 */
	public final static String QUERY_FLAGE="query";
	/**
	 * 是否查询
	 */
	private String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
}
