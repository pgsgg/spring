package com.ezen.biz;

public class LGTV implements TV {
	
	public LGTV() {
		System.out.println("LGTV 객체를 생성합니다.");
	}
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리...");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전 처리...");
	}
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
