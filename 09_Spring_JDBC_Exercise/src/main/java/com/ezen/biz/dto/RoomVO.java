package com.ezen.biz.dto;

public class RoomVO {
	private String room_id;
	private String room_name;
	private int capacity;
	
	public RoomVO(String room_id, String room_name, int capacity) {
		super();
		this.room_id = room_id;
		this.room_name = room_name;
		this.capacity = capacity;
	}

	public RoomVO() {
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "RoomVO [room_id=" + room_id + ", room_name=" + room_name + ", capacity=" + capacity + "]";
	}
	
	
}	
