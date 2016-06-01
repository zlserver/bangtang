package com.yysj.bangtang.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.bean.ClientExample;
import com.yysj.bangtang.bean.constant.EmailState;
import com.yysj.bangtang.mapper.ClientMapper;
import com.yysj.bangtang.service.ClientService;
import com.yysj.bangtang.utils.ServiceUtils;
@Service("clientService")
public class ClientServiceImpl implements ClientService {

	private ClientMapper clientMapper;
	public Client findByEmail(String email)throws Exception {
		
		return clientMapper.selectByPrimaryKey(email);
	}

	public Client login(String email, String password)throws Exception {
		// TODO Auto-generated method stub
		ClientExample example = new ClientExample();
		ClientExample.Criteria criteria= example.createCriteria();
		criteria.andEmailEqualTo(email);
		criteria.andPasswordEqualTo(ServiceUtils.MD5Encode(password));
		List<Client> list=clientMapper.selectByExample(example);
		if( list!=null&& list.size()==1)
			return list.get(0);
		return null;
	}

	public void registerByEmail(String email, String password)throws Exception {
		// TODO Auto-generated method stub
		//对密码进行加密
		String md5Ps= ServiceUtils.MD5Encode(password);
		Client client = new Client();
		client.setEmail(email);
		client.setPassword(md5Ps);
		client.setRegtime(new Date());
		//邮箱未激活
		client.setEmailstatus(EmailState.INACTIVE);
		clientMapper.insert(client);
		
	}

	public void updateClientState(String eamil, int state)throws Exception {
		// TODO Auto-generated method stub

	}

	public ClientMapper getClientMapper() {
		return clientMapper;
	}
	@Autowired
	public void setClientMapper(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}

}
