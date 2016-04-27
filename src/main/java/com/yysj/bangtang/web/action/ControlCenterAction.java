package com.yysj.bangtang.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yysj.bangtang.utils.SiteUtils;

@Controller
@RequestMapping(value="/control/center/")
public class ControlCenterAction {

	@RequestMapping(value="top",method=RequestMethod.GET)
	public String top(){
		return SiteUtils.getSite("center.top");
	}
	@RequestMapping(value="left")
	public String left(){
		return SiteUtils.getSite("center.left");
	}
	@RequestMapping(value="content")
	public String content(){
		return SiteUtils.getSite("center.content");
	}
	
}
