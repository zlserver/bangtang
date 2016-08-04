package com.yysj.bangtang.myenum;

/**
 * 移动端此次操作的状态说明
 * @author xcitie
 *
 */
public enum OperationStatus {

	UNKNOW_EXCEPTION(0,"未知异常"),
	SUCCESS(1,"操作成功"),
	PARAM_ERROR(2,"请求参数不完整"),
	
	
	CLIENT_EMAIL_PASS_ERROR(1001,"邮箱格式或者密码有误"),
	CLIENT_EMAIL_EXIST(1002,"邮箱已被注册"),
	CLIENT_EDIT_PIC_ERROR(1003,"修改用户头像出错"),
	CLIENT_EMAIL_INVALIDATE(1004,"邮箱无效"),
	CLIENT_RESETCODE_INVALIDATE(1005,"重置码无效"),
	CLIENT_PASSWORD_INVALIDATE(1006,"密码不满足要求"),
	
	
	TOKEN_UNACCORDANCE(2001,"token值不一致"),
	

	IMAGE_TYPE_ERROR(3001,"图片格式有误！"),
	IMAGE_COUNT_OUTLIMIT(3002,"图片数量超出了限制！");
	
	private final int status;
	private final String message;

	private OperationStatus(int status,String message) {
		this.message = message;
		this.status =status;
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}
}
