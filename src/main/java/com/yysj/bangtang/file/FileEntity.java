package com.yysj.bangtang.file;

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
	 * 保存路径,相对于工程目录的路径
	 */
	private String relativePath;
	/**
	 * 文件类型
	 */
	private String contentType;
	
	public FileEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param name
	 * @param size
	 * @param ext
	 * @param relativePath  保存路径,相对于工程目录的路径包含文件名如： images/login/a.jpg
	 * @param contentType
	 */
	public FileEntity(String name, long size, String ext, String relativePath, String contentType) {
		super();
		this.name = name;
		this.size = size;
		this.ext = ext;
		this.relativePath = relativePath;
		this.contentType = contentType;
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
}
