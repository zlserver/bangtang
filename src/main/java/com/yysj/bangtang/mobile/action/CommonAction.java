package com.yysj.bangtang.mobile.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.bean.base.DateJsonValueProcessor;
import com.yysj.bangtang.mobile.ClientJson;
import com.yysj.bangtang.mobile.MyStatus;
import com.yysj.bangtang.myenum.OperationStatus;
import com.yysj.bangtang.service.ClientService;
import com.yysj.bangtang.utils.Log;
import com.yysj.bangtang.utils.SiteUtils;
import com.yysj.bangtang.utils.TokenGenerator;
import com.yysj.bangtang.utils.ValidateUtil;
import com.yysj.bangtang.vo.ClientVo;
import com.yysj.bangtang.vo.MyJsonFactory;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller

@RequestMapping(value="/mobile/common/*")
public class CommonAction {
	
	private ClientService clientService;
	
	/**
	 * 注册
	 * @param vo  接受参数，接受email 和password
	 * @param model 存放返回给页面端的内容
	 * @return json类型字符串，如果成功status为1，否则失败
	 * {
	 *   "status":1   
	 *   "message":"操作成功"
	 * }
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public @ResponseBody MyStatus register(Client cl,Model model){
		MyStatus status = new MyStatus();
		ClientVo vo = new ClientVo();
		vo.setClient(cl);
		//校验用户注册信息
		if( vo.validateEmailAndPas()){
			try{
				//邮箱是否存在
				Client client =clientService.findByEmail(vo.getClient().getEmail());
				if( client==null){
					//保存用户
					clientService.registerByEmail(vo.getClient().getEmail(), vo.getClient().getPassword());
					status.setOperationStatus(OperationStatus.SUCCESS);
				}else{
					status.setOperationStatus(OperationStatus.CLIENT_EMAIL_EXIST);
				}
			}catch(Exception e){
				//抛出未知异常
				status.setOperationStatus(OperationStatus.UNKNOW_EXCEPTION);
				Log.error(this,"注册出现异常："+ e.getMessage());
			}
		}else{
			status.setOperationStatus(OperationStatus.CLIENT_EMAIL_PASS_ERROR);
		}
		return status;
	}
	/**
	 * 登录
	 * @param email 邮箱
	 * @param password 密码
	 * @return
	 * {
	 *   "status":1   
	 *   "message":"操作成功"
	 * }
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody ClientJson login(String email,String password,Model model,HttpServletRequest request) {
		ClientJson clientJson=new ClientJson();
		//校验
		if( ValidateUtil.validateEmail(email)&& ValidateUtil.validatePassword(password)){
			try{
				Client cl= clientService.login(email, password);
				if( cl!=null){
					//生成token
					String token = TokenGenerator.generatorToken(cl.getEmail());
					cl.setToken(token);
					
					//更新token
					int res=clientService.updateClientToken(email, token);
					if( res!=1)
						Log.error(this, email+"登录时，token值更新失败!");
					clientJson.setOperationStatus(OperationStatus.SUCCESS);
					clientJson.setClient(cl);
					return clientJson;
				}
			}catch(Exception e){
				clientJson.setOperationStatus(OperationStatus.UNKNOW_EXCEPTION);
				Log.error(this,"注册出现异常："+ e.getMessage());
			}
		}else{
			clientJson.setOperationStatus(OperationStatus.CLIENT_EMAIL_PASS_ERROR);
		}
		return clientJson;
	}
	public ClientService getClientService() {
		return clientService;
	}
	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
}
