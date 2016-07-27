package com.yysj.bangtang.utils;

public final class TokenGenerator {
	private static final  String EXTRA ="bangbang@";
	/**
	 * 生成token值
	 * 取用当前时间和额外加盐值经过md5算法生成摘要值作为token的值，用户每次访问服务器端方法时都需要携带该值；
	 * 用户在不同机器上登录、会产生新的token值。
	 * 在不同机器上登录：在每次登录时都会生成新的token值.
	 * @return  String
	 */
	public static String generatorToken(String email){
		long  mills =System.currentTimeMillis();
		String sourceData = ""+mills;
		
		return ServiceUtils.MD5Encode(sourceData)+EXTRA+email;
	}
	
	public static String getEmail(String token){
		String email="";
		try{
		String[] sp=token.split(EXTRA);
		email= sp[1];
		}catch(Exception e){
			throw new RuntimeException("从token："+token+"中获取账号失败!",e);
		}
		return email;
	}
}
