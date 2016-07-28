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
import com.yysj.bangtang.utils.ValidateUtil;
@Controller
@RequestMapping(value="/mobile/client/*")
public class ClientAction {
	
	/**
	 * 文件保存路径读取接口
	 */
	private FilePath filePath ;
	/**
	 * 文件处理接口
	 */
	private FileHandler fileHandler;
	/**
	 * 用户操作接口
	 */
	private ClientService clientService;
	/**
	 * 编辑用户头像
	 * @param logo 头像图片
	 * @param request 请求
	 * @return
	 */
	@RequestMapping(value="editPic",method=RequestMethod.POST)  
	public @ResponseBody ClientJson editPic(@RequestParam("logo")CommonsMultipartFile logo,HttpServletRequest request){
		ClientJson cljson= new ClientJson();
		String token =request.getParameter("token");  
		String email =TokenGenerator.getEmail(token);
		Client client =clientService.findByEmail(email);
		
		//校验图片格式
		if(ValidateUtil.isImage(logo)){
			//头像保存路径
			String dirpath = filePath.getPath(FilePath.FILE_ROOT);
			File dir = new  File(dirpath);
			String relativePath = filePath.getPath(FilePath.USER_PIC);
			try {
				
				FileEntity fe = fileHandler.save(dir, relativePath, logo);
				client.setPicpath(fe.getRelativePath());
				clientService.updateClient(client);
				cljson.setClient(client);
			} catch (Exception e) {
				e.printStackTrace();
				Log.error(this, "修改用户头像失败"+e);
				cljson.setOperationStatus(OperationStatus.CLIENT_EDIT_PIC_ERROR);
			}
		}else{
			cljson.setOperationStatus(OperationStatus.IMAGE_TYPE_ERROR);
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
	public FilePath getFilePath() {
		return filePath;
	}
	@Autowired
	public void setFilePath(FilePath filePath) {
		this.filePath = filePath;
	}
	public FileHandler getFileHandler() {
		return fileHandler;
	}
	@Autowired
	public void setFileHandler(FileHandler fileHandler) {
		this.fileHandler = fileHandler;
	}
	
	
}
