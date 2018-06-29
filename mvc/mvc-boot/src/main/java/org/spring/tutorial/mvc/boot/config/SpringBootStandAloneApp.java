package org.spring.tutorial.mvc.boot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("org.spring.tutorial.mvc.boot.controllers")
/*
 * OR JUST USE @SpringBootApplication(scanBasePackages={"com.websystique.springboot"})
 * same as @Configuration @EnableAutoConfiguration @ComponentScan combined
 */
public class SpringBootStandAloneApp {

    public static void main(String[] args) {

        /*
         * This class is annotated with @EnableAutoConfiguration & @ComponentScan.
         * Spring Boot @EnableAutoConfiguration attempts to automatically configure your Spring application
         * based on the jar dependencies that you have added.
         * Since we have added spring-boot-starter-web, Spring boot will setup the Spring configuration for a web-application.
         * @ComponentScan is as usual helps locate the spring beans the app would need.
         */
        SpringApplication.run(SpringBootStandAloneApp.class, args);
    }

}
