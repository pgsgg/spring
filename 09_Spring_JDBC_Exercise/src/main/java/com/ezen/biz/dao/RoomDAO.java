package com.ezen.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.RoomVO;

@Repository("roomDAO")
public class RoomDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_MAX_CAPACITY = "select max(capacity) from room";
	private static final String GET_ROOM_NAME = "SELECT ROOM_NAME FROM ROOM WHERE ROOM_ID = ?";
	private static final String GET_ALL_LIST = "SELECT * FROM ROOM";
	private static final String INSERT_ROOM = "INSERT INTO ROOM VALUES (?,?,?)";
	public int findMaxCapacity() {
		return jdbcTemplate.queryForObject(SELECT_MAX_CAPACITY, Integer.class);
	}

	
	public String findRoomNameById(String roomid) {
		Object[] args = {roomid};

		return jdbcTemplate.queryForObject(GET_ROOM_NAME, args, String.class);
	}

	
	public List<RoomVO> getAllRoom() {
		return jdbcTemplate.query(GET_ALL_LIST, new RoomRowMapper());
	}
	
	
	public void insertRoom(RoomVO vo) {
		Object[] args = {vo.getRoom_id(),vo.getRoom_name(),vo.getCapacity()};
		jdbcTemplate.update(INSERT_ROOM,args);
	}
}

class RoomRowMapper implements RowMapper<RoomVO> {

	@Override
	public RoomVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoomVO room = new RoomVO();
		room.setRoom_id(rs.getString("room_id"));
		room.setRoom_name(rs.getString("room_name"));
		room.setCapacity(rs.getInt("capacity"));
		return room;
	}

}
