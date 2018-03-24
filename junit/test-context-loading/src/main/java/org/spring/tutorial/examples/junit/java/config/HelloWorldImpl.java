package org.spring.tutorial.examples.junit.java.config;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldImpl {

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello() {
        System.out.println("Hello "+name);
    }
}
