package com.ezen.biz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.dto.MemberVO;

@Repository("boardDAO")
public class BoardDAO2 {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 게시글 등록
	public void insertBoard(BoardVO board) {
		
		mybatis.insert("boardMapper.insertBoard", board);
	}
	
	// 게시글 수정
	public void updateBoard(BoardVO board) {
		mybatis.update("boardMapper.updateBoard", board);
	}
	
	// 게시글 삭제
	public void deleteBoard(BoardVO board) {
		mybatis.delete("boardMapper.deleteBoard", board);
	}
	
	// 게시글 상세 조회
	public BoardVO getBoard(BoardVO board) {
		
		return mybatis.selectOne("boardMapper.getBoard", board);
	}
	
	// 게시글 목록 조회
	public List<BoardVO> getBoardList(BoardVO board) {
		
		return mybatis.selectList("boardMapper.getBoardList", board);
	}

}







