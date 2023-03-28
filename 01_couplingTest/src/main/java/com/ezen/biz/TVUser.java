package com.ezen.biz;

public class TVUser {

	public static void main(String[] args) {
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.volumUp();
		tv.volumDown();
		tv.powerOff();
		LGTV tv2 = new LGTV();
		tv2.turnOn();
		tv2.soundUp();
		tv2.soundDown();
		tv2.turnOff();
	}
	
}
