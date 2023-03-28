package com.ezen.biz.service;

import com.ezen.biz.dto.EquipmentVO;

public interface EquipmentService {

	EquipmentVO getEquipmentByRoomid(String roomId);
	
	void insertEquipment(EquipmentVO vo);
}