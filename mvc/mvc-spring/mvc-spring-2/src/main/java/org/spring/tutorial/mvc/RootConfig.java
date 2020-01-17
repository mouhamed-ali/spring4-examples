package org.spring.tutorial.mvc;

import org.spring.tutorial.mvc.service.IUserService;
import org.spring.tutorial.mvc.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

    @Bean
    public IUserService userService() {

        return new UserServiceImpl();
    }
}
