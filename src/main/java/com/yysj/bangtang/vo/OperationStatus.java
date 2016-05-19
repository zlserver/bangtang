package com.yysj.bangtang.vo;

/**
 * 移动端此次操作的状态说明
 * @author xcitie
 *
 */
public enum OperationStatus {

	UNKNOW_EXCEPTION("未知异常"),
	SUCCESS("操作成功"),
	PARAM_ERROR("请求参数不完整"),
	
	
	CLIENT_EMAIL_PASS_ERROR("邮箱格式或者密码有误"),
	CLIENT_EMAIL_EXIST("邮箱已被注册");
	
	private final String message;

	private OperationStatus(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
	
}
