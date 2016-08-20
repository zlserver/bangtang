package com.yysj.bangtang.redis;

import java.util.List;

/**
 * 操作用户发布动态接口
 * @author xcitie
 *
 */
public interface RContentDao {
	/**
	 * 使用key值为LIST_KEYS的列表来存储动态的id
	 */
	public final static String CONTENT_LIST_KEY="content:keys";
	public int publish(RContent content);
	
	public RContent getByKey(String key);
	
	public List<RContent> get(int index,int max);
}
