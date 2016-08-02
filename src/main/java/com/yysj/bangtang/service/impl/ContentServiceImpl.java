package com.yysj.bangtang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yysj.bangtang.bean.Content;
import com.yysj.bangtang.common.QueryResult;
import com.yysj.bangtang.mapper.ContentMapper;
import com.yysj.bangtang.myenum.ContentStateEnum;
import com.yysj.bangtang.service.ContentService;
import com.yysj.bangtang.utils.ValidateUtil;

@Service("contentService")
public class ContentServiceImpl implements ContentService {
	private ContentMapper contentMapper;
	
	public int publish(Content content) {
		if( content!=null)
			return contentMapper.insert(content);
		return 0;
	}

	public Content getById(String id) {
		if( ValidateUtil.isValidateStr(id))
		 return contentMapper.selectByPrimaryKey(id);
		else
			return null;
	}
	public ContentMapper getContentMapper() {
		return contentMapper;
	}
	@Autowired
	public void setContentMapper(ContentMapper contentMapper) {
		this.contentMapper = contentMapper;
	}

	public Page<Content> getScrollByEmail(String email, int pageNumber, int pageSize) {
		PageHelper.startPage(pageNumber,pageSize);  
		List<Content> list =contentMapper.selectByEmail(email);
		
	    return (Page)list;
	}

	public Page<Content> getScrollByState(ContentStateEnum state, int pageNumber, int pageSize) {
		PageHelper.startPage(pageNumber,pageSize);  
		List<Content> list =contentMapper.selectByState(state);
		
	    return (Page)list;
	}

}
