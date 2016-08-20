package com.yysj.bangtang.redis;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.yysj.bangtang.utils.ValidateUtil;
@Repository("rContentDao")
public class RContentDaoImpl implements RContentDao {

	
	private RedisTemplate<Serializable, Serializable>	redisTemplate;
	public int publish(RContent rc) {

		String id=rc.getId();
		//内容的值存储在散列类型hash中
		HashOperations<Serializable, Object, Object> ho=redisTemplate.opsForHash();
		Map<Object,Object> m = new HashMap<Object,Object>();
		m.put("agreeCount", rc.getAgreeCount());
		m.put("pubTime", rc.getPubTime());
		m.put("readCount", rc.getReadCount());
		m.put("text", rc.getText());
		m.put("nickname", rc.getNickname());
		m.put("nation", rc.getNation());
		m.put("gender", rc.getGender());
		m.put("email", rc.getEmail());
		
		if( ValidateUtil.isValidateStr(rc.getPicSavePath()))
			m.put("picSavePath", rc.getPicSavePath());
		if(ValidateUtil.isValidateStr(rc.getVideoSavePath()))
			m.put("videoSavePath", rc.getVideoSavePath());
		if(ValidateUtil.isValidateStr(rc.getVideoSavePath()))
			m.put("picpath", rc.getPicpath());
		ho.putAll(id, m);
		
		//key使用列表（list)类型存储,实现分页容易
		ListOperations<Serializable, Serializable> lo=redisTemplate.opsForList();
		//1.列表key:  content:keys
		lo.leftPush(RContentDao.CONTENT_LIST_KEY, id);
		
		return 1;
	}

	public RContent getByKey(String key) {
		// TODO Auto-generated method stub
		RContent rc =null;
		
		BoundHashOperations<Serializable, Object, Object> bho = redisTemplate.boundHashOps(key);
		if( bho!=null&&bho.hasKey("agreeCount")){
			
			Integer agreeCount =(Integer) bho.get("agreeCount");
			Date pubTime =(Date) bho.get("pubTime");
			Integer readCount=(Integer) bho.get("readCount");
			String text =(String) bho.get( "text");
			String picSavePath=(String) bho.get("picSavePath");
			String videoSavePath=(String) bho.get("videoSavePath");
			String nickname=(String) bho.get("nickname");
			String picpath=(String) bho.get("picpath");
			String nation=(String) bho.get("nation");
			Integer gender=(Integer) bho.get("gender");
			String email=(String) bho.get("email");
			
			rc = new RContent();
			rc.setAgreeCount(agreeCount);
			rc.setPubTime(pubTime);
			rc.setReadCount(readCount);
			rc.setText(text);
			rc.setPicSavePath(picSavePath);
			rc.setVideoSavePath(videoSavePath);
			rc.setNation(nation);
			rc.setNickname(nickname);
			rc.setGender(gender);
			rc.setPicpath(picpath);
			rc.setEmail(email);
		}
		/*HashOperations<Serializable,Object,Object> ho =redisTemplate.opsForHash();
		if(ho.hasKey(key, "agreeCount")){
			int agreeCount =(Integer) ho.get(key, "agreeCount");
			Date pubTime =(Date) ho.get(key, "pubTime");
			int readCount=(Integer) ho.get(key, "readCount");
			String text =(String) ho.get(key, "text");
			String picSavePath=(String) ho.get(key, "picSavePath");
			String videoSavePath=(String) ho.get(key, "videoSavePath");
			rc = new RContent();
			rc.setAgreeCount(agreeCount);
			rc.setPubTime(pubTime);
			rc.setReadCount(readCount);
			rc.setText(text);
			rc.setPicSavePath(picSavePath);
			rc.setVideoSavePath(videoSavePath);
		}*/
		return rc;
	}

	public List<RContent> get(int index, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	public RedisTemplate<Serializable, Serializable> getRedisTemplate() {
		return redisTemplate;
	}
	@Resource(name="redisTemplate")
	public void setRedisTemplate(RedisTemplate<Serializable, Serializable> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

}
