package com.yysj.bangtang.bean;
/**
 * 图片视频记录表
 * @author liang
 * @version 创建时间 2016年4月14日
 * 说明:
 *
 */
public class PictureVideo {
	/**
	 * 标识id
	 */
	private String id;
	/**
	 * 用户邮箱
	 */
	private String email;
	/**
	 * 文件保存路径
	 */
	private String filePath;
	/**
	 * 大小
	 */
	private String size;
	/**
	 * 格式
	 */
	private String ext;
	/**
	 * 分辨率
	 */
	private String resolution;
	/**
	 * 文件类型
	 */
	private String fileType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
}
