package org.spring.tutorial.examples.junit.config;

import org.spring.tutorial.examples.junit.dao.CustomerDao;
import org.spring.tutorial.examples.junit.dao.impl.CustomerDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"org.spring.tutorial.examples.junit.service.impl"})
public class Application {
	
	@Bean
	public CustomerDao customerDao(){
		return new CustomerDaoImpl();
	}
}
