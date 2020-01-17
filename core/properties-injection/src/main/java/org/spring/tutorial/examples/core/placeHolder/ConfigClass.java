package org.spring.tutorial.examples.core.placeHolder;

import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(
		name="myPropertySource"
		,value={
				"classpath:database_configuration.properties"
				,"classpath:${test_property_file}.properties"
		}
)
/*
 * You can specify ${...} placeholders in the resource location path. 
 * Spring will resolve the place holders using the already registered property sources.
 * For example, classpath:${test_property_file}.properties contains
 *  placeholder ${test_property_file}. Before spring gets to register ${test_property_file}.properties, 
 *  it already loads classpath:database_configuration.properties. Property test_property_file is set to 
 *  test_database_configuration so spring resolves ${test_property_file}.properties to test_database_configuration.properties.
 *  
 *  test_property_file may be also a JVM property or an operating system environment variable
 */
public class ConfigClass {

	@Autowired
	Environment environment;

	@Bean
	public PropertiesWrapper propertiesWrapper() {

        PropertiesWrapper propertiesWrapper = new PropertiesWrapper();
        /*
         * at first time spring will load the db.user property from "database_configuration.properties". but
         * this last property will be overwritten by the value from the "test_database_configuration.properties"
         * same thing for the db.password property
         */
        propertiesWrapper.setProperty(environment.getProperty("db.user"));
        propertiesWrapper.setProperty(environment.getProperty("db.password"));
        propertiesWrapper.setProperty(environment.getProperty("db.driver"));
        propertiesWrapper.setProperty(environment.getProperty("HOMEPATH"));
        return propertiesWrapper;
    }
}
