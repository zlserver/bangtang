package com.yysj.bangtang.bean;

import java.util.Date;

public class ClientLogin {
	/**
	 * 标识id
	 */
	private String id;
	/**
	 * 登陆邮箱
	 */
	private String email;
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
	/**
	 * 登陆地区
	 */
	private String area;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
}
