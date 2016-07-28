package com.yysj.bangtang.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yysj.bangtang.utils.ServiceUtils;
import com.yysj.bangtang.utils.ValidateUtil;

@Service("fileHandler")
public class DefaultFileHandler implements FileHandler{
	/**
	 * 保存文件
	 * @param dir 文件根目录，如：D:/dir/filesystem/ .最终文件保存的绝对路径为：dir+relavivepath
	 * @param relativePath 相对于系统工程的目录,如： images/login/
	 * @param file 文件
	 * @return
	 * @throws Exception
	 */
	public FileEntity save(File dir, String relativePath,CommonsMultipartFile file) throws Exception {
		
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
		String ext =ServiceUtils.getExt(origname);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhMMss");
		String name = sdf.format(new Date())+"."+ext;
		File dest = new File(diretParent,name);
		file.transferTo(dest);
		long size = file.getSize();
		FileEntity fe = new FileEntity(name, size, ext, relativePath+name, file.getContentType());
		
		return fe;
	}
}
