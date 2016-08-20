package com.yysj.bangtang.mobile;

import java.util.List;
import com.yysj.bangtang.redis.RContent;

public class ContentJson extends MyStatus {
	
	
	private List<RContent> listContent;

	public List<RContent> getListContent() {
		return listContent;
	}

	public void setListContent(List<RContent> listContent) {
		this.listContent = listContent;
	}
	
	
}   