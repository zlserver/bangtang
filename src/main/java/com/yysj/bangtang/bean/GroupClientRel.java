package com.yysj.bangtang.bean;
/**
 * 
 * @author liang
 * @version 创建时间 2016年4月14日
 * 说明:
 *
 */
public class GroupClientRel {
	/**
	 * 关系id
	 */
	private String relId;
	/**
	 * 权限组id
	 */
	private String groupId;
	/**
	 * 员工账号
	 */
	private String account;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}
