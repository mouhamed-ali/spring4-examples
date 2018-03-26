package org.spring.tutorial.examples.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages =
				{"org.spring.tutorial.examples.rest.web.controllers",
				"org.spring.tutorial.examples.rest.dao"}
				)
public class AppConfig {

	/*
	 * using @EnableWebMvc, @ComponentScan and @Configuration annotations. These will bootstrap the spring mvc application and set package to scan controllers and resources.
	 *
	 * we have added jackson to the class path (pom.xml) so the service rest will be of type json (if we add jaxb2 it will be of type xml)
	 * 
	 * com.spring.tutorial.rest.web.controllers : web controllers package
	 */
}
