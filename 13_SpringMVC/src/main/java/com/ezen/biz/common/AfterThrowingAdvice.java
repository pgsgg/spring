package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
@Service
@Aspect
public class AfterThrowingAdvice {
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()",throwing="exceptObj")
	public void exceptionLog(JoinPoint jp,Exception exceptObj) {
		String method = jp.getSignature().getName();
		
		System.out.printf("[예외 처리] %s() 수행중 예외 발생 : %s\n",method,exceptObj.getMessage());
	}
}
