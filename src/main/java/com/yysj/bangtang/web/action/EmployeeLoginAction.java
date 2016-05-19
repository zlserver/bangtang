package com.yysj.bangtang.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yysj.bangtang.bean.Employee;
import com.yysj.bangtang.service.EmployeeService;
import com.yysj.bangtang.utils.SiteUtils;
import com.yysj.bangtang.vo.EmployeeVo;

@Controller
@RequestMapping(value="/common/admin/*")
public class EmployeeLoginAction {
	private EmployeeService employeeService;
	@RequestMapping(value="loginUi")
	public String loginUi(){
		return SiteUtils.getPage("admin.login");
	}
	@RequestMapping(value="login")
	public String login(EmployeeVo vo, HttpServletRequest request){
		// 1.进行校验码验证、进行用户名密码校验
		if (vo!=null && vo.validateAccountAndPass()) {
			// 2.根据用户名和密码登录
			String ac = vo.getEmployee().getAccount();
			String pa = vo.getEmployee().getPassword();
			Employee em = employeeService.login(ac, pa);
			if (em != null) {
				// 4.登录成功
				request.getSession().setAttribute("employee", em);
				return "redirect:/control/center/main.action";
			
			}
			// 3.用户名或者密码有误
			vo.getError().put("account", "用户名或者密码有误!");
		}
		// 登录出错返回
		request.setAttribute("vo", vo);
		return SiteUtils.getPage("admin.login");
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
