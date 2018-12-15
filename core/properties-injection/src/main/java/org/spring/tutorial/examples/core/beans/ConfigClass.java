package org.spring.tutorial.examples.core.beans;

import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {

    @Value("#{systemProperties['java.version']}")//jvm property
	String javaVersion;

    @Value("${JAVA_HOME}")// environment variable
            String javaHome;

    @Value("#{someBean.someValue}")//spring bean attribute
	/*
	 * get a loaded bean field value
	 */
            Integer someBeanValue;

	@Bean
	public PropertiesWrapper propertiesWrapper() {

		PropertiesWrapper propertiesWrapper = new PropertiesWrapper();
		propertiesWrapper.setProperty(javaVersion);
        propertiesWrapper.setProperty(javaHome);
		propertiesWrapper.setProperty(String.valueOf(someBeanValue));
		return propertiesWrapper;
	}
}
