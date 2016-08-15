package com.yysj.bangtang.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.ValueOperations;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisTest {
	private ShardedJedisPool  shardedJedisPool;
	private RedisTemplate<Serializable, Serializable>	redisTemplate;
	@Before
	public void init(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/bt-service.xml","spring/bt-dao.xml");
		//shardedJedisPool=ac.getBean(ShardedJedisPool.class);
		redisTemplate = (RedisTemplate<Serializable, Serializable>) ac.getBean("redisTemplate");
	}
	@Test  
	public void get(){
		   ShardedJedis shardedJedis = shardedJedisPool.getResource(); 
		  
		   shardedJedis.set("foo", "中文");
		   String foo=shardedJedis.get("foo");   
		   
		   System.out.println("name:"+foo); 
		   System.out.println(shardedJedis.get("test"));
	}
	
	
	@Test
	public void testRedisTemplate(){
		String name=redisTemplate.execute(new RedisCallback<String>() {

			public String doInRedis(RedisConnection connection) throws DataAccessException {
				// TODO Auto-generated method stub
				 byte[] key = redisTemplate.getStringSerializer().serialize(  
		                    "name");  
				 byte[] value= connection.get(key);
	                String name = redisTemplate.getStringSerializer()  
	                        .deserialize(value);
				return name;
			}
		});
		System.out.println(name);
		BoundValueOperations<Serializable, Serializable> op= redisTemplate.boundValueOps("name");
		System.out.println(op.get());
		
		
		ValueOperations<Serializable, Serializable> vo= redisTemplate.opsForValue();
		vo.set("test", "中文");
		 name =(String) vo.get("test");
		System.out.println("name:"+name);
	}
	
	
	@Test
	public void testFoo(){
		 GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		    config.setMaxTotal(1);
		    config.setBlockWhenExhausted(false);
		    JedisShardInfo shard=new JedisShardInfo("192.168.31.239", "6379");
		    shard.setPassword("qwerty");
		    List<JedisShardInfo> shards=new ArrayList<JedisShardInfo>();
		    shards.add(shard);
		    ShardedJedisPool pool = new ShardedJedisPool(config, shards);

		    ShardedJedis jedis = pool.getResource();
		    jedis.set("foo", "0");
		    
		    String name =jedis.get("name");
		    System.out.println(name);
		   /* ShardedJedis newJedis = pool.getResource();
		    newJedis.incr("foo");*/
	}
	@Test
	public void testTran(){
		
		/*List<Object> txResults = redisTemplate.execute(new SessionCallback<List<Object>>() {
			  public List<Object> execute(RedisOperations operations) throws DataAccessException {
			    operations.multi();
			    operations.opsForSet().add("w1", "w1");
			    operations.opsForSet().add("w2", "w2");
			    
			    //int i=2/0;
			    // This will contain the results of all ops in the transaction
			    return operations.exec();
			  }
			});
			System.out.println("Number of items added to set: " + txResults.get(0));
		*/
	}
	
	@Test
	public void testTrans2(){
		ValueOperations<Serializable, Serializable>  vo =redisTemplate.opsForValue();
		String t1=(String) vo.get("w1");
		String t2=(String) vo.get("w2");
		System.out.println(t1+" : "+t2);
	}
}
