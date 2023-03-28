package com.ezen.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Logout {

	@RequestMapping(value = "logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		// 1. 세션 객체 종료
		session.invalidate();
		
		// 2. 로그인 화면으로 이동
		return "login.jsp";
	}

}
