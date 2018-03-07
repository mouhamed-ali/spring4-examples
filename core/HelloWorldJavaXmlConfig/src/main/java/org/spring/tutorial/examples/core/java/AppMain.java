package org.spring.tutorial.examples.core.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
 
public class AppMain {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        HelloWorld bean = (HelloWorld) context.getBean("helloWorldBean");
        bean.sayHello("Spring 4 - Java");
        bean = (HelloWorld) context.getBean("helloWorld2");
        bean.sayHello("Spring 4 - Java - 2");
        context.close();
    }
 
}
