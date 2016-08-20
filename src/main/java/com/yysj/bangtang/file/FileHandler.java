package com.yysj.bangtang.file;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface FileHandler {
	
	/**
	 * 保存文件
	 * @param dir 文件根目录，如：D:/dir/filesystem/ .最终文件保存的绝对路径为：dir+relavivepath
	 * @param relativePath 相对于系统工程的目录,如： images/login/
	 * @param file 文件
	 * @return
	 * @throws Exception
	 */
	public FileEntity save(File dir,String relativePath, MultipartFile file) throws Exception ;
	
	/**
	 * 保存文件
	 * @param relativePath 相对于系统工程的目录,如： images/login/
	 * @param file 文件
	 * @return
	 * @throws Exception
	 */
	public FileEntity save(String relativePath, MultipartFile file) throws Exception ;
	
	/**
	 * 多文件上传保存文件
	 * @param dir 文件根目录，如：D:/dir/filesystem/ .最终文件保存的绝对路径为：dir+relavivepath
	 * @param relativePath 相对于系统工程的目录,如： images/login/
	 * @param files  多文件
	 * @return
	 * @throws Exception
	 */
	public List<FileEntity> save(File dir,String relativePath, List<MultipartFile> files) throws Exception ;
	/**
	 * 多文件上传保存文件
	 * @param relativePath 相对于系统工程的目录,如： images/login/
	 * @param files  多文件
	 * @return
	 * @throws Exception
	 */
	public List<FileEntity> save(String relativePath,List<MultipartFile> files) throws Exception ;
	
}
