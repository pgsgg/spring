package com.ezen.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.dto.UserVO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;

	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Process(request, response);
	}

	private void Process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// (1) 클라이언트의 요청분석
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf('/'));

		// (2) HandlerMapping을 통해 path에 해당하는 Controller 검색
		Controller controller = handlerMapping.getController(path);

		// (3) 검색된 Controller를 이용해해당 업무를 처리한ㄴ다
		String viewName = controller.handleRequest(request, response);

		// (4) viewResolver를 이용하여 view경로와 이름을 조헙
		String view = "";
		if (viewName.contains(".do")) {// .do 일경우
			view = viewName;
		} else { 
			view = viewResolver.getView(viewName);
		}
		
		//(5) 사용자에게 응답
		response.sendRedirect(view);
	}
}
