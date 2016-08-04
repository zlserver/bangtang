package com.yysj.bangtang.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yysj.bangtang.utils.ServiceUtils;
import com.yysj.bangtang.utils.ValidateUtil;

@Service("fileHandler")
public class DefaultFileHandler implements FileHandler{

	/**
	 * 文件保存路径读取接口
	 */
	private FilePath filePath ;
	/**
	 * 保存文件
	 * @param dir 文件根目录，如：D:/dir/filesystem/ .最终文件保存的绝对路径为：dir+relavivepath
	 * @param relativePath 相对于系统工程的目录,如： images/login/
	 * @param file 文件
	 * @return
	 * @throws Exception
	 */
	public FileEntity save(File dir, String relativePath,MultipartFile file) throws Exception {
		
		if( file==null || file.getSize()<=0){
			throw new RuntimeException("上传文件为null");
		}
		if( dir ==null)
			throw new RuntimeException("文件根目录不存在!");
		if( !ValidateUtil.isValidateStr(relativePath))
			throw new RuntimeException("文件相对目录不存在,请查看配置文件");
		
		if( !dir.exists() )
			dir.mkdirs();
		File diretParent = new File(dir, relativePath);
		if(!diretParent.exists())
			diretParent.mkdirs();
		String origname = file.getOriginalFilename();
		String ext =ServiceUtils.getExtFromFileName(origname);
		
		String name =  ServiceUtils.getDateFileName(null)+"."+ext;
		File dest = new File(diretParent,name);
		file.transferTo(dest);
		long size = file.getSize();
		FileEntity fe = new FileEntity(name, size, ext, relativePath+name, file.getContentType(),dest);
		
		return fe;
	}

	public List<FileEntity> save(File dir, String relativePath, List<MultipartFile> files) throws Exception {
		List<FileEntity> list =new ArrayList<FileEntity>();
		if( files!=null &&files.size()>0)
		for(int i = 0;i<files.size();i++){  
			list.add(save(dir, relativePath, files.get(i)));
        }  
		return list;
	}

	public FileEntity save(String relativePath, MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		//头像保存路径
		String dirpath = filePath.getPath(FilePath.FILE_ROOT);
		File dir = new  File(dirpath);
		return save(dir, relativePath, file);
	}

	public FilePath getFilePath() {
		return filePath;
	}
	@Autowired
	public void setFilePath(FilePath filePath) {
		this.filePath = filePath;
	}

	public List<FileEntity> save(String relativePath, List<MultipartFile> files) throws Exception {
		List<FileEntity> list =new ArrayList<FileEntity>();
		if( files!=null &&files.size()>0)
		for(int i = 0;i<files.size();i++){  
			list.add(save(relativePath, files.get(i)));
        }  
		return list;
	}
		
	public void save(FileEntity fe,MultipartFile file) throws Exception {
		file.transferTo(fe.getFile());
	}

}
