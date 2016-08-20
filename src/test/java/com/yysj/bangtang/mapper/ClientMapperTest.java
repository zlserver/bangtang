package com.yysj.bangtang.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.myenum.EmailStateEnum;
import com.yysj.bangtang.service.ClientService;

public class ClientMapperTest {
	private static SqlSessionFactory sqlSessionFactory;
	private static ApplicationContext ac;
	@Before
	public void init(){
		 ac = new ClassPathXmlApplicationContext("spring/bt-service.xml");
		 sqlSessionFactory= ac.getBean(SqlSessionFactory.class);
	}
	
	@Test
	public void testTrans(){
		ClientService clientService= ac.getBean(ClientService.class);
		try {
			//clientService.testTran();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//测试分页
	@Test
	public void testScroll(){
		ClientMapper cm =ac.getBean(ClientMapper.class);
		PageHelper.startPage(1, 10);
		
	}
	/**
	 * 测试通过mapper方式来实现dao层接口
	 *//*
	@Test
	public void findByEmail(){
		ClientMapper cm =ac.getBean(ClientMapper.class);
		Client c =cm.findByEmail("594389970@qq.com");
		System.out.println(c.getEmail()+":"+c.getNickName());
		c =cm.findByEmail("594389970@qq.com");
		System.out.println(c.getEmail()+":"+c.getNickName());
	}
	*//**
	 * 测试一级缓存
	 *//*
	@Test
	public void testFirstCache(){
	 SqlSession sqlSession=	sqlSessionFactory.openSession();
	 ClientMapper cm =sqlSession.getMapper(ClientMapper.class);

		Client c =cm.findByEmail("594389970@qq.com");
		System.out.println(c.getEmail()+":"+c.getNickName());
		//执行更新会清空一级缓存的内容
		c.setNickName("张三");
		cm.updateClient(c);
		
		Client c1 =cm.findByEmail("594389970@qq.com");
		System.out.println(c1.getEmail()+":"+c1.getNickName());
		
		sqlSession.close();
	}
	
	*//**
	 * 测试二级缓存
	 * 没有开启二级缓存的话3次查询都会访问数据库，
	 * 开启二级缓存的话，只有1，3次查询操作会访问数据库。
	 *//*
	@Test
	public void testSecondCache(){

		 SqlSession sqlSession1=	sqlSessionFactory.openSession();
		 SqlSession sqlSession2=	sqlSessionFactory.openSession();
		 SqlSession sqlSession3=	sqlSessionFactory.openSession();
			 //创建代理对象
			ClientMapper cm1 =sqlSession1.getMapper(ClientMapper.class);
			 //第一次发起请求，根据邮箱查询客户
			Client c =cm1.findByEmail("594389970@qq.com");
			System.out.println(c.getEmail()+":"+c.getNickName());
			//关闭操作，将sqlSession中的数据写到二级缓存区域
			sqlSession1.close();
			
			 //第二次发起请求，根据邮箱查询客户
			//使用sqlSession2执行commit()操作
		    ClientMapper cm2 =sqlSession2.getMapper(ClientMapper.class);
		    //开启了二级缓存，会直接从缓存中取数据
		    Client c2 =cm2.findByEmail("594389970@qq.com");
			
			c2.setNickName("张三");
			cm2.updateClient(c2);
			//执行更新会清空一级缓存的内容，以及二级缓存的内容
			sqlSession2.commit();
			sqlSession2.close();
			
			 //第三次发起请求，根据邮箱查询客户
			 //创建代理对象
			ClientMapper cm3 =sqlSession3.getMapper(ClientMapper.class);
			 //第一次发起请求，根据邮箱查询客户
			Client c3 =cm3.findByEmail("594389970@qq.com");
			System.out.println(c3.getEmail()+":"+c3.getNickName());
			//关闭操作，将sqlSession中的数据写到二级缓存区域
			sqlSession3.close();
	}*/
}
