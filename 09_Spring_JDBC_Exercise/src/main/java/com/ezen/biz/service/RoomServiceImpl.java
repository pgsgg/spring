package com.ezen.biz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.EquipmentDAO;
import com.ezen.biz.dao.RoomDAO;
import com.ezen.biz.dto.EquipmentVO;
import com.ezen.biz.dto.RoomVO;

@Service("roomService")
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDAO roomDao;
	@Autowired
	private EquipmentDAO equipmentDao;
	
	@Override
	public int findMaxCapacity() {
		
		return roomDao.findMaxCapacity();
	}

	@Override
	public String findRoomNameById(String roomid) {
		
		return roomDao.findRoomNameById(roomid);
	}

	@Override
	public List<RoomVO> getAllRoom() {
		
		return roomDao.getAllRoom();
	}

	@Override
	public void insertRoom(RoomVO vo) {
		roomDao.insertRoom(vo);

	}

	@Override
	public void addRoomAndEquipment(RoomVO vo, List<EquipmentVO> equipmentList) {
		roomDao.insertRoom(vo);
		for(int i = 0; i < equipmentList.size(); i++) {
			equipmentDao.insertEquipment(equipmentList.get(i));
		}
		
	}



}
