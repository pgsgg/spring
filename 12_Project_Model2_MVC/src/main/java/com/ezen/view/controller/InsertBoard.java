package com.ezen.view.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class InsertBoard implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 사용자 입력 정보 추출
					System.out.println("게시글 등록 처리...");
					try {
						request.setCharacterEncoding("UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					String title = request.getParameter("title");
					String writer = request.getParameter("writer");
					String content = request.getParameter("content");
					
					// 2. DB 연동 처리
					BoardVO vo = new BoardVO();
					vo.setTitle(title);
					vo.setWriter(writer);
					vo.setContent(content);
					
					BoardDAO boardDAO = new BoardDAO();
					boardDAO.insertBoard(vo);
					
					// 3. 화면 네비게이션
					return "getBoardList.do";
	}

}
