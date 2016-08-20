package com.yysj.bangtang.common;

import com.yysj.bangtang.bean.Content;

public interface Dao<T> {
	
	/**
	 * 
	 * @param email
	 * @param firstindex
	 * @param maxresult
	 * @return
	 */
	public QueryResult<Content> getScrollByEmail(String email,int firstindex,int maxresult);

	public QueryResult<Content> getScrollData(int firstindex,int maxresult,String where,Object[] queryParams);

}
