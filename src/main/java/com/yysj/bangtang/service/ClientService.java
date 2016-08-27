package com.yysj.bangtang.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.common.QueryEntity;
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
	/**
	 * 根据激活码查找用户
	 * @param activeCode
	 * @return
	 */
	public Client findByActiveCode(String activeCode);
	/**
	 * 根据重置码查找用户
	 * @param resetCode
	 * @return
	 */
	public Client findByResetCode(String resetCode);
	/**
	 * 发送重置密码的邮箱通知
	 * @param email
	 */
	/**
	 * 发送重置密码的邮箱通知
	 * @param email  要通知的邮箱
	 * @return 返回值1：发送成功-1：邮箱不存在
	 */
	public int sendResetPassLink(String email);
	/**
	 * 重置密码
	 * @param resetCode 重置码
	 * @param password 新密码
	 * @return
	 * 1：重置成功
	 * 0：重置码无效
	 * -1：密码不满足要求
	 */
	public int resetPassword(String resetCode, String password);
	/**
	 * 分页查询
	 * @param queryEntitys 查询条件
	 * @param pageNumber 页码
	 * @param pageSize 每页最多值
	 * @return
	 */
	public Page<Client> getScrollData(List<QueryEntity> queryEntitys, int pageNumber, int pageSize);
		
}
