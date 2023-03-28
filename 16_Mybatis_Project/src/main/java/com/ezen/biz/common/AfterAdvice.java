package com.ezen.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	
	@After("PointcutCommon.allPointcut()")
	public void afterLog() {
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 처리할 내용...");
	}
}
