package com.ezen.biz.dependecy_test;

public class Tire {
	private int size;

	public Tire() {
	}
	
	public Tire(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Tire [size=" + size + "]";
	}
	
	
}
