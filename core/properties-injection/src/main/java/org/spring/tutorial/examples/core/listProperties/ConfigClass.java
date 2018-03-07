package org.spring.tutorial.examples.core.listProperties;

import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:list_database_configuration.properties")
public class ConfigClass {

	@Bean
	public PropertiesWrapper propertiesWrapper(
			@Value("#{'${db.users}'.split(',')}") String[] values
			) {

		/*
		 * on peut aussi utilis� cette annotation
		 * @Value("${db.users}")
		 */
		PropertiesWrapper propertiesWrapper = new PropertiesWrapper(); 
		for(String value : values){
			propertiesWrapper.setProperty(value);
		}
		return propertiesWrapper;
	}
}
