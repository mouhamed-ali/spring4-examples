package org.spring.tutorial.examples.core.start;

import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:database_configuration.properties")
public class ConfigClass1 {

	@Autowired
	Environment environment;

	@Bean
	public PropertiesWrapper propertiesWrapper() {

		PropertiesWrapper propertiesWrapper = new PropertiesWrapper();
		propertiesWrapper.setProperty(environment.getProperty("db.user"));
		propertiesWrapper.setProperty(environment.getProperty("db.password"));
		return propertiesWrapper;
	}
}
