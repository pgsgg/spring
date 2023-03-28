package com.ezen.view.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Controller
public class BoardController {
	/*
	 * 글 등록 기능
	 */
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("게시글 등록 처리...");

		boardDAO.insertBoard(vo);
		return "getBoardList.do";

	}

	/*
	 * 글 수정 기능
	 */
	@RequestMapping(value = "updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);

		return "getBoardList.do";
	}
	/*
	 * 글 삭제 기능
	 */
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);

		return "getBoardList.do";
	}
	/*
	 * 글 상세 보기
	 */
	@RequestMapping(value = "/getBoard.do")
	public ModelAndView getBoard(BoardVO vo,BoardDAO boardDAO) {
		System.out.println("상세 게시글 조회");

	
		vo = boardDAO.getBoard(vo);
		
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("getBoard.jsp");
		modelView.addObject("board",vo);
		return modelView;
	}
	/*
	 * 글 리스트 
	 */
	@RequestMapping(value = "/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo,BoardDAO boardDAO,ModelAndView modelView) {
		System.out.println("게시글 목록 검색 처리");

		List<BoardVO> boardList = boardDAO.getBoardList();

		modelView.addObject("boardList", boardList);
		modelView.setViewName("getBoardList.jsp");

		return modelView;
	}
}
