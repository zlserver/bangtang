package com.yysj.bangtang.bean;

import java.io.Serializable;
import java.util.Date;

import com.yysj.bangtang.myenum.ClientStateEnum;
import com.yysj.bangtang.myenum.LanguageEnum;

/**
 * 客户实体类
 * @author liang
 * @version 创建时间 2016年4月14日
 * 说明:
 *
 */
public class Client {
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 密码,5-15
	 */
	private String passowrd;
	/**
	 * 昵称,3-15
	 */
	private String nickName;
	/**
	 * 性别1:男，0:女
	 */
	private int gender;
	/**
	 * 国籍
	 */
	private String nation;
	/**
	 * 头像路径
	 */
	private String picPath;
	/**
	 * 学习语言
	 */
	private String language;
	/**
	 * 状态：未激活，激活状态（邮箱），无效状态
	 */
	private int state;
	/**
	 * 注册时间
	 */
	private Date regTime=new Date();
	/**
	 * 最近一次登陆时间
	 */
	private Date reLoTime;
	/**
	 * 最近一次登陆设备
	 */
	private String machine;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public Date getReLoTime() {
		return reLoTime;
	}
	public void setReLoTime(Date reLoTime) {
		this.reLoTime = reLoTime;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	
}
