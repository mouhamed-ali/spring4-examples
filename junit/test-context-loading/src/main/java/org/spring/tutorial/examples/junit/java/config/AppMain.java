package org.spring.tutorial.examples.junit.java.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
 
public class AppMain {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        HelloWorldImpl bean = (HelloWorldImpl) context.getBean("helloWorldImpl");
        bean.setName("Spring Context Loading ...");
        bean.sayHello();
        context.close();
    }
 
}
