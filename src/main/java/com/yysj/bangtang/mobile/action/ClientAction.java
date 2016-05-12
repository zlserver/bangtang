package com.yysj.bangtang.mobile.action;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.service.ClientService;
import com.yysj.bangtang.utils.SiteUtils;
import com.yysj.bangtang.vo.ClientVo;
import com.yysj.bangtang.vo.MyJsonFactory;
import com.yysj.bangtang.vo.OperationStatus;

import net.sf.json.JSONObject;
@RequestMapping(value="/mobile/client/*")
public class ClientAction {

	private ClientService clientService;
	/**
	 * 
	 * @param vo，提供邮箱和密码
	 * @return
	 * {
	 *   "status":1   
	 *   
	 * }
	 */
	@RequestMapping(value="register")
	public String register(ClientVo vo,Model model) throws Exception{
		
		JSONObject regJson=null;
		//校验用户注册信息
		if( vo.validateRegister()){
			//邮箱是否存在
			Client client =clientService.findByEmail(vo.getClient().getEmail());
			if( client!=null){
				//保存用户
				clientService.registerByEmail(vo.getClient().getEmail(), vo.getClient().getPassword());
				regJson=MyJsonFactory.generator(OperationStatus.SUCCESS);
			}else{
				regJson=MyJsonFactory.generator(OperationStatus.CLIENT_EMAIL_EXIST);
			}
		}else{
			regJson=MyJsonFactory.generator(OperationStatus.PARAM_ERROR);
		}
		model.addAttribute("json", regJson);
		return SiteUtils.getPage("json");
	}
	public ClientService getClientService() {
		return clientService;
	}
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	
}
