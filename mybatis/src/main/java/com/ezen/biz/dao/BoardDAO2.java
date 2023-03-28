package com.ezen.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

@Repository("boardDAO")
public class BoardDAO2 {

	@Autowired
	private SqlSessionTemplate mybatis;

	// 게시글 등록
	public void insertBoard(BoardVO board) {
		// getSqlSession() : 부모 클래스에 정의된 데이터베이스 세션 제공 메소드
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
