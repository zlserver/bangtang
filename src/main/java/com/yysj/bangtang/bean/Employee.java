package com.yysj.bangtang.bean;

import java.util.Date;

/**
 * 员工
 * @author liang
 * @version 创建时间 2016年4月14日
 * 说明:
 *
 */
public class Employee {

	/**
	 * 账号
	 */
	private String account;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 登陆次数
	 */
	private int loginCount;
	
	/**
	 * 状态，1：在职，2：屏蔽
	 */
	private int state=1;
	/**
	 * 性别1：男，0：女
	 */
	private int gender =1;
	/**
	 * 最近一次登陆时间
	 */
	private Date recLogTime;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}
	public Date getRecLogTime() {
		return recLogTime;
	}
	public void setRecLogTime(Date recLogTime) {
		this.recLogTime = recLogTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
}
