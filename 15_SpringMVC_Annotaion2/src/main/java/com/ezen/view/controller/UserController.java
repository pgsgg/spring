package com.ezen.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

@Controller
public class UserController {
	/*
	 * 로그인 화면 출력
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView() {
		
		return "login.jsp";
	}
	/*
	 * 로그인 처리 기능 
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(UserVO vo,UserDAO userDAO,ModelAndView modelView) {
			System.out.println("로그인 처리");
				
			vo = userDAO.getUser(vo);
			// 3. 화면 네비게이션
			if (vo != null) {
				modelView.setViewName("getBoardList.do");
				modelView.addObject("uservo",vo);
			} else {
				modelView.setViewName("login.jsp");
			}
			return modelView;
	}
	/*
	 * 로그아웃 기능
	 */
	@RequestMapping(value = "logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		// 1. 세션 객체 종료
		session.invalidate();
		
		// 2. 로그인 화면으로 이동
		return "login.jsp";
	}
}
