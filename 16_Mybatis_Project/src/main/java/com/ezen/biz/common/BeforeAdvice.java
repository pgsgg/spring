package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect   // 포인트컷과 어드바이스를 결합하는 설정
public class BeforeAdvice {
	// 포인트컷 선언부
//	@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
//	public void allPointcut() {}	
	
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();  // 비즈니스 로직 메소드명 추출
		Object[] args = jp.getArgs(); // 메소드에 입력된 매개변수의 내용을 반환
		
		if (args.length == 0) { // 매개변수가 없는 경우
			System.out.println("[사전 처리] " + method + "() 매개 변수: 없음");
		} else {  // 매개변수가 있는 경우
			System.out.println("[사전 처리] " + method + "() 매개 변수: " + args[0].toString());
		}
	}
}
