package org.spring.tutorial.examples.core.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
 
@Configuration
public class HelloWorldConfig {
 
    @Bean(name="helloWorldBean")
    @Description("This is a sample HelloWorld Bean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }

    @Bean//bean name = method name
    public HelloWorld helloWorld2() {
        return new HelloWorldImpl();
    }
}
