package com.yysj.bangtang.vo;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class MyJsonFactory {

	/**
	 * 更加状态生成json对象
	 * @param status
	 * @return
	 */
	public static JSONObject generator(OperationStatus status){
		JSONObject json= new JSONObject();
		json.put("status", status.ordinal());
		json.put("message", status.getMessage());
		return json;
	}
	public static JSONObject generator(OperationStatus status,Object ob){
		JSONObject json= new JSONObject();
		json.put("status", status.ordinal());
		json.put("message", status.getMessage());
		JSONObject objson= JSONObject.fromObject(ob);
		json.put("data", objson);
		return json;
	}
	public static JSONObject generator(OperationStatus status,Object ob,JsonConfig config){
		JSONObject json= new JSONObject();
		json.put("status", status.ordinal());
		json.put("message", status.getMessage());
		JSONObject objson= JSONObject.fromObject(ob,config);
		json.put("data", objson);
		return json;
	}
}
