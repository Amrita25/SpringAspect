package com.spring.aspect.SpringAspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aspect.service.LoggingService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");
    	LoggingService loggingservice= appContext.getBean("loggingservice",LoggingService.class);

    	//System.out.println(loggingservice.getCircle().getName());
    	//loggingservice.getCircle().setName("amrita");
    	//loggingservice.getTriangle().getName();
    	//loggingservice.getCircle().print("abc");
    	//loggingservice.getCircle().setNameandReturn("Amri");
    	System.out.println("loggingservice.getCircle().setNameandReturn => : "+loggingservice.getCircle().setNameandReturn("Old Value"));
    	loggingservice.getTriangle().myTriangle();
    }
}
