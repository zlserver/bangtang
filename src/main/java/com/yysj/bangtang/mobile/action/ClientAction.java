package com.yysj.bangtang.mobile.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.service.ClientService;
import com.yysj.bangtang.utils.ServiceUtils;
import com.yysj.bangtang.utils.SiteUtils;
import com.yysj.bangtang.vo.ClientVo;
import com.yysj.bangtang.vo.MyJsonFactory;
import com.yysj.bangtang.vo.OperationStatus;

import net.sf.json.JSONObject;
@Controller
@RequestMapping(value="/mobile/client/*")
public class ClientAction {

	private ClientService clientService;
	
	/**
	 * 注册
	 * @param vo  接受参数，接受client.email 和client.password
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
		ClientVo vo = new ClientVo();
		ServiceUtils.copyBean(vo.getClient(),cl);
		JSONObject regJson=null;
		//校验用户注册信息
		if( vo.validateRegister()){
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
	 */
	public String login(String email,String password){
		
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
