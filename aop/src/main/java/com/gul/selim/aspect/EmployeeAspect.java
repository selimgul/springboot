package com.gul.selim.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {

	@Before(value = "execution(* com.gul.selim..*.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Before method:");
		LogArgs(joinPoint);
	}

	@After(value = "execution(* com.gul.selim..*.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("After method:");
		LogArgs(joinPoint);
	}
	
	private void LogArgs(JoinPoint joinPoint)
	{
		System.out.println("Method signature: " + joinPoint.getSignature());		

		System.out.println("Parameters:");
		
		for(Object p:joinPoint.getArgs())
		{
			System.out.println(p);
		}		
	}
}
