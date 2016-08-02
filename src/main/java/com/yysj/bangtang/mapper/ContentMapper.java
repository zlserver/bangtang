package com.yysj.bangtang.mapper;

import java.util.List;

import com.yysj.bangtang.bean.Content;
import com.yysj.bangtang.myenum.ContentStateEnum;

public interface ContentMapper {
	int insert(Content content);

	Content selectByPrimaryKey(String id);
	
	/**
	 * 根据邮箱查询动态，按时间降序排列
	 * @param email
	 * @return
	 */
	List<Content> selectByEmail(String email);
	/**
	 * 根据内容状态查询动态，按时间降序排列
	 * @param state
	 * @return
	 */
	List<Content> selectByState(ContentStateEnum state);
	
}
