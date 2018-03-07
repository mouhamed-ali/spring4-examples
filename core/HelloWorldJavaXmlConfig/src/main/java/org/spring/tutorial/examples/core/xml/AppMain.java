package org.spring.tutorial.examples.core.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("helloworld-config.xml");
        HelloWorld bean = (HelloWorld) context.getBean("helloWorldBean");
        bean.sayHello("Spring 4 - XML");
        context.close();
 
    }
 
}
