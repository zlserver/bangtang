package com.yysj.bangtang.bean;
/**
 * 权限组（角色）
 * @author liang
 * @version 创建时间 2016年4月14日
 * 说明:
 *
 */
public class PrivilegeGroup {
	/**
	 * 标识id
	 */
	private String groupId;
	/**
	 * 名称
	 */
	private String name;
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
