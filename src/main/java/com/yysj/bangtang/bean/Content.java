package com.yysj.bangtang.bean;

import java.util.Date;

import com.yysj.bangtang.myenum.ContentStateEnum;

/**
 * 内容表,保存用户发表过的动态，一个动态可能包含文字、图片（短视频）、阅读量、点赞数。
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
	private ContentStateEnum state=ContentStateEnum.PASS;
	/**
	 * 审核者
	 */
	private String checker;
	/**
	 * 文本内容
	 */
	private String text;
	/**
	 * 多个图片保存路径，多图片路径之间以逗号（,）相隔。
	 * 因为多个图片保存的目录相同，所以多个图片只保存一份目录路径。
	 * 
	 * 比如有2张图片路径如下：image/content/20160802/flower1.png,image/content/20160802/flower2.png,
	 * 最终保存的在该变量中的值为image/content/20160802/,flower1.png,flower2.png
	 * 
	 * 一份图片会保存两份，一个完整版，一个压缩版，压缩版图片保存路径就是在未压缩保存路径上加一个compress目录，
	 * 比如image/content/20160802/flower1.png图片的压缩版保存路径为
	 * image/content/20160802/compress/flower1.png
	 */
	private String picSavePath;
	/**
	 * 短视频保存路径，短视频的时间长度有限制，在配置文件中
	 * 一份视频会保存两份，一个完整版，一个压缩版，压缩版视频保存路径就是在未压缩保存路径上加一个compress目录，
	 * 比如video/content/20160802/flower1.avi短视频的压缩版保存路径为
	 * video/content/20160802/compress/flower1.avi
	 */
	private String videoSavePath;
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 发布时间
	 */
	private Date pubTime=new Date();
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
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
	public String getPicSavePath() {
		return picSavePath;
	}
	public void setPicSavePath(String picSavePath) {
		this.picSavePath = picSavePath;
	}
	public String getVideoSavePath() {
		return videoSavePath;
	}
	public void setVideoSavePath(String videoSavePath) {
		this.videoSavePath = videoSavePath;
	}
		
}
