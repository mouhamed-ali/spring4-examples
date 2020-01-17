package org.spring.tutorial.examples.core.jvm;

import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:database_configuration.properties")
public class ConfigClass {

	@Bean
	public PropertiesWrapper propertiesWrapper(
			@Value("${java.version}") String javaVersion,
			@Value("${COMPUTERNAME}") String computerName,
			@Value("${HOMEPATH}") String homePath,
			@Value("${db.user}") String dbUser,
			@Value("${db.password}") String dbPassword
			) {

		PropertiesWrapper propertiesWrapper = new PropertiesWrapper();
		propertiesWrapper.setProperty("javaVersion : " + javaVersion);
		propertiesWrapper.setProperty("computerName : " + computerName);
		propertiesWrapper.setProperty("homePath : " + homePath);
		propertiesWrapper.setProperty("dbUser : " + dbUser);
		propertiesWrapper.setProperty("dbPassword : " + dbPassword);
		return propertiesWrapper;
	}
}
