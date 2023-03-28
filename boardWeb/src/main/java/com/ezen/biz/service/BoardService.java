package com.ezen.biz.service;

import java.util.List;

import com.ezen.biz.dto.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO vo);

	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	BoardVO getBoard(BoardVO vo);

	List<BoardVO> getBoardList();

}