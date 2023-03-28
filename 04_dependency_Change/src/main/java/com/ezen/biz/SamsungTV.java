package com.ezen.biz;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("===> SamsumgTV 객체 생성");
	}

	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsumgTV 객체 생성2");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsumgTV 객체 생성3");
		this.speaker = speaker;
		this.price = price;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV--전원을 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV--전원을 끈다.");
	}

	@Override
	public void volumUp() {
		//System.out.println("SamsungTV--소리를 올린다.");
		speaker.volumeUp();
	}

	@Override
	public void volumDown() {
		//System.out.println("SamsungTV--소리를 내린다.");
		speaker.volumeDown();
	}

	@Override
	public String toString() {
		return "SamsungTV [speaker=" + speaker + ", price=" + price + "]";
	}

}
