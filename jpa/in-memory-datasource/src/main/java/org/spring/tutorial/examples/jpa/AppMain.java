package org.spring.tutorial.examples.jpa;

import org.spring.tutorial.examples.jpa.dao.UserDaoImpl;
import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
 
public class AppMain {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        UserDaoImpl dao = (UserDaoImpl) context.getBean("userDaoImpl");
        User user = dao.getUserById(1);
        System.out.println(user);
        context.destroy();
    }
 
}
