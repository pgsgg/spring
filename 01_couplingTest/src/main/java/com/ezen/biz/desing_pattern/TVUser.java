package com.ezen.biz.desing_pattern;

public class TVUser {

	public static void main(String[] args) {
//		TV tv = new SamsungTV();
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		
		tv.powerOn();
		tv.volumUp();
		tv.volumDown();
		tv.powerOff();
	}
	
}
