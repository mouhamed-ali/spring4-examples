package org.spring.tutorial.examples.junit.xml.config;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class AppMain {
 
    public static void main(String args[]) {
       
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("helloworld-config.xml");
        HelloWorldImpl bean = (HelloWorldImpl) context.getBean("helloWorldBean");
        bean.setName("Spring Core Hello Loading ...");
        bean.sayHello();
        context.close();
    }
 
}
