package com.yysj.bangtang.vo;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.utils.ValidateUtil;

public class ClientVo {

	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	/**
	 * 注册校验
	 * 邮箱符合格式
	 * 密码6-15非空字符
	 */
	public boolean validateRegister(){
		
		if( client!=null){
			//邮箱
			if(ValidateUtil.validateEmail(client.getEmail())){
				//密码,6-15非空字符
				if(ValidateUtil.validateLen(client.getPassword(),6,15)){
					return true;
				}
			}
		}
		
		return false;
	}
}
