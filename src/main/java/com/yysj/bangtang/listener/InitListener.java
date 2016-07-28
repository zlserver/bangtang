package com.yysj.bangtang.listener;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

import org.springframework.web.context.ServletContextAware;

import com.yysj.bangtang.task.EmailService;


public class InitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//容器初始化后，开启激活邮箱通知线程。
		EmailService es = new EmailService();
		new Thread(es).start();
	}

}
