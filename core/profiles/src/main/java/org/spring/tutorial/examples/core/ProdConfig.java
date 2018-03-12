package org.spring.tutorial.examples.core;

import javax.sql.DataSource;

import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@PropertySource("classpath:db_config_prod_environment.properties")
@ComponentScan(basePackages={"org.spring.tutorial.examples.core.dao"})
@Profile("prod")
public class ProdConfig {

	@Autowired
	Environment environment;

	@Bean
	public PropertiesWrapper propertiesWrapper() {

		PropertiesWrapper propertiesWrapper = new PropertiesWrapper(); 
		propertiesWrapper.setProperty(environment.getProperty("db.host"));
		propertiesWrapper.setProperty(environment.getProperty("db.name"));
		propertiesWrapper.setProperty(environment.getProperty("db.user"));
		propertiesWrapper.setProperty(environment.getProperty("db.password"));
		return propertiesWrapper;
	}
	
	@Bean
	public DataSource dataSource() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2)
			.setName(environment.getProperty("db.name"))
			.addScript("db/sql/prod/create-db.sql")
			.addScript("db/sql/prod/insert-data.sql")
			.build();
		return db;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
