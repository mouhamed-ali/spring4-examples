package org.spring.tutorial.examples.core.jsr330;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext; 


@Configuration
@ComponentScan(basePackages={"org.spring.tutorial.examples.core.jsr330"})
/*
 * JSR-330 standardizes annotations like @Inject and the Provider interfaces for Java platforms.
 */
public class AppMain {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppMain.class);
        AccountServices bean = (AccountServices) context.getBean("accountServices");
        System.out.println(bean.returnHowMuchDoIHave());
        context.close();
    }
 
}
