package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning = "returningObj")
	public void afterLog(JoinPoint jp,Object returningObj) {
		
		String method = jp.getSignature().getName();
		
		System.out.printf("[사후처리] 메소드명 : %s 리턴값: %s\n",method, returningObj.toString());
		
	}
}
