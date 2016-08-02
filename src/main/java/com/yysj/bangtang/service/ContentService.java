package com.yysj.bangtang.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yysj.bangtang.bean.Content;
import com.yysj.bangtang.common.QueryResult;
import com.yysj.bangtang.myenum.ContentStateEnum;

public interface ContentService {
	/**
	 * 发表一篇动态
	 * @param content
	 * @return
	 */
	public int publish(Content content);
	/**
	 * 根据id获取一条动态消息
	 * @param id
	 * @return
	 */
	public Content getById(String id);

	/**
	 * 根据邮箱分页查询用户的动态内容
	 * @param email  用户邮箱
	 * @param pageNumber  查询的页码
	 * @param pageSize    每页最大的记录数
	 * @return 分页记录
	 */
	public Page<Content> getScrollByEmail(String email,int pageNumber,int pageSize); 
	
	/**
	 * 根据内容状态分页查询所有用户的动态内容
	 * @param state  内容状态
	 * @param pageNumber  查询的页码
	 * @param pageSize    每页最大的记录数
	 * @return
	 */
	public Page<Content> getScrollByState(ContentStateEnum state, int pageNumber,int pageSize);

}
