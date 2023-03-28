package com.ezen.view.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

@Controller
public class LoginController{
	@RequestMapping("/login.do")
	public ModelAndView login(UserVO vo,UserDAO userDAO,ModelAndView modelView) {
			System.out.println("로그인 처리");
				
			vo = userDAO.getUser(vo);
			// 3. 화면 네비게이션
			if (vo != null) {
				modelView.setViewName("getBoardList.do");
			} else {
				modelView.setViewName("login.jsp");
			}
			return modelView;
	}

}
