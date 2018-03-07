package org.spring.tutorial.examples.core.system;

import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass1 {

	@Value("#{systemProperties['java.version']?:'1.4.12'}")
	/*
	 * if the property does not exist its default value will be 1.4.12
	 */
	String javaVersion;

	@Bean
	public PropertiesWrapper propertiesWrapper() {

		PropertiesWrapper propertiesWrapper = new PropertiesWrapper(); 
		propertiesWrapper.setProperty(javaVersion);
		return propertiesWrapper;
	}
}
