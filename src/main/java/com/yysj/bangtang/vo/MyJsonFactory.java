package com.yysj.bangtang.vo;

import net.sf.json.JSONObject;

public class MyJsonFactory {

	public static JSONObject generator(OperationStatus status){
		JSONObject json= new JSONObject();
		json.put("status", status.ordinal());
		return json;
	}
}
