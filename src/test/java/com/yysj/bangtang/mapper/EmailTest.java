package com.yysj.bangtang.mapper;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.Test;

import com.yysj.bangtang.utils.EmailUtils;

public class EmailTest {
	@Test
	public void email(){
		EmailUtils.sendMessage("你好", "594389970@qq.com");		
		/*try {
			EmailUtils.email2();
		} catch (Exception e) {
			e.printStackTrace();
		} */
	}
}