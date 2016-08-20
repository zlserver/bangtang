package com.yysj.bangtang.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yysj.bangtang.bean.Content;
import com.yysj.bangtang.file.FileEntity;
import com.yysj.bangtang.file.FileHandler;
import com.yysj.bangtang.file.FilePath;
import com.yysj.bangtang.mapper.ContentMapper;
import com.yysj.bangtang.myenum.ContentStateEnum;
import com.yysj.bangtang.redis.PublishContentThread;
import com.yysj.bangtang.redis.RContent;
import com.yysj.bangtang.redis.RContentDao;
import com.yysj.bangtang.service.ContentService;
import com.yysj.bangtang.task.ImageSizerTask;
import com.yysj.bangtang.utils.Config;
import com.yysj.bangtang.utils.ImageSizer;
import com.yysj.bangtang.utils.ServiceUtils;
import com.yysj.bangtang.utils.ValidateUtil;
import com.yysj.bangtang.vo.ContentVo;

@Service("contentService")
public class ContentServiceImpl implements ContentService {
	private ContentMapper contentMapper;
	//线程池
	private ThreadPoolTaskExecutor taskExecutor;
	
	private RContentDao rContentDao;
	
	/**
	 * 文件保存路径读取接口
	 */
	private FilePath filePath ;
	private FileHandler fileHandler;
	
	public int publish(Content content) {
		if( content!=null)
			return contentMapper.insert(content);
		return 0;
	}


	public RContent getBykey(String id) {
		Content cont =null;
		if( ValidateUtil.isValidateStr(id)){
			//先去redis中查询
			RContent rc =rContentDao.getByKey(id);
			if(rc !=null){
				return rc;
			}
		 return contentMapper.selectByPrimaryKey(id);
		}
		
		return null;
	}
	public ContentMapper getContentMapper() {
		return contentMapper;
	}
	@Autowired
	public void setContentMapper(ContentMapper contentMapper) {
		this.contentMapper = contentMapper;
	}

	public Page<Content> getScrollByEmail(String email, int pageNumber, int pageSize) {
		PageHelper.startPage(pageNumber,pageSize);  
		List<Content> list =contentMapper.selectByEmail(email);
		
	    return (Page)list;
	}

	public Page<Content> getScrollByState(ContentStateEnum state, int pageNumber, int pageSize) {
		PageHelper.startPage(pageNumber,pageSize);  
		List<Content> list =contentMapper.selectByState(state);
		
	    return (Page)list;
	}

	public int publish(ContentVo contentVo) {
		
		List<MultipartFile> pics= contentVo.getFiles();
		String email = contentVo.getEmail();
		String ip = contentVo.getIp();
		String text = contentVo.getText();
				
		
		//被保存的图片信息
		List<FileEntity> listFile=null;
		
		//如果有图片则保持图片
		if(pics!=null && pics.size()>0){
			//上传内容保存路径
			String relativePath = filePath.getPath(FilePath.CONTENT_PIC);
			//相对路径目录下在加上当前时间目录
			String datapath=ServiceUtils.getDateFileDir(null);
			int limitcount = Integer.parseInt(Config.getKey(Config.CONTENTPIC_COUNTLIMIT));
			if( pics.size()>limitcount)
				return -1;
			try {
				if(ValidateUtil.isImage(pics)){
					String savepath=relativePath+datapath+"/";
					//保存图片
					listFile= fileHandler.save(savepath, pics);
					//保存压缩图片
					for(FileEntity fe : listFile){
						String abPath=fe.getFile().getAbsolutePath();
						//压缩文件保存路径
						abPath=abPath.substring(0, abPath.lastIndexOf("\\"));
						String resizedir=abPath+"/compress";
						File dir = new File(resizedir);
						if( !dir.exists())
							dir.mkdirs();
						File resizedFile= new File(dir, fe.getName());
						String width = Config.getKey(Config.CONTENTPIC_COMPRESSWIDTH);
						int wid = Integer.parseInt(width);
						//开启线程执行
						taskExecutor.execute(new ImageSizerTask(fe.getFile(), resizedFile, wid, fe.getExt()));
						//	ImageSizer.resize(fe.getFile(), resizedFile, wid, fe.getExt());
					}
				}else{
					return 0;//上传图片动态中包含非图片文件
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Content content = new Content();
		content.setEmail(email);
		content.setIp(ip);
		content.setText(text);
		if( listFile!=null)
		  content.setPicSavePath(getSavePath(listFile));
		publish(content);
		
		//保存到redis中
		RContent rc = new RContent(content,contentVo.getClient());
		taskExecutor.execute(new PublishContentThread(rc, rContentDao));
		
		return 1;
	}
	/**
	 *得到保存路径
	 * @param list
	 */
	private String getSavePath(List<FileEntity> list) {
		// TODO Auto-generated method stub
		
		if( list.size()>0){
			FileEntity fe=list.get(0);
			String repath=fe.getRelativePath();
			String prefix=repath.substring(0,repath.lastIndexOf("/"));
			StringBuffer sb = new StringBuffer();
			sb.append(prefix);
			for(FileEntity fee : list){
				String name=fee.getName();
				sb.append(",").append(name);
			}
			return sb.toString();
		}
		return null;
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
	public ThreadPoolTaskExecutor getTaskExecutor() {
		return taskExecutor;
	}
	@Autowired
	public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public RContentDao getrContentDao() {
		return rContentDao;
	}
	@Autowired
	public void setrContentDao(RContentDao rContentDao) {
		this.rContentDao = rContentDao;
	}

	public Content getById(String id) {
		return null;
	}
	
}
