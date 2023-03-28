package com.ezen.biz.board;

import java.util.ArrayList;
import java.util.List;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.dto.UserVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		vo.setTitle("Mybatis 연습123");
		vo.setWriter("홍길동");
		vo.setContent("Mybatis를 이용한 MVC 구현");
		vo.setSearchKeyword("");
		
		boardDAO.insertBoard(vo);
		
		List<BoardVO> boardList = new ArrayList<>();
		boardList = boardDAO.getBoardList(vo);
		System.out.println("==> 게시글 목록");
		for(BoardVO board:boardList) {
			System.out.println(board.toString());
		}
		
		UserVO user = new UserVO();
		UserDAO userDAO = new UserDAO();
		
		user.setId("user1");
		user.setPassword("1234");
		UserVO user1 = userDAO.getUser(user);
		if(user1 != null) {
			System.out.println("로그인에 성공");
			System.out.println(user1.toString());
		} else {
			System.out.println("로그인 실패");
		}
	}

}
