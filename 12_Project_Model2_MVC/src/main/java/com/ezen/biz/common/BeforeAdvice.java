package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect // 포인트컷과 어드바이스를 결합하는 설정
public class BeforeAdvice {
	// 포인트컷 선언
//	@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
//	public void allPointcut() {
//	}
	

	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		if (args.length > 0)
			System.out.printf("[사전 처리1] 비즈니스 로직 수행 전 처리 메소드 : %s() 매개변수 : %s\n", method, args[0].toString());
		else
			System.out.printf("[사전 처리1] 비즈니스 로직 수행 전 처리 메소드 : %s() 매개변수 : 매개변수 없음\n", method);
	}
}
