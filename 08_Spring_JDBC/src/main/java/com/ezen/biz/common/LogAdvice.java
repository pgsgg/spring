package com.ezen.biz.common;

import org.springframework.stereotype.Service;

@Service
public class LogAdvice {
	public void printLog() {
		System.out.println("[공통로그]비즈니스 로직 수행 전 작업...");
	}
}
