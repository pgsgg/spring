package com.ezen.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.EquipmentDAO;
import com.ezen.biz.dto.EquipmentVO;
@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	private EquipmentDAO dao;
	
	@Override
	public EquipmentVO getEquipmentByRoomid(String roomId) {
		
		return dao.getEquipmentByRoomid(roomId);
	}

	@Override
	public void insertEquipment(EquipmentVO vo) {
		
		dao.insertEquipment(vo);
	}

}
