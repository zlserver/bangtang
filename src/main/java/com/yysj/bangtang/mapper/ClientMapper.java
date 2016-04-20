package com.yysj.bangtang.mapper;

import com.yysj.bangtang.bean.Client;

public interface ClientMapper {

	/**
	 * 根据邮箱查询用户
	 * @param email
	 * @return
	 */
	public Client findByEmail(String email);
	/**
	 * 更新用户
	 * @param client
	 */
	public void updateClient(Client client);
}
