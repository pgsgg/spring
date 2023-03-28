package com.ezen.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;
@Controller
public class GetBoardController {
	@RequestMapping(value = "/getBoard.do")
	public ModelAndView handleRequest(BoardVO vo,BoardDAO boardDAO) {
		System.out.println("상세 게시글 조회");

	
		vo = boardDAO.getBoard(vo);
		
		//ModelAndView에 저장
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("getBoard.jsp");
		modelView.addObject("board",vo);
		return modelView;
	}

}
