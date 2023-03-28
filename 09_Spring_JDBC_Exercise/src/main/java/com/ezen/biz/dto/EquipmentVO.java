package com.ezen.biz.dto;

public class EquipmentVO {
	private String equipment_id;
	private String Room_id;
	private String Equipment_name;
	private int equipment_count;
	private String equipment_remarks;
	
	public String getEquipment_name() {
		return Equipment_name;
	}

	public void setEquipment_name(String equipment_name) {
		Equipment_name = equipment_name;
	}

	

	public String getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(String equipment_id) {
		this.equipment_id = equipment_id;
	}

	public String getRoom_id() {
		return Room_id;
	}

	public void setRoom_id(String room_id) {
		Room_id = room_id;
	}

	public int getEquipment_count() {
		return equipment_count;
	}

	public void setEquipment_count(int equipment_count) {
		this.equipment_count = equipment_count;
	}

	public String getEquipment_remarks() {
		return equipment_remarks;
	}

	public void setEquipment_remarks(String equipment_remarks) {
		this.equipment_remarks = equipment_remarks;
	}

	@Override
	public String toString() {
		return "EquipmentVO [equipment_id=" + equipment_id + ", Room_id=" + Room_id + ", equipment_count="
				+ equipment_count + ", equipment_remaks=" + equipment_remarks + "]";
	}


}
