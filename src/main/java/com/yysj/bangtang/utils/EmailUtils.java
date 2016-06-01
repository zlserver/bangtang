package com.yysj.bangtang.utils;

import java.util.Properties;

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
	 * 发送邮件
	 * @param message
	 * @param receEmail
	 */
	public static void sendMessage(String message,String receEmail){
		try {  
            /** 
             构建发送环境 
             */  
            Properties properties = new Properties();  
            properties.setProperty("mail.smtp.auth", "true");//接受认证  
            properties.setProperty("mail.transport.protocol", "smtp");//设置发送协议  
              
            Session session =Session.getDefaultInstance(properties);  
            session.setDebug(true);//设置在控制台打印调试信息  
            /** 
             * 构建邮件 
             */  
            Message msg = new MimeMessage(session);  
            msg.setText("逗你玩");     //发送内容  
            msg.setFrom(new InternetAddress("594389970@qq.com"));//设置发送邮件方地址  
              
            /* 
            	构建发送类 
            */  
            Transport transport = session.getTransport();  
            transport.connect("smtp.qq.com", 25, "zhouliang0802@qq.com", "zl@huan11211421");//设置要连接的服务器地址、端口、用户名、密码  
            transport.sendMessage(msg, new InternetAddress[]{new InternetAddress(receEmail)});//发送邮件给某些人  
            transport.close();//关闭发送链接  
              
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
	}

	public static  void email2() throws AddressException, MessagingException{
		 /** 
        构建发送环境 
        */  
       Properties properties = new Properties();  
       properties.setProperty("mail.smtp.auth", "true");//接受服务器认证  
       properties.setProperty("mail.transport.protocol", "smtp");//设置发送协议  
       properties.setProperty("mail.host", "smtp.qq.com");//设置要连接的服务器地址，端口默认25  
         
       Session session = Session.getInstance(properties,new Authenticator() {  //策略模式  
       
           protected PasswordAuthentication getPasswordAuthentication() { //返回用户名和密码  
               // TODO Auto-generated method stub  
               return new PasswordAuthentication("594389970@qq.com", "zl@huan11211421"); //设置用户名和密码  
           }  
       });  
       session.setDebug(true); //显示调试信息  
       /** 
        * 构建邮件 
        */  
       Message msg = new MimeMessage(session);  
       msg.setFrom(new InternetAddress("59438970@qq.com"));//设置发送方地址  
       msg.setSubject("中文主题");  
       msg.setRecipients(RecipientType.TO, InternetAddress.parse("2399548@qq.com,13628303286@163.com,594389970@qq.com")); //设置收件人的类型：TO:收件人;CC:抄送;BCC:暗送;和收件人  
       msg.setContent("<span style='color:red'>中文呵呵</span>", "text/html;charset=gbk");//设置发送内容，以及内容的类型和编码  
         
       /** 
        * 发送邮件 
        */  
       Transport.send(msg);  
   }
	
}

