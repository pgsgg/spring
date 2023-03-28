package com.ezen.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("게시글 목록 검색 처리");
		
		//DB 연동 처리
		BoardDAO boardDao = new BoardDAO();
		List<BoardVO> boardList = boardDao.getBoardList();
		
		//검색결과를 session에 저장
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		//결과를 출력할 화면 지정
		return "getBoardList";
	}

}
