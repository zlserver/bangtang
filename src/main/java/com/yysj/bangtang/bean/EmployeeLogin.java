package com.yysj.bangtang.bean;

import java.util.Date;

/**
 * 员工登陆表
 * @author liang
 * @version 创建时间 2016年4月14日
 * 说明:
 *
 */
public class EmployeeLogin {
	/**
	 * 标识id
	 */
	private String id;
	/**
	 * 登陆账号
	 */
	private String account;
	/**
	 * 登陆时间
	 */
	private Date loginTime;
	/**
	 * 登陆ip
	 */
	private String ip;
	/**
	 * 登陆设备
	 */
	private String machine;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	
	
}
