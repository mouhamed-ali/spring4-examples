package org.spring.tutorial.examples.core.beans;

import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {
	
	@Value("#{systemProperties['java.version']}")
	String javaVersion;
	
	@Value("#{someBean.someValue}")
	/*
	 * get a loaded bean field value
	 */
    private Integer someBeanValue;

	@Bean
	public PropertiesWrapper propertiesWrapper() {

		PropertiesWrapper propertiesWrapper = new PropertiesWrapper();
		propertiesWrapper.setProperty(javaVersion);
		propertiesWrapper.setProperty(String.valueOf(someBeanValue));
		return propertiesWrapper;
	}
}
