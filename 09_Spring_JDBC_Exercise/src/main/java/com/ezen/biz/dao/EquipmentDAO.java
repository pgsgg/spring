package com.ezen.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.EquipmentVO;
import com.ezen.biz.service.EquipmentService;

@Repository("equipmentDAO")
public class EquipmentDAO  {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL
	private static final String GET_EQUIPMENT_BY_ROOMID
		= "SELECT * FROM equipment WHERE room_id=?";
	private static final String INSERT_EQUIPMENT
		= "INSERT INTO equipment VALUES(?, ?, ?, ?, ?)";
	
	public EquipmentVO getEquipmentByRoomid(String roomId) {
		
		return jdbcTemplate.queryForObject(GET_EQUIPMENT_BY_ROOMID, 
				new EquipmentRowMapper());
	}
	
	public void insertEquipment(EquipmentVO vo) {
		Object[] args = {
				vo.getEquipment_id(),
				vo.getRoom_id(),
				vo.getEquipment_name(),
				vo.getEquipment_count(),
				vo.getEquipment_remarks()
		};
		
		jdbcTemplate.update(INSERT_EQUIPMENT,args,new EquipmentRowMapper());
	}
	
	public class EquipmentRowMapper implements RowMapper<EquipmentVO> {

		@Override
		public EquipmentVO mapRow(ResultSet rs, int rowNum) 
											throws SQLException {
			EquipmentVO equipment = new EquipmentVO();
			
			equipment.setEquipment_id(rs.getString("equipment_id"));
			equipment.setRoom_id(rs.getString("room_id"));
			equipment.setEquipment_name(rs.getString("equipment_name"));
			equipment.setEquipment_count(rs.getInt("equipment_count"));
			equipment.setEquipment_remarks(rs.getString("equipment_remarks"));
			
			return equipment;
		}
		
	}
}
