package com.yysj.bangtang.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {

	private static Properties emailpros= new Properties();
	static{
		InputStream is= EmailUtils.class.getClassLoader().getResourceAsStream("emailconfig.properties");
		try {
			emailpros.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("加载邮箱配置文件出错");
		}
	}
	/**
	 * 发送邮件通知
	 * @param toEmail 接收方邮箱
	 * @param content 发送内容
	 * @param subject 邮件主题
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static  void sendEmail(String toEmail,String content,String subject) throws AddressException, MessagingException{
		 /** 
        构建发送环境 
        */  
       Properties properties = new Properties();  
       properties.setProperty("mail.smtp.auth", "true");//接受服务器认证  
       properties.setProperty("mail.transport.protocol", "smtp");//设置发送协议  
       properties.setProperty("mail.host", emailpros.getProperty("email.serer"));//设置要连接的服务器地址，端口默认25  
       properties.setProperty("mail.smtp.port",emailpros.getProperty("email.port")); 
       properties.setProperty("mail.smtp.starttls.enable", "true");//接受服务器认证  
      
       Session session = Session.getInstance(properties,new Authenticator() {  //策略模式  
       
           protected PasswordAuthentication getPasswordAuthentication() { //返回用户名和密码  
               // TODO Auto-generated method stub  
               return new PasswordAuthentication(emailpros.getProperty("email.account"), emailpros.getProperty("email.password")); //设置用户名和密码  
           }  
       });  
       session.setDebug(true); //显示调试信息  
       /** 
        * 构建邮件 
        */  
       Message msg = new MimeMessage(session);  
       msg.setFrom(new InternetAddress(emailpros.getProperty("email.account")));//设置发送方地址  
       msg.setSubject(subject);  
       msg.addRecipient(RecipientType.TO, new InternetAddress(toEmail)); //设置收件人的类型：TO:收件人;CC:抄送;BCC:暗送;和收件人  
       msg.setContent(content, "text/html;charset=gbk");//设置发送内容，以及内容的类型和编码  
      /** 
        * 发送邮件 
        */  
       Transport.send(msg);
	}
	
	/**
	 * 发送邮件通知
	 * @param toEmail 接收方邮箱
	 * @param content 发送内容
	 */
	public static  void sendEmail(String toEmail,String content) throws AddressException, MessagingException{
		sendEmail(toEmail, content, "eyember邮箱通知");
   }
	
}

