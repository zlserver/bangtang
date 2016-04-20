package com.yysj.bangtang.bean;
/**
 * 权限和权限组关系
 * @author liang
 * @version 创建时间 2016年4月14日
 * 说明:
 *
 */
public class GroupPrivilegeRel {
	/**
	 * 关系id
	 */
	private String relId;
	/**
	 * 权限组id
	 */
	private String groupId;
	/**
	 * 模块
	 */
	private String moudle;
	/**
	 * 权限
	 */
	private String privilege;
	
	public String getRelId() {
		return relId;
	}
	public void setRelId(String relId) {
		this.relId = relId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
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
	
}
