package com.ezen.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogingViewController {

	@RequestMapping(value = "/loginView.do")
	public String handleRequest() {
		
		return "login.jsp";
	}

}
