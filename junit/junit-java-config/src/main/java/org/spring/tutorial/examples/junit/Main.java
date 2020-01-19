package org.spring.tutorial.examples.junit;

import org.spring.tutorial.examples.junit.config.Application;
import org.spring.tutorial.examples.junit.entities.Customer;
import org.spring.tutorial.examples.junit.service.impl.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static final void main(String[] args){
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
		
		CustomerServiceImpl service = (CustomerServiceImpl) applicationContext.getBean("customerServiceImpl");
		//bean name customerServiceImpl
	
		Customer c = service.getById(2L);
		
		System.out.println(c);
	}
}
