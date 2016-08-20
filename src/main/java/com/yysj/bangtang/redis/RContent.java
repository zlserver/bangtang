package com.yysj.bangtang.redis;

import java.util.Date;
import java.util.List;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.bean.Content;
import com.yysj.bangtang.file.FileEntity;
import com.yysj.bangtang.utils.ServiceUtils;

public class RContent {
	/**
	 * 发布内容的id
	 */
	private String id;
	/**
	 * 发布内容
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
	 * 阅读量
	 */
	private int readCount;
	
	/**
	 * 点赞数
	 */
	private int agreeCount;
	/**
	 * 用户邮箱
	 */
	private String email;
	/**
	 * 用户性别
	 */
	private Integer gender;
	/**
	 * 用户国家
	 */
	private String nation;
	/**
	 * 用户头像
	 */
	private String picpath;
	/**
	 * 发布用户昵称
	 */
    private String nickname;
    /**
	 * 发布时间
	 */
	private Date pubTime=new Date();
	
	public RContent(Content content,Client client){
		try {
			ServiceUtils.copyBean(this, content);
			if(client!=null){
				this.setNickname(client.getNickname());
				this.setNation(client.getNation());
				this.setGender(client.getGender());
				this.setPicpath(client.getPicpath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public RContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
	
	
}
