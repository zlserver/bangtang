package com.yysj.bangtang.utils;

import com.yysj.bangtang.exception.NullException;

public class ValidateUtil {
	/**
	 * 判断是否是有效字符串。
	 * @param str 字符串
	 * @return 如果字符串为null或者为空格返回false,否则返回true
	 */
	public static boolean isValidateStr(String str) {
		if( null ==str || "".equals(str.trim())){
			return false;
		}
		return true;
	}
	/**
	 * 
	 * @param str 检验字符串
	 * @return str中包含空字符串返回true,否则返回false
	 * @throws NullException 字符串为null
	 */
	public static boolean isContainEmptyStr(String str)throws NullException{
		if(str==null)
			throw new NullException("校验字符串为空");
		if( str.contains(" "))
			return true;
		return false;
	}
	/**
	 * 校验字符串str的长度不小于min且不大于max。
	 * @param str 字符串。
	 * @param min 最小长度
	 * @param max 最大长度
	 * @return 如果字符串为null,或者包含空字符串,不管是中间还是两端只要包含空字符串返回false,字符串长度小于min或者大于max返回false，
	 * 否则返回true.
	 */
	public static boolean validateLen(String str,int min,int max) {
		//正则表达式
		String regex ="\\S{"+min+","+max+"}";
		if(!str.matches(regex))
			return false;
		return true;
	}
	/**
	 * 校验密码，规定长度6-15非空有效字符串。
	 * @param password 密码
	 * @return 长度6-15非空格字符，满足返回true，否则返回false
	 */
	public static boolean validatePassword(String password){
		return validateLen(password, 6, 15);
	}
	/**
	 * 校验邮箱格式,必修满足邮箱格式才可以成功。
	 * @param email 邮箱
	 * @return 符合格式返回true否则返回false
	 */
	public static boolean validateEmail(String email){
		if(!isValidateStr(email))
			return false;
		String reg = "(\\w)+(.\\w+)*@(\\w)+((.\\w+)+)";
		//邮箱
		if(!email.matches(reg))
			return false;
		return true;
	}
}
