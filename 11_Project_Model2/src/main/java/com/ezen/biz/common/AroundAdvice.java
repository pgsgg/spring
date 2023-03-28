package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
@Service
@Aspect
public class AroundAdvice {
	@Around("PointcutCommon.allPointcut()")
	public Object arounLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		//메소드 실행시간을 측정하기 위해 StopWatch 클래스 사용
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		Object returnObj = pjp.proceed(); // 비즈니스 메소드 호출하여 실행
		stopwatch.stop();
		
		System.out.printf("[AROUND] : 메소드명 : %s(), 수행에 걸린시간 : %d(ms)\n",method,stopwatch.getTotalTimeMillis());
		
		return returnObj;
	}
}
