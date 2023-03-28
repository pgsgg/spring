package com.ezen.biz.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.service.BoardService;
@Repository
public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//게시글 등록
/*		
 * for(int i=0; i<10;i++) {
		BoardVO board = new BoardVO();
		board.setTitle("게시글 제목" + i);
		board.setWriter("작성자"+ i);
		board.setContent(i+"번째 게시글 입니다.");
			
		boardService.insertBoard(board);
		}*/
		List<BoardVO> list = boardService.getBoardList();
		for(BoardVO vo : list) {
			System.out.println(vo.toString());
		}
		
		
		
	}

}
