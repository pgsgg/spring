package com.ezen.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;
@Controller
public class UpdateBoard {
	@RequestMapping(value = "updateBoard.do")
	public String updateBoard(BoardVO vo,BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);

		return "getBoardList.do";
	}

}
