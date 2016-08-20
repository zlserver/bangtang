package com.yysj.bangtang.mobile.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.bean.Content;
import com.yysj.bangtang.file.FileHandler;
import com.yysj.bangtang.file.FilePath;
import com.yysj.bangtang.mobile.ContentJson;
import com.yysj.bangtang.mobile.MyStatus;
import com.yysj.bangtang.myenum.OperationStatus;
import com.yysj.bangtang.redis.RContent;
import com.yysj.bangtang.service.ContentService;
import com.yysj.bangtang.utils.ServiceUtils;
import com.yysj.bangtang.utils.TokenGenerator;
import com.yysj.bangtang.utils.ValidateUtil;
import com.yysj.bangtang.vo.ContentVo;

@Controller
@RequestMapping(value="/mobile/content/*")
public class ContentAction {
	/**
	 * 文件保存路径读取接口
	 */
	private FilePath filePath ;
	private FileHandler fileHandler;
	
	private ContentService contentService;
	
	private ContentVo copytoContent(MultipartHttpServletRequest request){
		String text =(String) request.getParameter("text");
		String token =request.getParameter("token");  
		String email =TokenGenerator.getEmail(token);
		String ip =request.getRemoteHost();
		List<MultipartFile> files =request.getFiles("pics");
		Client client =(Client) request.getAttribute("client");
		return new ContentVo(text, email, ip,files,client);
	}
	/**
	 * 上传图片动态
	 */
	@RequestMapping(value="publishpic",method=RequestMethod.POST)
	public @ResponseBody MyStatus publishPic(MultipartHttpServletRequest request){
		
		MyStatus status = new MyStatus();
		ContentVo contentVo = copytoContent(request);
		try {
			int result =contentService.publish(contentVo);
			if( result ==0)
			  status.setOperationStatus(OperationStatus.IMAGE_TYPE_ERROR);
			if(result ==-1)
				status.setOperationStatus(OperationStatus.IMAGE_COUNT_OUTLIMIT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status.setOperationStatus(OperationStatus.UNKNOW_EXCEPTION);
		}
		return status;
	}
	
	@RequestMapping(value="getContent",method=RequestMethod.GET)
	public @ResponseBody ContentJson getContent(String id){
		ContentJson contentJson =new ContentJson();
		 RContent rc =null;
		if( ValidateUtil.isValidateStr(id)){
			rc =contentService.getBykey(id);
			if( rc!=null){
				List<RContent> list = new ArrayList<RContent>();
				list.add(rc);
				contentJson.setListContent(list);
			}
		}else
			contentJson.setOperationStatus(OperationStatus.PARAM_ERROR);
		
		return contentJson;
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

	public ContentService getContentService() {
		return contentService;
	}
	@Autowired
	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

}
