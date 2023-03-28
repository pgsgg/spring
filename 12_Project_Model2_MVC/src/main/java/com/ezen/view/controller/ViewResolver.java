package com.ezen.view.controller;

public class ViewResolver {
	public String prefix; // jsp 파일의 경로
	public String suffix; // 파일 확장자

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/*
	 * view 파일의 경로와 확장자를 결합 입력 파라미터 : getView : 컨트롤러에서 전달된 화면명
	 */
	public String getView(String viewName) {

		return prefix + viewName + suffix;
	}
}
