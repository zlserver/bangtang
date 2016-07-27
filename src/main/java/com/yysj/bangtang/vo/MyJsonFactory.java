package com.yysj.bangtang.vo;

import com.yysj.bangtang.myenum.OperationStatus;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class MyJsonFactory {

	/**
	 * 根据状态生成json对象
	 * @param status  OperationStatus操作状态枚举类
	 * @return jsonObject对象，对象内容格式
	 * {
	 *    "status":1,
	 *    "message":"操作成功"
	 * }
	 */
	public static JSONObject generator(OperationStatus status){
		JSONObject json= new JSONObject();
		json.put("status", status.ordinal());
		json.put("message", status.getMessage());

		return json;
	}
	/**
	 * 根据操作状态和传人对象生成JSONObject对象
	 * @param status 操作状态
	 * @param ob 要封装的Object类
	 * @return 
	 * {
	 *    "status":1,
	 *    "message":"操作成功"
	 *    "data":{
	 *     objson        //ob对象的json字符串
	 *    }
	 * }
	 */
	public static JSONObject generator(OperationStatus status,Object ob){
		JSONObject json= new JSONObject();
		json.put("status", status.ordinal());
		json.put("message", status.getMessage());
		JSONObject objson= JSONObject.fromObject(ob);
		json.put("data", objson);
		return json;
	}
	/**
	 * 根据操作状态和传入对象生成JSONObject对象，传入对象根据config来控制生成的json对象
	 * @param status 操作状态
	 * @param ob 要封装的Object类
	 * @param config ob对象的json配置类，影响ob类生产json对象。
	 * @return
	 * {
	 *    "status":1,
	 *    "message":"操作成功"
	 *    "data":{
	 *     objson        //ob对象的json字符串
	 *    }
	 * }
	 */
	public static JSONObject generator(OperationStatus status,Object ob,JsonConfig config){
		JSONObject json= new JSONObject();
		json.put("status", status.ordinal());
		json.put("message", status.getMessage());
		JSONObject objson= JSONObject.fromObject(ob,config);
		json.put("data", objson);
		return json;
	}
}
