package com.yysj.bangtang.service;

import com.yysj.bangtang.bean.Employee;

/**
 * 员工服务类
 * @author liang
 * @version 创建时间 2016年4月20日
 * 说明:
 *
 */
public interface EmployeeService {

	/**
	 * 登陆
	 * @param account 账号
	 * @param password 密码
	 * @return
	 */
	public Employee login(String account,String password);
}
