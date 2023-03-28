package com.ezen.biz.polymorphism;

public class TVUser {

	public static void main(String[] args) {
//		TV tv = new SamsungTV();
		TV tv = new LGTV();
		tv.powerOn();
		tv.volumUp();
		tv.volumDown();
		tv.powerOff();
	}
	
}
