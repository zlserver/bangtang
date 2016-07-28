package com.yysj.bangtang.task;

/**
 * 激活邮箱通知任务
 * @author xcitie
 *
 */
public class ActiveEmailTask {
	private String toEmail;
	private String activeCode;
	
	public ActiveEmailTask(String toEmail, String activeCode) {
		super();
		this.toEmail = toEmail;
		this.activeCode = activeCode;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	
}
