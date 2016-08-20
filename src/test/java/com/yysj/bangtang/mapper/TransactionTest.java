package com.yysj.bangtang.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
	private static ApplicationContext ac;
	@Before
	public void init(){
		 ac = new ClassPathXmlApplicationContext("spring/bt-service.xml");
	}
	
	
}
