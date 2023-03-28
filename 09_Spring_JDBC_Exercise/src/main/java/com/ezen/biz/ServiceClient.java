package com.ezen.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.EquipmentVO;
import com.ezen.biz.dto.RoomVO;
import com.ezen.biz.service.RoomService;

public class ServiceClient {
	private static RoomService roomService;
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		roomService = (RoomService) container.getBean("roomService");
		
		List<RoomVO> list = roomService.getAllRoom();
		for(RoomVO vo : list)
			System.out.println(vo.toString());
		System.out.println(roomService.findRoomNameById("A001"));
		
		/*
		 * RoomVO room1 = new RoomVO(); room1.setRoom_id("B001");
		 * room1.setRoom_name("방문객 회의실"); room1.setCapacity(6); List<EquipmentVO> eList
		 * = new ArrayList<>(); EquipmentVO item1 = new EquipmentVO();
		 * item1.setEquipment_id("50-1"); item1.setEquipment_name("회의용 테이블");
		 * item1.setEquipment_count(1); item1.setEquipment_remarks("");
		 * item1.setRoom_id("B001"); eList.add(item1);
		 * roomService.addRoomAndEquipment(room1, eList);
		 */
		 
		container.close();
	}

}
