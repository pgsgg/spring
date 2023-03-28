package com.ezen.biz.desing_pattern;

public class LGTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("LGTV--전원을 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("LGTV--전원을 끈다.");
	}

	@Override
	public void volumUp() {
		System.out.println("LGTV--소리를 올린다.");
	}

	@Override
	public void volumDown() {
		System.out.println("LGTV--소리를 내린다.");
	}
	
}
