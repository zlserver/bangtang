package com.yysj.bangtang.utils;

public class TokenGenerator {
	/**
	 * 生成token值
	 * @return
	 */
	public static String generatorToken(){
		long  mills =System.currentTimeMillis();
		String extra="bangbang@2016615";
		String sourceData = ""+mills+extra;
		return ServiceUtils.MD5Encode(sourceData);
	}
}
