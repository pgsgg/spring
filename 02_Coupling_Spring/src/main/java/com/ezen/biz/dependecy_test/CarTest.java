package com.ezen.biz.dependecy_test;

public class CarTest {
	public static void main(String[] args) {
		Car car = new Car();
		car.setCompay("현대");
		car.setColor("흰색");
		//Tire tire = new Tire();
		//car.setTire(tire); //setter를 이용한 Tire 멤버변수 설정
//		car.getTire().setSize(19);
		System.out.println("car = " + car);
		//또다른 Car 객체 생성
		Car car1 = new Car(new Tire(19));
		car1.setCompay("현대");
		car1.setColor("흰색");
		System.out.println("car1 = " + car1);
	}
}
