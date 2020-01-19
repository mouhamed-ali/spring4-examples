package org.spring.tutorial.examples.junit;

import org.spring.tutorial.examples.junit.entities.Customer;
import org.spring.tutorial.examples.junit.service.impl.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static final void main(String[] args){
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
		   
		CustomerServiceImpl service = (CustomerServiceImpl) applicationContext.getBean("customerServiceImpl");
	
		Customer c = service.getById(2L);
		
		System.out.println(c);
	}
}
