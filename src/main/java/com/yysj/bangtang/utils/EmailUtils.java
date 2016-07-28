package com.yysj.bangtang.utils;

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

	/**
	 * 发送激活邮件
	 * @param toEmail 接收方邮箱
	 * @param activeCode 激活码
	 */
	public static  void sendActiveEmail(String toEmail,String activeCode) throws AddressException, MessagingException{
		 /** 
        构建发送环境 
        */  
       Properties properties = new Properties();  
       properties.setProperty("mail.smtp.auth", "true");//接受服务器认证  
       properties.setProperty("mail.transport.protocol", "smtp");//设置发送协议  
       properties.setProperty("mail.host", "smtp.qq.com");//设置要连接的服务器地址，端口默认25  
       properties.setProperty("mail.smtp.starttls.enable", "true");//接受服务器认证  
      
       Session session = Session.getInstance(properties,new Authenticator() {  //策略模式  
       
           protected PasswordAuthentication getPasswordAuthentication() { //返回用户名和密码  
               // TODO Auto-generated method stub  
               return new PasswordAuthentication("594389970@qq.com", "uidrbnjajrpwbbjc"); //设置用户名和密码  
           }  
       });  
       session.setDebug(true); //显示调试信息  
       /** 
        * 构建邮件 
        */  
       Message msg = new MimeMessage(session);  
       msg.setFrom(new InternetAddress("594389970@qq.com"));//设置发送方地址  
       msg.setSubject("eyemember");  
       msg.addRecipient(RecipientType.TO, new InternetAddress(toEmail)); //设置收件人的类型：TO:收件人;CC:抄送;BCC:暗送;和收件人  
       String activeUrl="http://localhost:8080/bangtang/mobile/common/activeEmail/"+activeCode+".action"; 
       msg.setContent("<h3>点击以下链接激活邮箱:</h3> <a href=\""+activeUrl+"\">"+activeUrl+"</a>", "text/html;charset=gbk");//设置发送内容，以及内容的类型和编码  
       
       /** 
        * 发送邮件 
        */  
       Transport.send(msg);
      // Transport.send(msg,new Address[]{new InternetAddress(toEmail)}); 
   }
	
}

