package com.yysj.bangtang.bean;

import java.util.Date;

/**
 * 顾客关注表
 * @author liang
 * @version 创建时间 2016年4月14日
 * 说明:
 *
 */
public class Attention {
	/**
	 * 标识id
	 */
	private String id;
	/**
	 * 主动者邮箱
	 */
	private String inEmail;
	/**
	 * 被关注者邮箱
	 */
	private String paEmail;
	/**
	 * 关注时间
	 */
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInEmail() {
		return inEmail;
	}
	public void setInEmail(String inEmail) {
		this.inEmail = inEmail;
	}
	public String getPaEmail() {
		return paEmail;
	}
	public void setPaEmail(String paEmail) {
		this.paEmail = paEmail;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
