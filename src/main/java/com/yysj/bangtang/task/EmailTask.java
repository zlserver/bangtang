package com.yysj.bangtang.task;

/**
 * 邮箱通知任务，目前包括两个任务：
 * 1.激活邮箱通知任务
 * 2.重置密码通知任务
 * 任务的优先级有3个等级：
 * 高：任务优先执行的权利最高
 * 中：任务优先执行的权利中等
 * 低：任务优先执行的权利最低
 * @author xcitie
 *
 */
public class EmailTask {
	/**
	 * 任务优先级，数字大于0，数字越小优先级越高
	 */
	private TaskPriority priority;
	/**
	 * 要通知的邮箱
	 */
	private String toEmail;
	/**
	 * 通知的内容
	 */
	private  String sendContent;
	/**
	 * 邮箱主题
	 */
	private String subject;
	
	
	public EmailTask() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailTask(TaskPriority priority, String toEmail, String sendContent,String subject) {
		super();
		this.priority = priority;
		this.toEmail = toEmail;
		this.sendContent = sendContent;
		this.subject = subject;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public TaskPriority getPriority() {
		return priority;
	}
	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}
	public String getSendContent() {
		return sendContent;
	}
	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 任务优先级枚举类
	 * @author xcitie
	 *
	 */
	public enum TaskPriority{
		//优先级低
		PRIORITY_LOW,
		//优先级中等
		PRIORITY_NORMAL,
		//优先级高
		PRIORITY_HIGH;
	}
}
