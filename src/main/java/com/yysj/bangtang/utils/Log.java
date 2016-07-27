package com.yysj.bangtang.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 日志工具类
 * @author zhouliang
 *
 */
public final class Log {

	/**
	 * 输出消息日志
	 * @param ob
	 * @param mesg
	 */
	public static void info(Object ob,String mesg){
		Logger log =LogManager.getLogger(ob.getClass());
		log.info(mesg);
	}
	/**
	 * 输出错误日志
	 * @param ob
	 * @param mesg
	 */
	public static void error(Object ob,String mesg){
		Logger log =LogManager.getLogger(ob.getClass());
		log.error(mesg);
	}

}
