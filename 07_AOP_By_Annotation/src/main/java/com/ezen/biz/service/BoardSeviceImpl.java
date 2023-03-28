package com.ezen.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Service("boardService")
public class BoardSeviceImpl implements BoardService {

	@Autowired
	private BoardDAO bDao;
	
	@Override
	public void insertBoard(BoardVO board) {
//		if(board.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 등록 할 수 없습니다");
//		}
		
		bDao.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardVO board) {
		
		bDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(BoardVO board) {
		
		bDao.deleteBoard(board);
	}

	@Override
	public BoardVO getBoard(BoardVO board) {
		
		return bDao.getBoard(board);
	}

	@Override
	public List<BoardVO> getBoardList() {
		
		return bDao.getBoardList();
	}

}
