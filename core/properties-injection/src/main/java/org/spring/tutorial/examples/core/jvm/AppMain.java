package org.spring.tutorial.examples.core.jvm;

import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
 
public class AppMain {
 
    public static void main(String args[]) {
        
    	System.setProperty("java.version", "jdk1.8");
    	System.setProperty("db.user", "JVM");
    	System.setProperty("COMPUTERNAME", "JVM_USER");
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
        PropertiesWrapper propertiesWrapper = (PropertiesWrapper) context.getBean("propertiesWrapper");
        propertiesWrapper.showProperties();
        context.destroy();
        System.clearProperty("COMPUTERNAME");
        System.clearProperty("db.user");
        System.clearProperty("java.version");
        
        /*
         * spring checks : property files then system properties then the jvm properties.
         */
    }
 
}
