package com.yysj.bangtang.service;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.bean.custom.ClientCustom;

public interface ClientService {
	
	/**
	 * 通过邮箱查询用户
	 * @param email 邮箱
	 * @return
	 */
	public Client findByEmail(String email);
	/**
	 * 用户登录
	 * @param email 邮箱
	 * @param password 密码
	 * @return
	 */
	public Client login(String email,String password);
	/**
	 * 注册用户
	 * @param email 邮箱
	 * @param password 密码
	 * @return
	 */
	public void registerByEmail(String email,String password);
	/**
	 * 更改用户的状态
	 * @param eamil 用户邮箱
	 * @param state 用户状态，1：正常状态；2:邮箱未认证；3:屏蔽状态
	 */
	public void updateClientState(String eamil,int state);
	
	
}
