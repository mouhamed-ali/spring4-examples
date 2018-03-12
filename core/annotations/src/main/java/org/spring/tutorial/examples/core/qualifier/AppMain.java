package org.spring.tutorial.examples.core.qualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext; 


@Configuration
@ComponentScan
/*
 * spring will scan the com.spring.tutorial.annotations.qualifier package
 */
public class AppMain {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppMain.class);
        AccountServices bean = (AccountServices) context.getBean("myAccountServiceApi");
        System.out.println(bean.returnHowMuchDoIHave());
        context.close();
    }
 
}
