package org.spring.tutorial.examples.core.postConstructPreDestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext; 


@Configuration
@ComponentScan
public class AppMain {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppMain.class);

        /*
         * if we do not use the prototype bean it will not be created
         * this is not the case for the singleton
         * uncomment the code and see
         */
        //PrototypeObject beanP = (PrototypeObject) context.getBean("prototypeObject");
        
        context.close();
    }

    @Bean(initMethod="init",destroyMethod="destroy")
    public BeanObject createBean(){
    	
    	return new BeanObject();
    }
 
}
