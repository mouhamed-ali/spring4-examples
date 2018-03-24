package org.spring.tutorial.examples.junit.xml.config;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:helloworld-config.xml")
public class HelloWorldImplTest2 {

	@Autowired
	HelloWorldImpl helloWorld;
	
	@Test
	@DirtiesContext
	public void loadingTest_1(){

		System.out.println("Test > loadingTest_1");
		helloWorld.sayHello();
		helloWorld.setName("Test Loading 1 ...");
		helloWorld.sayHello();
		System.out.println(helloWorld.toString());
	}
	
	@Test
	@DirtiesContext
	public void loadingTest_2(){

		System.out.println("Test > loadingTest_2");
		helloWorld.sayHello();
		helloWorld.setName("Test Loading 2 ...");
		helloWorld.sayHello();
		System.out.println(helloWorld.toString());
	}

	/*
	 * spring used a different bean in every test method
	 */
}
