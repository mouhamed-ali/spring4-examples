package org.spring.tutorial.examples.core;

import org.spring.tutorial.examples.core.dao.UserDaoImpl;
import org.spring.tutorial.examples.core.domain.User;
import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Scanner;

public class AppMain {

    static String getProfile() {

        Scanner userChoice = new Scanner(System.in);
        System.out.println("Enter a profile : \n 1) development \n 2) qualification \n 3) production \n otherwise we gonna select the default profile");

        String profile = userChoice.nextLine();  // Read user input
        System.out.println("The profile is: " + profile);  // Output user input
        switch (profile) {
            case "1":
                return "dev";
            case "2":
                return "qualif";
            case "3":
                return "prod";
            default:
                return "default";
        }
    }

    public static void main(String args[]) {


        String profile = getProfile();

        System.setProperty("spring.profiles.active", profile);

        /*
         * for web applications there is a configuration based on the web.xml file for profile activation
         * based on the selected profile spring will use the right config file
         * dev -> DevConfig
         * qualif -> QualifConfig
         * prod -> ProdConfig
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
