package com.yysj.bangtang.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.bean.Employee;

public class EmployeeMapperTest {
	private static SqlSessionFactory sqlSessionFactory;
	private static ApplicationContext ac;
	@Before
	public void init(){
		 ac = new ClassPathXmlApplicationContext("spring/bt-service.xml","spring/bt-redis.xml");
		 sqlSessionFactory= ac.getBean(SqlSessionFactory.class);
	}
	
	/**
	 * 测试通过mapper方式来实现dao层接口
	 */
	@Test
	public void findAccount(){
		EmployeeMapper em=ac.getBean(EmployeeMapper.class);
		Employee emplo= em.selectByPrimaryKey("liang");
		
		System.out.println(emplo.getAccount());
	}
	
	@Test
	public void updateState(){
		EmployeeMapper em=ac.getBean(EmployeeMapper.class);
		Employee emplo= em.selectByPrimaryKey("liang");
		emplo.setState(2);
		em.updateByPrimaryKey(emplo);
	}
	
	@Test
	public void insertEmployee(){
		Employee emplo = new Employee();
		emplo.setAccount("lisi");
		emplo.setPassword("123");
		emplo.setState(1);
		emplo.setGender(1);
		
		EmployeeMapper em=ac.getBean(EmployeeMapper.class);
		em.insert(emplo);
	}
}
