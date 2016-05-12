package com.yysj.bangtang.vo;

import com.yysj.bangtang.bean.Client;

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
			String reg = "\\w+@[a-z]+(\\.[a-z]{2,3}){1,2}";
			//邮箱
			if(BaseVo.validateStr(client.getEmail())&& client.getEmail().matches(reg)){
				//密码,6-15非空字符
				String pas="[^\\s]{6,15}";
				if(BaseVo.validateStr(client.getPassword())&& client.getPassword().matches(pas)){
					return true;
				}
			}
		}
		
		return false;
	}
}
