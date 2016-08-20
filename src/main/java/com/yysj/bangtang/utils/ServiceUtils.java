package com.yysj.bangtang.utils;

import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.bag.SynchronizedSortedBag;


public class ServiceUtils {
	//16进制字符
		private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
		/**
		 * 的MD5编码，以防出现“=”号
		 * @param origin 源数据
		 * @return MD5数据，不含有"="可以放在连接路径中以防产生错误参数
		 */
		public static String MD5Encode(String origin) {
			String resultString = null;

			try {
				resultString = new String(origin);
				MessageDigest md = MessageDigest.getInstance("MD5");
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			} catch (Exception ex) {

			}
			return resultString;
		}
		/**
		 * 转换字节数组为16进制字串
		 * @param b
		 *            字节数组
		 * @return 16进制字串
		 */

		public static String byteArrayToHexString(byte[] b) {
			StringBuffer resultSb = new StringBuffer();
			for (int i = 0; i < b.length; i++) {
				resultSb.append(byteToHexString(b[i]));
			}
			return resultSb.toString();
		}

		private static String byteToHexString(byte b) {
			int n = b;
			if (n < 0)
				n = 256 + n;
			int d1 = n / 16;
			int d2 = n % 16;
			return hexDigits[d1] + hexDigits[d2];
		}
		/**
		 * 将orig中的数据拷贝到dest中
		 * @param dest 目标类
		 * @param orig 原类
		 */
		public static void copyBean(Object dest,Object orig) throws Exception{
			BeanUtils.copyProperties(dest, orig);
		}
		/**
		 * 从文件名中获取文件的后缀名，入a.jpg，返回结果jpg
		 * @param fileName
		 * @return
		 */
		public static String getExtFromFileName(String fileName){
			
			return fileName.substring(fileName.lastIndexOf(".")+1);
		}
		/**
		 * 返回uuid
		 * @return 大写字符的uuid值
		 */
		public static String getUuid() {
			 return UUID.randomUUID().toString().replace("-", "").toUpperCase();
		}
		/**
		 * 得到日期文件名，组成由sdf输出格式再加上当前毫秒数
		 * @param sdf ,如果为null，则使用模式yyyyMMddhh
		 * @return
		 */
		public static String getDateFileName(SimpleDateFormat sdf)
		{
			if( sdf==null)
				sdf = new SimpleDateFormat("yyyyMMddhh");
			
			return sdf.format(new Date())+System.currentTimeMillis();
		}
		/**
		 * 得到日期格式的文件目录
		 * @param sdf ,如果为null，则使用模式yyyy/MM/dd/hh
		 * @return 例如：2016/08/03
		 */
		public static String getDateFileDir(SimpleDateFormat sdf)
		{
			if( sdf==null)
				sdf = new SimpleDateFormat("yyyy/MM/dd/hh");
			
			return sdf.format(new Date());
		}
}
