package com.yysj.bangtang.common;

import java.io.InputStream;

import org.junit.Test;

public class CommonTest {

	@Test
	public void readFile(){
		InputStream is =CommonTest.class.getClassLoader().getResourceAsStream("filesavepath.xml");
		System.out.println(is);
	}
}
