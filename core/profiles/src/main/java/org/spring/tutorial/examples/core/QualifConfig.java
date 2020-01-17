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
        name = "myPropertySource"
        , value = {
        "classpath:db_config_qualif_environment.properties"
}
)
@Profile("qualif")
public class QualifConfig {

	@Autowired
	Environment environment;
	
	@Bean
	public DataSource dataSource() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2)
			.setName(environment.getProperty("db.name"))
			.addScript("db/sql/qualif/create-db.sql")
			.addScript("db/sql/qualif/insert-data.sql")
			.build();
		return db;
	}
}
