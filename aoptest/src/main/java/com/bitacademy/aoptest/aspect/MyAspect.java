package com.bitacademy.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// AOP 설정 여기에 다 있어야한다.
@Component
@Aspect
public class MyAspect {

	  //point cut : 접근 지시자 리턴타입 패키지.클래스.메서드(파라미더...) throws XXException 다 적어줘야한다.
	@Before("execution(public com.bitacademy.aoptest.vo.ProductVo com.bitacademy.aoptest.service.ProductService.find(String))") 
	public void adviceBefore() {
		System.out.println("--- Before Advice ---");
	}
	
	
	// point cut 축약  (접근 지시자 생략가능)
	@After("execution( com.bitacademy.aoptest.vo.ProductVo com.bitacademy.aoptest.service.ProductService.find(String))") 
	public void adviceAfter() {
		System.out.println("--- After Advice ---");
	}
	
	
	
	// point cut 축약 (리턴 타입은 모든 리턴타입으로, 패키지 이름도 처음부터 끝까지)
	@AfterReturning("execution( * *..*.ProductService.find(String))") 
	public void adviceAfterReturning() {
		System.out.println("--- After Returning Advice ---");
	}
	
	// point cut 축약 (파라미터 축약)
	@AfterThrowing(value = "execution( * *..*.ProductService.find(..))", throwing="ex") 
	public void adviceAfterThrowing(Throwable ex) {								//모든 exception은 Throwable이라는 인터페이스 구현
		System.out.println("--- After Throwing Advice : " + ex + "---");
	}
	
	
	//Around는 point-cut을 설정해줘야한다. ProceedingJoinPoint로 설정한다.
	@Around("execution( * *..*.ProductService.*(String))") 
	public Object adviceAround(ProceedingJoinPoint pjp) throws Throwable {
		
		/* before */
		System.out.println("--- Around(Before) Advice ---");
		
	
		
		// Point Cut Method 실행
//////////////// 파라미터를 변경가능
//		Object[] parameters = {"Camera"};
//		Object result = pjp.proceed(parameters);
	
		Object result = pjp.proceed();
		
		/* after */
		System.out.println("--- Around(After) Advice ---");
		
		return result;
	}
	
}
