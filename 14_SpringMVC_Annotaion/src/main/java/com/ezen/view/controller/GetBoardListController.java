package com.ezen.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Controller
public class GetBoardListController {
	@RequestMapping(value = "/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo,BoardDAO boardDAO,ModelAndView modelView) {
		System.out.println("게시글 목록 검색 처리");

		// DB 연동 처리
		List<BoardVO> boardList = boardDAO.getBoardList();

		// 결과를 출력할 화면 지정
		modelView.addObject("boardList", boardList);
		modelView.setViewName("getBoardList.jsp");

		return modelView;
	}

}
