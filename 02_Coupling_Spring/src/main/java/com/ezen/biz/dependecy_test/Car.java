package com.ezen.biz.dependecy_test;

public class Car {
	private String compay;
	private int door;
	private String color;
	private Tire tire;

	public Car() {
	}

	public Car(String company, String color) {
		this.compay = company;
		this.color = color;
	}

	public Car(Tire tire) {
		this.tire = tire;
	}

	public String getCompay() {
		return compay;
	}

	public void setCompay(String compay) {
		this.compay = compay;
	}

	public int getDoor() {
		return door;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}

	@Override
	public String toString() {
		return "Car [compay=" + compay + ", door=" + door + ", color=" + color + ", tire=" + tire + "]";
	}
	
	
}
