package com.ezen.biz;

public class JBLSpeaker implements Speaker {

	@Override
	public void volumeUp() {
		System.out.println("JBL Speaker ===> 소리를 올린다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("JBL Speaker ===> 소리를 내린다.");
	}
	
	public JBLSpeaker() {
		System.out.println("JBL Speaker : 객체생성");
	}
}
