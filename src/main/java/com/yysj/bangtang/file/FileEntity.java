package com.yysj.bangtang.file;

import java.io.File;

public class FileEntity {
	/**
	 * 文件名
	 */
	private String name;
	/**
	 * 文件大小
	 */
	private long size;
	/**
	 * 后缀名
	 */
	private String ext;
	
	/**
	 * 保存路径,相对于工程目录的路径,包含文件名，如： images/login/a.jpg
	 */
	private String relativePath;
	/**
	 * 文件类型
	 */
	private String contentType;
	/**
	 * 文件
	 */
	private File file;
	
	public FileEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param name  保存的文件名
	 * @param size  文件大小
	 * @param ext   文件后缀名
	 * @param relativePath  保存路径,相对于工程目录的路径包含文件名如： images/login/a.jpg
	 * @param contentType   文件格式 png的格式为"image/png"
	 * @param file          保存的文件
	 */
	public FileEntity(String name, long size, String ext, String relativePath, String contentType, File file) {
		super();
		this.name = name;
		this.size = size;
		this.ext = ext;
		this.relativePath = relativePath;
		this.contentType = contentType;
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}	
	/**
	 * 获取保存路径,相对于工程目录的路径,包含文件名，如： images/login/a.jpg
	 * @param relativePath
	 */
	public String getRelativePath() {
		return relativePath;
	}
	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
}
