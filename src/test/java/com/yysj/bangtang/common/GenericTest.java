package com.yysj.bangtang.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.bean.ClientExample;
import com.yysj.bangtang.mapper.ClientMapper;
import com.yysj.bangtang.utils.GenericUtils;
import com.yysj.bangtang.utils.ServiceUtils;

public class GenericTest {

	private  ClientMapper clientMapper;
	
	@Before
	public void init(){
		 ApplicationContext ac = new ClassPathXmlApplicationContext("spring/bt-service.xml","spring/bt-redis.xml");
		 clientMapper=ac.getBean(ClientMapper.class);
	}
	@Test
	public void testClass(){
		
		QueryEntity qe = new QueryEntity();
		Object ob = qe;
		System.out.println(ob.getClass());
	}
	
	/**
	 * 通过反射获取查询条件
	 */
	@Test
	public void testClient(){
		List<Object> paras = new ArrayList<Object>();
		paras.add(1);
		QueryEntity qe = new QueryEntity("Gender","EqualTo",paras);
		List<QueryEntity> list = new ArrayList<QueryEntity>();
		list.add(qe);
		ClientExample example =GenericUtils.buildCriteriaFromBean(ClientExample.class, list);
		
		List<Client> listC=clientMapper.selectByExample(example);
		for( Client c : listC)
			System.out.println(c.getEmail()+" : "+c.getActivecode());
		
	}
	
}
