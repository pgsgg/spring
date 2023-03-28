package com.ezen.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ezen.biz.dto.MemberVO;
import com.ezen.biz.dto.QnaVO;
import com.ezen.biz.service.QnaService;

@Controller
@SessionAttributes("loginUser")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	/*
	 * 특정 회원의 qna 목록 조회
	 */
	@GetMapping("/qna_list")
	public String listQnaView(HttpSession session, Model model) {
		// 사용자로그인확인
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			return "member/login";
		} else {
			//사용자 아디리를 매개변수로 QNA 목록 조회
			List<QnaVO> qnaList = qnaService.getListQna(loginUser.getId());
			//화면에 전달할 데이터를 "qnaList" 속성으로 저장
			model.addAttribute("qnaList", qnaList);
			// qna/qnaList.jsp 표시
			return "qna/qnaList";
		}
	}
	
	/*
	 * qna 게시글 상세보기
	 */
	@GetMapping("qna_view")
	public String qnaView(HttpSession session,Model model,QnaVO vo) {
		// 사용자로그인확인
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			return "member/login";
		} else {
			QnaVO qnavo = qnaService.getQna(vo.getQseq());
			model.addAttribute("qnaVO", qnavo);
			return "qna/qnaView";
		}
	}
	
	@GetMapping("/qna_write_form")
	public String qnaWriteView(HttpSession session) {
		// 사용자로그인확인
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			return "member/login";
		} else {
		return "/qna/qnaWrite";
		}
	}
	
	@PostMapping("/qna_write")
	public String qnaWriteAction(QnaVO vo,HttpSession session) {
		// 사용자로그인확인
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			qnaService.insertQna(vo);
			
			return "redirect:qna_list";
		}
	}

	
	
}
