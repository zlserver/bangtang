package com.yysj.bangtang.mapper;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.yysj.bangtang.utils.EmailUtils;

public class EmailTest {
	@Test
	public void email(){
		//EmailUtils.sendMessage("你好", "594389970@qq.com");		
		try {
			EmailUtils.sendEmail("zhouliangbiyesheji@163.com", "zho");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	@Test
	public void javaMailProperties() throws MessagingException {
		Properties pros = new Properties();
		pros.setProperty("mail.smtp.auth","true");
		pros.setProperty("mail.smtp.starttls.enable", "true");//接受服务器认证  
		//pros.setProperty("mail.transport.protocol", "smtp");//设置发送协议  
	    
		String username="594389970@qq.com";
		String password="uidrbnjajrpwbbjc";
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setJavaMailProperties(pros);
		sender.setHost("smtp.qq.com");
		sender.setPort(25);
		sender.setUsername(username);
		sender.setPassword(password);
		
		
		/*sender.setUsername("594389970@qq.com");
		sender.setPassword("uidrbnjajrpwbbjc");*/
		
		SimpleMailMessage smm= new SimpleMailMessage();
		smm.setFrom(username);
		smm.setTo("zhouliangbiyesheji@163.com");
		smm.setSubject("spring邮箱测试");
		smm.setText("测试spring mail2");
		sender.send(smm);
		
		/*MimeMessage mimeMessage = sender.createMimeMessage();
		mimeMessage.setFrom(new InternetAddress("594389970@qq.com"));
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("zhouliangbiyesheji@163.com"));
		mimeMessage.setText("测试spring mail");
		sender.send(mimeMessage);*/
	}
	@Test
	public void testSpringEmail(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/bt-service.xml");
		MailSender sender = ac.getBean(MailSender.class);
		SimpleMailMessage smm= new SimpleMailMessage();
		smm.setFrom("594389970@qq.com");
		smm.setTo("zhouliangbiyesheji@163.com");
		smm.setSubject("spring邮箱测试5");
		smm.setText("测试spring mail3");
		sender.send(smm);
	}
}
