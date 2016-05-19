package com.yysj.bangtang.vo;

import com.yysj.bangtang.bean.Employee;
import com.yysj.bangtang.utils.ValidateUtil;

public class EmployeeVo extends BaseVo {
	
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	/**
	 * 校验账号和密码是否合理
	 * @return
	 */
	public boolean validateAccountAndPass(){
		//标识
		boolean flage = true;
		if(!ValidateUtil.validateLen(employee.getAccount(),3,20)||!ValidateUtil.validateLen(employee.getPassword(), 3, 20))
		{
			this.getError().put("error", "账号或密码有误!");//账号长度在3-20之间!
			flage = false;
		}
	
		return flage;
	}
}
