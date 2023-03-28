package com.ezen.biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.service.BoardService;

@Repository("boardDAO")
public class BoardDAO implements BoardService{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	// SQL 명령어 상수
	private static final String BOARD_INSERT = "INSERT INTO BOARD (SEQ,TITLE,WRITER,CONTENT) VALUES (BOARD_SEQ.NEXTVAL,?,?,?)";
	private static final String BOARD_UPDATE = "UPDATE BOARD SET TITLE = ? AND WRITER = ? AND CONTENT = ? WHERE SQE = ?";
	private static final String BOARD_DELTE = "DELETE FROM BOARD WHERE SEQ = ?";
	private static final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ = ?";
	private static final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";

	// 게시글 등록 메소드
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getSeq());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(BOARD_DELTE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO b = null;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				b = new BoardVO(rs.getInt("seq"), rs.getString("title"), rs.getString("writer"),
						rs.getString("content"), rs.getDate("regdate"), rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return b;
	}

	public List<BoardVO> getBoardList() {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		List<BoardVO> list = null;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<>();
				do {
					list.add(new BoardVO(rs.getInt("seq"), rs.getString("title"), rs.getString("writer"),
							rs.getString("content"), rs.getDate("regdate"), rs.getInt("cnt")));	
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
