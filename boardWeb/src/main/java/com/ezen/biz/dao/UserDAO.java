package com.ezen.biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.UserVO;
import com.ezen.biz.service.UserService;
@Repository
public class UserDAO implements UserService {
	//JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	//SQL 명령어들
	private final String USER_GET = 
			"SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	@Override
	public UserVO getUser(UserVO vo) {
		UserVO u = null;
		conn = JDBCUtil.getConnection();
		try {
			
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				u = new UserVO();
				u.setId(rs.getNString("id"));
				u.setPassword(rs.getNString("password"));
				u.setName(rs.getNString("name"));
				u.setRole(rs.getNString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return u;
	}
}
