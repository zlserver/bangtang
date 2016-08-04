package com.yysj.bangtang.file;

public interface FilePath {

	public static final String FILE_ROOT="root";
	/**
	 * 用户头像保存相对路径
	 */
	public static final String USER_PIC="userPic";
	/**
	 * 用户发表动态中图片保存相对路径
	 */
	public static final String CONTENT_PIC="contentPic";
	/**
	 * 用户发表动态中短视频保存相对路径
	 */
	public static final String CONTENT_VIDEO="contentVideo";
	/**
	 * 获得文件保存路径
	 * @param key
	 * @return  例如：image/contentPic/
	 */
	public String getPath(String key);
}
