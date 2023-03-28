package com.ezen.biz;

public class BoseSpeaker implements Speaker {
	public BoseSpeaker() {
		System.out.println("===> BoseSpeaker 객체 생성");
	}

	@Override
	public void volumeUp() {
		System.out.println("===> BoseSpeaker : 소리를 올린다");
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("===> BoseSpeaker : 소리를 올린다");
	}
	
	
}
