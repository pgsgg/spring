package com.ezen.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

public class TVUser {

	public static void main(String[] args) {
//		(1)Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		TV tv = (TV) factory.getBean("tv");
		
		tv.powerOn();
		tv.volumUp();
		tv.volumDown();
		tv.powerOff();
		factory.close();

	}
}
