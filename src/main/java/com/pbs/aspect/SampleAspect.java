package com.pbs.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SampleAspect{
	
	@Pointcut("execution(* com.pbs.service.FormOptionsService.getCountryOptions(..))")
	public void getCountryOptions() {}
	
	@Around("getCountryOptions()")
	public Object testing(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("I am in...");
		return pjp.proceed();
	}

}
