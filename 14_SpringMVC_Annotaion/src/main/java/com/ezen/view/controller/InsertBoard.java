package com.ezen.view.controller;


import java.io.UnsupportedEncodingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Controller
public class InsertBoard {
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo,BoardDAO boardDAO) throws UnsupportedEncodingException {
		System.out.println("게시글 등록 처리...");

		boardDAO.insertBoard(vo);
		return "getBoardList.do";
		
	}

}
