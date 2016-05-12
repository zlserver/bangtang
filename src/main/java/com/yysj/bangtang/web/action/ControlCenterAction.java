package com.yysj.bangtang.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yysj.bangtang.utils.SiteUtils;

@Controller
@RequestMapping(value="/control/center/")
public class ControlCenterAction {

	/**
	 * 控制中心
	 * @return
	 */
	@RequestMapping(value="main")
	public String center(){
		
		return SiteUtils.getPage("admin.controlcenter");
	}
	@RequestMapping(value="top",method=RequestMethod.GET)
	public String top(){
		return SiteUtils.getPage("center.top");
	}
	@RequestMapping(value="left")
	public String left(){
		return SiteUtils.getPage("center.left");
	}
	@RequestMapping(value="content")
	public String content(){
		return SiteUtils.getPage("center.content");
	}
	
}
