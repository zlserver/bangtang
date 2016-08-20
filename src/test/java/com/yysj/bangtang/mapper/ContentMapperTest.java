package com.yysj.bangtang.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.Page;
import com.yysj.bangtang.bean.Content;
import com.yysj.bangtang.myenum.ContentStateEnum;
import com.yysj.bangtang.service.ContentService;

public class ContentMapperTest {
	private static SqlSessionFactory sqlSessionFactory;
	private static ApplicationContext ac;
	@Before
	public void init(){
		 ac = new ClassPathXmlApplicationContext("spring/bt-service.xml");
		 sqlSessionFactory= ac.getBean(SqlSessionFactory.class);
	}
	
	@Test
	public void insert(){
		ContentMapper cm =ac.getBean(ContentMapper.class);
		Content content = new Content();
		content.setEmail("594389970@qq.com");
		content.setState(ContentStateEnum.PASS);
		content.setPubTime(new Date());
		cm.insert(content);
	}
	
	@Test
	public void selectList(){
		String email="594389970@qq.com";
		ContentMapper cm =ac.getBean(ContentMapper.class);
		List<Content> list= cm.selectByEmail(email);
		for(Content ct : list)
		System.out.println(ct.getEmail()+" : "+ct.getState()+" : "+ct.getPubTime());
	}
	
	@Test
	public void selectScrollList(){
		String email="594389970@qq.com";
		ContentService cs =ac.getBean(ContentService.class);
		//查询第2页，每页最多3条记录。如果查询页数大于总页数，或者每页的记录数设为0，则不查询出数据。
		Page<Content> page =cs.getScrollByEmail(email,2, 3);
		int endrow =page.getEndRow();//结束行
		int startRow =page.getStartRow();//起始行
		int pages = page.getPages();//总页数
		
		List<Content> list =page.getResult();
		for(Content ct : list)
		System.out.println(ct.getEmail()+" : "+ct.getText()+" : "+ct.getState()+" : "+ct.getPubTime());
		System.out.println("分页的信息: 起始行:"+startRow+" 结束行："+endrow+" 总页数:"+pages);
	}
	
	@Test
	public void selectScrollList2(){
		ContentService cs =ac.getBean(ContentService.class);
		//查询第2页，每页最多3条记录。如果查询页数大于总页数，或者每页的记录数设为0，则不查询出数据。
		Page<Content> page =cs.getScrollByState(ContentStateEnum.PASS,2, 3);
		int endrow =page.getEndRow();//结束行
		int startRow =page.getStartRow();//起始行
		int pages = page.getPages();//总页数
		
		List<Content> list =page.getResult();
		for(Content ct : list)
		System.out.println(ct.getEmail()+" : "+ct.getText()+" : "+ct.getState()+" : "+ct.getPubTime());
		System.out.println("分页的信息: 起始行:"+startRow+" 结束行："+endrow+" 总页数:"+pages);
	}
}
