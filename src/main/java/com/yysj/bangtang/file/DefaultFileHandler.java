package com.yysj.bangtang.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yysj.bangtang.utils.ServiceUtils;

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
		if( !dir.exists() )
			dir.mkdirs();

		String origname = file.getName();
		String ext =ServiceUtils.getExt(origname);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhMMss");
		String name = sdf.format(new Date())+"."+ext;
		File dest = new File(dir,relativePath+name);
		file.transferTo(dest);
		long size = file.getSize();
		
		FileEntity fe = new FileEntity(name, size, ext, relativePath+name, file.getContentType());
		
		return fe;
	}
}
