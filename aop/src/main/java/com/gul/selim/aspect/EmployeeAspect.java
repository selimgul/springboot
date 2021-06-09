package com.gul.selim.aspect;

import java.util.Arrays;

import org.apache.tomcat.util.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {

    @Pointcut ("@annotation(com.gul.selim.aspect.Loggable)")
    protected void isLoggableMethod() {}

	@Pointcut ("execution(* com.gul.selim.controller.*.*(..))")
    protected void controllerMethods() {}


	@Before(value = "controllerMethods()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Before advice");
		LogMethodInvoke(joinPoint, null);
	}

	@After(value = "controllerMethods()")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("After advice");
		LogMethodInvoke(joinPoint, null);
	}
	
	@AfterReturning(value = "controllerMethods()", returning = "emp")
	public void afterReturningAdvice(JoinPoint joinPoint, String emp) {
		System.out.println("After Returning advice");
		LogMethodInvoke(joinPoint, emp);
	}
	
	@AfterThrowing(pointcut = "controllerMethods()", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {        
		System.out.println("After Throwing advice");
		LogMethodInvoke(joinPoint, exception.getMessage());
    }
	
	@Around(value = "isLoggableMethod()")
	public Object aroundAdvice(ProceedingJoinPoint  joinPoint) throws Throwable {
		Object resp; 

		System.out.println("Around advice method started");
		try {
			resp = joinPoint.proceed();
			LogMethodInvoke(joinPoint, resp);
		} finally{			
		}		
		System.out.println("Around advice method completed");		

		return resp;
	}
		
	private void LogMethodInvoke(JoinPoint joinPoint, Object resp)
	{
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String className  = signature.getDeclaringTypeName();
		String methodName = signature.getName();
		String request    = Arrays.toString(joinPoint.getArgs());
		
		System.out.println(String.format("Service log=> Class: %s, Method: %s, Args: %s, Resp: %s", className, methodName, request, resp));
	}
}
