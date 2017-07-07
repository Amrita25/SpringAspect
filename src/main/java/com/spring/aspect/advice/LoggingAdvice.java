package com.spring.aspect.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LoggingAdvice {
	
	@Before("execution(public String getName())")
	public void logmessage(){
		System.out.println("Advice before Get method");
	}

}
