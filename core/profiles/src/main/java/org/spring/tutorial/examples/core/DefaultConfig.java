package org.spring.tutorial.examples.core;

import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@PropertySource(
		name="myPropertySource"
		,value={
				"classpath:db_config_default_environment.properties"
		}
)
@ComponentScan(basePackages={"org.spring.tutorial.examples.core.dao"})
public class DefaultConfig {

	@Autowired
	Environment environment;

	@Bean
	public PropertiesWrapper propertiesWrapper() {

		PropertiesWrapper propertiesWrapper = new PropertiesWrapper();
		propertiesWrapper.setProperty("db.host", environment.getProperty("db.host"));
		propertiesWrapper.setProperty("db.name", environment.getProperty("db.name"));
		propertiesWrapper.setProperty("db.user", environment.getProperty("db.user"));
		propertiesWrapper.setProperty("db.password", environment.getProperty("db.password"));
		return propertiesWrapper;
	}
	
	@Bean
	public DataSource dataSource() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2)
			.setName(environment.getProperty("db.name"))
			.addScript("db/sql/default/create-db.sql")
			.addScript("db/sql/default/insert-data.sql")
			.build();
		return db;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
}
