package com.ezen.view.controller;

import java.util.*;

public class HandlerMapping {
	//url 여청에 대한 대응하는 클래스 정보를 저장
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoard());
		mappings.put("/updateBoard.do", new UpdateBoard());
		mappings.put("/deleteBoard.do", new DeleteBoard());
		mappings.put("/logout.do", new Logout());
	}
	
	/*
	 * url 키에 대해 Controller 객체를 제공하는 메소드
	 */
	public Controller getController(String path) {
		
		return mappings.get(path);
	}
}
