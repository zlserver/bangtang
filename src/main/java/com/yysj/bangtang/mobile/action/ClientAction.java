package com.yysj.bangtang.mobile.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.bean.base.DateJsonValueProcessor;
import com.yysj.bangtang.service.ClientService;
import com.yysj.bangtang.utils.ServiceUtils;
import com.yysj.bangtang.utils.SiteUtils;
import com.yysj.bangtang.utils.ValidateUtil;
import com.yysj.bangtang.vo.ClientVo;
import com.yysj.bangtang.vo.MyJsonFactory;
import com.yysj.bangtang.vo.OperationStatus;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
@Controller
@RequestMapping(value="/mobile/client/*")
public class ClientAction {
	
	private ClientService clientService;
	
	public String editPic(){
		
		return "";
	}
	/**
	 * 注册
	 * @param vo  接受参数，接受email 和password
	 * @param model 存放返回给页面端的内容
	 * @return json类型字符串，如果成功status为1，否则失败
	 * {
	 *   "status":1   
	 *   
	 * }
	 * @throws Exception
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(Client cl,Model model) throws Exception{

		JSONObject regJson=null;
		
		ClientVo vo = new ClientVo();
		vo.setClient(cl);
		//校验用户注册信息
		if( vo.validateEmailAndPas()){
			//邮箱是否存在
			Client client =clientService.findByEmail(vo.getClient().getEmail());
			if( client==null){
				//保存用户
				clientService.registerByEmail(vo.getClient().getEmail(), vo.getClient().getPassword());
				regJson=MyJsonFactory.generator(OperationStatus.SUCCESS);
			}else{
				regJson=MyJsonFactory.generator(OperationStatus.CLIENT_EMAIL_EXIST);
			}
		}else{
			regJson=MyJsonFactory.generator(OperationStatus.CLIENT_EMAIL_PASS_ERROR);
		}
		model.addAttribute("json", regJson);
		return SiteUtils.getPage("json");
	}
	/**
	 * 登录
	 * @param email 邮箱
	 * @param password 密码
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(String email,String password,Model model) throws Exception{
		JSONObject logJson=null;
		//校验
		if( ValidateUtil.validateEmail(email)&& ValidateUtil.validatePassword(password)){
			Client cl= clientService.login(email, password);
			if( cl!=null){
				JsonConfig config=new JsonConfig();
				config.registerJsonValueProcessor(Date.class,new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
				logJson=MyJsonFactory.generator(OperationStatus.SUCCESS,cl,config);
				model.addAttribute("json", logJson);
				return SiteUtils.getPage("json");
			}
		}
		logJson=MyJsonFactory.generator(OperationStatus.CLIENT_EMAIL_PASS_ERROR);
		model.addAttribute("json", logJson);
		return SiteUtils.getPage("json");
	}
	
	public ClientService getClientService() {
		return clientService;
	}
	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	
}
