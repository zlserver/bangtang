package com.yysj.bangtang.vo;

import java.util.HashMap;
import java.util.Map;

public class BaseVo {
	/**
	 * 存放表单校验后的结果
	 */
	private Map<String,String> error=new HashMap<String,String>();
	
	
	public Map<String, String> getError() {
		return error;
	}
	public void setError(Map<String, String> error) {
		this.error = error;
	}
}
	
