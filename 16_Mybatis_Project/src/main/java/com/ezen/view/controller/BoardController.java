package com.ezen.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.service.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	/*
	 * 글 등록 기능
	 */
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println("게시글 등록 처리... ");
		
		MultipartFile uploadFile = vo.getUploadFile();
		
		if (!uploadFile.isEmpty()) { // 파일이 입력된 경우
			// 파일명을 얻어와 테이블에 저장할 용도로 사용
			String fileName = uploadFile.getOriginalFilename();
			// 실제 파일은 디스크의 특정 경로에 이동
			uploadFile.transferTo(new File("D:/upload/" + fileName));
			System.out.println("업로드 파일명:"+fileName);
		}
		
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
	}

	/*
	 * 글 수정 기능
	 * @ModelAttribute - 세션 내장객체에 저장된 내용이 vo 객체에 저장됨.
	 */
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {

		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	/*
	 * 글 삭제 기능 
	 */
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {

		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("상세 게시글 조회 ");
		
		BoardVO board = boardService.getBoard(vo);
		
		// 응답 화면 구성
		// @SessionAttributes 사용 시,
		// model  객체에 저장됨과 동시에 session 내장객체에도 저장됨.
		model.addAttribute("board", board);
		
		return "getBoard.jsp"; // View 이름을 리턴 
	}
	
	/*
	 * 검색조건 목록값을 Model 객체에 저장 
	 */
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<>();
		
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(
//			@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
//			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
			BoardVO vo,
			Model model) {
		System.out.println("게시글 목록 검색 처리");
		
		// Null Check
		if (vo.getSearchCondition() == null) 
			vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		System.out.println("검색 조건:"+vo.getSearchCondition());
		System.out.println("검색 키워드:" + vo.getSearchKeyword());
		
		// DB 연동 처리
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		// 결과를 출력할 화면 지정 
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
	@RequestMapping(value="/dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		return boardList;
	}
	
	@RequestMapping(value="/dataTransform_xml.do")
	@ResponseBody
	public List<BoardVO> dataTransformXML(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		return boardList;
	}
}





