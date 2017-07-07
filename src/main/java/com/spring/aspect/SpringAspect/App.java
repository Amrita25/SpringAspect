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
    	loggingservice.getCircle().getName();
    }
}
