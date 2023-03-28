package com.ezen.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.biz.dao.UserDAO2;
import com.ezen.biz.dto.MemberVO;
import com.ezen.biz.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	/*
	 * 로그인 화면 출력 
	 */
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") MemberVO vo) {
		
		vo.setId("user1");
		vo.setPassword("1234");
		
		return "login.jsp";
	}

	/*
	 * 로그인 처리
	 */
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session) {

		System.out.println("로그인 처리 ");
		
		// 예외처리 예제
		// 화면에서 id 또는 password가 입력되지 않았을 경우 예외 페이지 표시
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해 주세요!");
		}
		
		MemberVO user = userService.getUser(vo);
		
		if (user != null) { // 로그인 성공시
			session.setAttribute("userName", user.getName());
			
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {

		// 1. 세션 객체 종료
		session.invalidate();
		
		return "login.jsp";
	}
}
