package org.spring.tutorial.examples.rest.war;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
/*
    the @EnableWebMvc allows in the case of the rest to detect the existence of jaxb in the classpath
    and create a default JSON and XML converters
    when using a more complex configuration it is advisable to remove the annotation
    and expand the WebMvcConfigurationSupport class
 */
@ComponentScan("org.spring.tutorial.examples.rest.war.controller")
public class WebConfig {

}
