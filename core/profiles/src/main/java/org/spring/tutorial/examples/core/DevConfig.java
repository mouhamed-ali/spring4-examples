package org.spring.tutorial.examples.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@PropertySource(
		name="myPropertySource"
		,value={
				"classpath:db_config_dev_environment.properties"
		}
)
@Profile("dev")
/*
 * we can use !dev it means that this config is used when the used profile is different from dev (prod, qualif ...)
 */
public class DevConfig {

	@Autowired
	Environment environment;
	
	@Bean
	public DataSource dataSource() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2)
			.setName(environment.getProperty("db.name"))
			.addScript("db/sql/dev/create-db.sql")
			.addScript("db/sql/dev/insert-data.sql")
			.build();
		return db;
	}
}
