package com.yysj.bangtang.mapper;

import com.yysj.bangtang.bean.Employee;

public interface EmployeeMapper {

	/**
	 * 根据账号查询员工
	 * @param account
	 * @return
	 */
	public Employee findByAccount(String account);
	
	/**
	 * 更新员工状态
	 * @param employee
	 */
	public void updateState(Employee employee );
	/**
	 * 插入新的员工
	 * @param employee
	 */
	public void insertEmployee(Employee employee);
}
