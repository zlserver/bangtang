package com.yysj.bangtang.mobile.action;
import java.io.File;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.file.DefaultFileHandler;
import com.yysj.bangtang.file.FileEntity;
import com.yysj.bangtang.file.FileHandler;
import com.yysj.bangtang.file.FilePath;
import com.yysj.bangtang.file.FileXmlParser;
import com.yysj.bangtang.mobile.ClientJson;
import com.yysj.bangtang.mobile.MyStatus;
import com.yysj.bangtang.myenum.OperationStatus;
import com.yysj.bangtang.service.ClientService;
import com.yysj.bangtang.utils.Log;
import com.yysj.bangtang.utils.TokenGenerator;
@Controller
@RequestMapping(value="/mobile/client/*")
public class ClientAction {
	
	
	private ClientService clientService;
	@RequestMapping(value="editPic",method=RequestMethod.POST)  
	public @ResponseBody ClientJson editPic(@RequestParam("logo")CommonsMultipartFile logo,HttpServletRequest request){
		ClientJson cljson= new ClientJson();
		String token =request.getParameter("token");  
		String email =TokenGenerator.getEmail(token);
		Client client =clientService.findByEmail(email);
		//头像保存路径
		FilePath filePath = new FileXmlParser();
		String dirpath = filePath.getPath(FilePath.FILE_ROOT);
		File dir = new  File(dirpath);
		String relativePath = filePath.getPath(FilePath.USER_PIC);
		try {
		    FileHandler fileHandler=new DefaultFileHandler();
		    System.out.println(dir+":"+relativePath);
			FileEntity fe = fileHandler.save(dir, relativePath, logo);
			client.setPicpath(fe.getRelativePath());
			clientService.updateClient(client);
			cljson.setClient(client);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(this, "修改用户头像失败"+e);
			cljson.setOperationStatus(OperationStatus.CLIENT_EDIT_PIC_ERROR);
		}
		
		return cljson;
	}
	
	public ClientService getClientService() {
		return clientService;
	}
	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	
	
}
