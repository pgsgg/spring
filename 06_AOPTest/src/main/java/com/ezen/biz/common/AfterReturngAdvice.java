package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
/*
 * 입력 매개변수 : 
 * 		returnobj : 비즈니스 메소드에서 리턴한 데이터를 저장
 */
public class AfterReturngAdvice {
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		System.out.printf("[사후 처리] 메소드 : %s, 리턴값 : %s\n",method,returnObj.toString());
	}
}
