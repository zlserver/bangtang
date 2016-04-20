package com.yysj.bangtang.bean;
/**
 * 系统权限类
 * @author liang
 * @version 创建时间 2016年4月14日
 * 说明:
 *
 */
public class SystemPrivilege {
	/**
	 * 权限模块
	 */
	private String moudle;
	/**
	 * 权限
	 */
	private String privilege;
	/**
	 * 权限名称
	 */
	private String name;
	public String getMoudle() {
		return moudle;
	}
	public void setMoudle(String moudle) {
		this.moudle = moudle;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
