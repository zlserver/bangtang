package com.yysj.bangtang.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Properties;

public class Config {
	//发布动态中图片的压缩宽度，压缩是正方形的所以指定宽就行
	public static final String CONTENTPIC_COMPRESSWIDTH="contentpic.compresswidth";
	//发布动态中包含图片的上限个数
	public static final String CONTENTPIC_COUNTLIMIT="contentpic.countlimit";
	
	/**
	 * 读取配置文件config.properties中配置
	 * @param key Config中常量             
	 * @return
	 */
	public static String getKey(String key){
		
		
		try {
			URL url= Config.class.getClassLoader().getResource("config.properties");
			
			String path=url.getPath() ;
			path =path.replaceAll("%20"," ");
			FileInputStream fis = new FileInputStream(path);
			Properties pros = new Properties();
			pros.load(fis);
			
			return pros.getProperty(key);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
