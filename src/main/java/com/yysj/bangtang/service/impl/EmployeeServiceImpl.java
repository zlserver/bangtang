package com.yysj.bangtang.service.impl;

import javax.annotation.Resource;
import javax.print.ServiceUI;

import org.springframework.stereotype.Service;

import com.yysj.bangtang.bean.Employee;
import com.yysj.bangtang.mapper.EmployeeMapper;
import com.yysj.bangtang.service.EmployeeService;
import com.yysj.bangtang.utils.ServiceUtils;
import com.yysj.bangtang.utils.ValidateUtil;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeMapper employeeMapper ;
	
	public Employee login(String account, String password) {
		if(ValidateUtil.validateLen(account, 3,20)){
			Employee em= employeeMapper.findByAccount(account);
			if( em!=null){
				if( em.getPassword().equals(password))
					return em;
			}
		}
		return null;
	}

	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper;
	}
	@Resource
	public void setEmployeeMapper(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}

}
