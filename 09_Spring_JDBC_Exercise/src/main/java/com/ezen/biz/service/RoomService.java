package com.ezen.biz.service;

import java.util.List;

import com.ezen.biz.dto.EquipmentVO;
import com.ezen.biz.dto.RoomVO;

public interface RoomService {

	int findMaxCapacity();

	String findRoomNameById(String roomid);

	List<RoomVO> getAllRoom();

	void insertRoom(RoomVO vo);
	
	//회의실 정보와 설비 정보 저장
	
	void addRoomAndEquipment(RoomVO vo,List<EquipmentVO> equipmentList);

}