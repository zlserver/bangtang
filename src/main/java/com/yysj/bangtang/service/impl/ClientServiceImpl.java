package com.yysj.bangtang.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.bean.ClientExample;
import com.yysj.bangtang.mapper.ClientMapper;
import com.yysj.bangtang.myenum.EmailStateEnum;
import com.yysj.bangtang.service.ClientService;
import com.yysj.bangtang.task.EmailTask;
import com.yysj.bangtang.task.EmailService;
import com.yysj.bangtang.utils.ServiceUtils;
import com.yysj.bangtang.utils.ValidateUtil;
@Service("clientService")
//@Transactional  运用事务
public class ClientServiceImpl  implements ClientService {

	private ClientMapper clientMapper;
	public Client findByEmail(String email){
		if( ValidateUtil.validateEmail(email))
			return clientMapper.selectByPrimaryKey(email);
		return null;
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
		//设置激活有效期7天
		long currentmills= new Date().getTime();
		//七天
		long seventmills = 1000*60*60*24*7;
		Date activelasttime = new Date(currentmills+seventmills);
		client.setActivelasttime(activelasttime);
		//邮箱未激活
		client.setEmailstatus(EmailStateEnum.INACTIVE.ordinal());
		//设置激活码
		String activeCode =ServiceUtils.getUuid();
		client.setActivecode(activeCode);
		clientMapper.insert(client);
		
		//发送激活邮箱通知
		//1.通知内容
		StringBuffer sendContent =new StringBuffer();
		String activeUrl="http://localhost:8080/bangtang/mobile/common/activeEmail/"+activeCode+".action"; 
		sendContent.append("<h3>点击以下链接激活邮箱:</h3> <a href=\"")
		.append(activeUrl).append("\">").append(activeUrl).append("</a>");
		//2.添加到发送任务队列中
		EmailTask task = new EmailTask(EmailTask.TaskPriority.PRIORITY_NORMAL, email, sendContent.toString(),"eyemember邮箱验证");
		EmailService.addTask(task);
	}

	public int updateClientState(String email, EmailStateEnum state)throws Exception {
		// TODO Auto-generated method stub

		Client cl= clientMapper.selectByPrimaryKey(email);
		cl.setEmailstatus(state.ordinal());
		clientMapper.updateByPrimaryKey(cl);
		return 1;
	}

	public int updateClientToken(String email, String token) throws Exception {
		// TODO Auto-generated method stub
		if(ValidateUtil.validateEmail(email)){
			Client cl= clientMapper.selectByPrimaryKey(email);
			if( !ValidateUtil.isContainEmptyStr(token)){
				cl.setToken(token);
				clientMapper.updateByPrimaryKey(cl);
				return 1;
			}
		}
		return 0;
	}
	
	public ClientMapper getClientMapper() {
		return clientMapper;
	}
	@Autowired
	public void setClientMapper(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}

	public void updateClient(Client client) {
		// TODO Auto-generated method stub
		if(client !=null && ValidateUtil.validateEmail(client.getEmail()))
			clientMapper.updateByPrimaryKey(client);
		else
			throw new RuntimeException("用户不能为空");
	}

	public Client findByActiveCode(String activeCode) {
		if( ValidateUtil.isValidateStr(activeCode)){
			ClientExample example = new ClientExample();
			ClientExample.Criteria criteria= example.createCriteria();
			criteria.andActivecodeEqualTo(activeCode);
			List<Client> list= clientMapper.selectByExample(example);
			if( list!=null &&list.size()==1)
				return list.get(0);
		}
		return null;
	}
	/**
	 * 发送重置密码的邮箱通知
	 */
	public int sendResetPassLink(String email) {
			//生成重置码
			String resetCode =ServiceUtils.getUuid();
			Client client =findByEmail(email);
			if(client==null)
				return -1; 
			//设置重置码
			client.setResetcode(resetCode);
			updateClient(client);
			//发送重置密码的邮箱通知
			StringBuffer sendContent =new StringBuffer();
			String resetUrl="http://localhost:8080/bangtang/mobile/common/resetPasswordUI/"+resetCode+".action"; 
			sendContent.append("<h3>点击以下链接重置密码:</h3> <a href=\"")
			.append(resetUrl).append("\">").append(resetUrl).append("</a>");
			
			EmailTask task = new EmailTask(EmailTask.TaskPriority.PRIORITY_HIGH, email, sendContent.toString(),"eyemember找回密码");
			EmailService.addTask(task);
			return 1;
		
	}

	public int resetPassword(String resetCode, String password) {
		
		if( !ValidateUtil.isValidateStr(resetCode))
			return 0;
		if( !ValidateUtil.validatePassword(password))
			return -1;
		Client client =findByResetCode(resetCode);
		if( client ==null )
			return 0;
		String md5Ps= ServiceUtils.MD5Encode(password);
		//设置密码
		client.setPassword(md5Ps);
		//清空重置码
		client.setResetcode(null);      
		//保存
		updateClient(client);
		return 1;
	}

	public Client findByResetCode(String resetCode) {
		if( ValidateUtil.isValidateStr(resetCode)){
			ClientExample example = new ClientExample();
			ClientExample.Criteria criteria= example.createCriteria();
			criteria.andResetcodeEqualTo(resetCode);
			List<Client> list= clientMapper.selectByExample(example);
			if( list!=null &&list.size()==1)
				return list.get(0);
		}
		return null;
	}
}
