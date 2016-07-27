package com.yysj.bangtang.service;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.bean.custom.ClientCustom;
import com.yysj.bangtang.myenum.EmailStateEnum;

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
	public Client login(String email,String password)throws Exception;
	/**
	 * 注册用户
	 * @param email 邮箱
	 * @param password 密码
	 * @return
	 */
	public void registerByEmail(String email,String password)throws Exception;
	
	/**
	 * 
	 * 更改用户的状态
	 * @param eamil 用户邮箱
	 * @param state 用户状态，1：正常状态；2:邮箱未认证；3:屏蔽状态
	 * @return 返回受影响的数据条数
	 * @throws Exception
	 */
	public int updateClientState(String email,EmailStateEnum state)throws Exception;
	
	/**
	 * 更新用户token值
	 * @param email 邮箱
	 * @param token token值
	 * @return 返回受影响的数据条数
	 * @throws Exception
	 */
	public int updateClientToken(String email,String token)throws Exception;
	
	/**
	 * 更新用户
	 * @param client
	 */
	public void updateClient(Client client);
}
