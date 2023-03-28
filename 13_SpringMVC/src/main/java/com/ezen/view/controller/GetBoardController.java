package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("상세 게시글 조회");
		
		// 게시글 번호 입력값 추출
		String seq = request.getParameter("seq");

		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDao = new BoardDAO();
		BoardVO board = boardDao.getBoard(vo);
		
		//ModelAndView에 저장
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("getBoard");
		modelView.addObject("board",board);
		return modelView;
	}

}
