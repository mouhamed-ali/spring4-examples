package org.spring.tutorial.examples.core;

import org.spring.tutorial.examples.core.dao.UserDaoImpl;
import org.spring.tutorial.examples.core.domain.User;
import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
 
public class AppMain {
 
    public static void main(String args[]) {

    	//choose the profile (you can use a system environment property)
    	System.setProperty("spring.profiles.active", "dev");
    	//System.setProperty("spring.profiles.active", "qualif");
    	//System.setProperty("spring.profiles.active", "prod");
    	
    	/*
    	 * for web applications there is a configuration based on the web.xml file
		 * for profile activation
    	 */
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				DefaultConfig.class,//always loaded. must be the first
    			DevConfig.class,//if the same is present in the DefaultConfig.class, spring will load the DevConfig.class bean
    			ProdConfig.class,
    			QualifConfig.class
    			);
    	
    	PropertiesWrapper propertiesWrapper = (PropertiesWrapper) context.getBean("propertiesWrapper");
        propertiesWrapper.showProperties();
        
        UserDaoImpl dao = (UserDaoImpl) context.getBean("userDaoImpl");
        User user = dao.getUserById(1);
        System.out.println(user);
       
        context.destroy();
        System.clearProperty("spring.profiles.active");
    }
 
}
