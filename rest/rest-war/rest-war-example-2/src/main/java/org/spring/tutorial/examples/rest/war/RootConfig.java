package org.spring.tutorial.examples.rest.war;

import org.spring.tutorial.examples.rest.war.service.BookServiceImpl;
import org.spring.tutorial.examples.rest.war.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

    @Bean
    public UserServiceImpl getUserBusinessLayer() {
        return new UserServiceImpl();
    }

    @Bean
    public BookServiceImpl getBookBusinessLayer() {
        return new BookServiceImpl();
    }
}
