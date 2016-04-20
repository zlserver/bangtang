package com.yysj.bangtang.bean;

import java.util.Date;

import com.yysj.bangtang.myenum.ContentStateEnum;

/**
 * 内容表,保存用户
 * @author liang
 * @version 创建时间 2016年4月14日
 * 说明:
 *
 */
public class Content {
	/**
	 * 标识id
	 */
	private String id;
	/**
	 * 发布用户
	 */
	private String email;
	/**
	 * 阅读量
	 */
	private int readCount;
	/**
	 * 点赞数
	 */
	private int agreeCount;
	/**
	 * 状态
	 */
	private ContentStateEnum state;
	/**
	 * 审核者
	 */
	private String accout;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 发布时间
	 */
	private Date pubTime;
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
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getAgreeCount() {
		return agreeCount;
	}
	public void setAgreeCount(int agreeCount) {
		this.agreeCount = agreeCount;
	}
	
	public ContentStateEnum getState() {
		return state;
	}
	public void setState(ContentStateEnum state) {
		this.state = state;
	}
	public String getAccout() {
		return accout;
	}
	public void setAccout(String accout) {
		this.accout = accout;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
		
}
