package org.spring.tutorial.examples.core.beans;

import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
 
public class AppMain {
 
    public static void main(String args[]) {

        System.setProperty("JAVA_HOME", "/dummy/path");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                ConfigClass.class,
                AnotherConfigClass.class
        );
        PropertiesWrapper propertiesWrapper = (PropertiesWrapper) context.getBean("propertiesWrapper");
        propertiesWrapper.showProperties();
        context.destroy();
        System.clearProperty("JAVA_HOME");
    }
 
}
