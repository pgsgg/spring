package com.ezen.biz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

//@Repository("boardDAO")
public class BoardDAO extends SqlSessionDaoSupport {

	/*
	 * 부모클래스의 세션 생성메소드를 호출하여 데이터베이스에 연결할 세션 생성
	 */
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	// 게시글 등록
	public void insertBoard(BoardVO board) {
		// getSqlSession() : 부모 클래스에 정의된 데이터베이스 세션 제공 메소드
		getSqlSession().insert("boardMapper.insertBoard", board);
	}

	// 게시글 수정
	public void updateBoard(BoardVO board) {
		getSqlSession().update("boardMapper.updateBoard", board);
	}

	// 게시글 삭제
	public void deleteBoard(BoardVO board) {
		getSqlSession().delete("boardMapper.deleteBoard", board);
	}

	// 게시글 상세 조회
	public BoardVO getBoard(BoardVO board) {

		return getSqlSession().selectOne("boardMapper.getBoard", board);
	}

	// 게시글 목록 조회
	public List<BoardVO> getBoardList(BoardVO board) {

		return getSqlSession().selectList("boardMapper.getBoardList", board);
	}

}
