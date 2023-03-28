package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Logout implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// 1. 세션 객체 종료
		session.invalidate();

		// 2. 로그인 화면으로 이동
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("login");
		return modelView;
	}

}
