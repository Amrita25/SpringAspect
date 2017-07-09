package com.spring.aspect.advice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.spring.aspect.model.Circle;


@Aspect
public class LoggingAdvice {
	
	/*@Before("execution(public String com.spring.aspect.model.Circle.getName())")
	public void logmessage(){
		System.out.println("Advice before Get method");
	}*/

	/*@Before("allGetters() && allCirlcleMethods()")
	public void logmessage(){
		System.out.println("Advice before Get method of circle");
	}*/
	
//************************************************Advice methods************************************************************
	@Before("args(name)")
	public void stringArgumentMethods(String name){
		System.out.println("A method is called which takes string argument :"+name);
	}
	
	
	@Before("allCirlcleMethods() && allGetters()")
	public void secondAdvice(JoinPoint point){
		System.out.println(point.toString());
		((Circle)point.getTarget()).setName("Set Name from advice method");
		System.out.println("Second Advice before Get method of circle");
	}
	
	@Before("allTrianglemethods() && allGetters()")
	public void thirdadvice(){
		System.out.println("Advice before Get method of Triangle");
	}
	
	//@After it executes after a method has run. no matter whether the method completes successfully or not
	//it acts like a finally in try-catch block
	@After("args(name)")
	public void stringArgumentMethod1(String name){
		System.out.println("After A method is called which takes string argument :"+name);
	}
	
	@AfterReturning("args(name)")//this advice is run only after the method compleets successfully
	public void stringArgumentMethod2(String name){
		System.out.println("After returning sucessfully A method is called which takes string argument :"+name);
	}
	
	//this advice will be executed on a method that takes one string argument and the return type is string
	@AfterReturning(pointcut="args(name)", returning ="returnString")
	public void stringArgumentMethod3(String name,String returnString){
		System.out.println("A method is called which takes a string arg "+name+" and the returned value is  "+returnString);
		
	}
	
	@AfterThrowing(pointcut="allCirlcleMethods()", throwing ="ex")
	public void exceptionAdvice(Exception ex){
		System.out.println("an exception is thrown "+ex+"******");
	}
	
	@Around("allSetters()")
	public Object myAroundAdvice(ProceedingJoinPoint joinPoint){
		
		Object obj=null;
		
		try {
			System.out.println("before advice");
			obj=joinPoint.proceed();
			obj="New Value"; // we can manupulate the returned value of a method
			System.out.println("after advice");
		} catch (Throwable e) {
			
			System.out.println("exception ");
		}
		System.out.println("finally block ");
		return obj; // target method will return the manupulated value 
	}
	
	@Before("@annotation(com.spring.aspect.advice.MyAnnotation)")
	public void customAnnotation(){
		System.out.println("Advice called before the annotated method");
	}
	
//****************************************************Point cuts************************************************************		
	
	@Pointcut("within(com.spring.aspect.model.Traingle)")
	public void allTrianglemethods(){
		
	}
	@Pointcut("execution(* set*(*))")// * => 1 or more arguments
	public void allSetters(){
		
	}
	
	@Pointcut("execution(* get*(..))") // .. => 0 or more than 0 arguments
	public void allGetters(){
		
	}
	
	@Pointcut("within(com.spring.aspect.model.Circle)")
	public void allCirlcleMethods(){
		
	}

}
