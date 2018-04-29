package org.spring.tutorial.rest.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
        scanBasePackages = {
                "org.spring.tutorial.rest.boot.controllers"
                ,
                "org.spring.tutorial.rest.boot.services.impl"
        }
)
// @SpringBootApplication == @Configuration + @EnableAutoConfiguration + @ComponentScan
public class SpringBootRestApiApp {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootRestApiApp.class, args);
    }

	/*
	 
	JSON REST service
	Any Spring @RestController in a Spring Boot application will render JSON response by default as long as 
	Jackson2 [jackson-databind] is on the classpath. In a web app [spring-boot-starter-web], it transitively gets included, 
	no need to explicitly include it.

	XML REST service
	For enabling XML representations, Jackson XML extension (jackson-dataformat-xml) must be present on the classpath. Add the following dependency to your project:
	<dependency>
    	<groupId>com.fasterxml.jackson.dataformat</groupId>
    	<artifactId>jackson-dataformat-xml</artifactId>
	</dependency>
	 
	 In Rest based design, resources are being manipulated using a common set of verbs.

	To Create a resource : HTTP POST should be used
	To Retrieve a resource : HTTP GET should be used
	To Update a resource : HTTP PUT should be used
	To Delete a resource : HTTP DELETE should be used
	That means, you as a REST service developer or Client, should comply to above criteria, in order to be REST complained.

	Often Rest based Web services return JSON or XML as response, although it is not limited to these types only. 
	Clients can specify (using HTTP Accept header) the resource type they are interested in, and server may return the resource , 
	specifying Content-Type of the resource it is serving. This StackOverflow[http://stackoverflow.com/questions/671118/what-exactly-is-restful-programming] link is a must read to understand REST in detail.

	 */
}







