package org.spring.tutorial.examples.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages={
		"org.spring.tutorial.examples.jpa.dao",
		"org.spring.tutorial.examples.jpa.service"
		}
)
@EnableTransactionManagement
/*
 * Enables Spring's annotation-driven transaction management capability, similar to the support found in Spring's <tx:*> XML namespace.
 * so it allows activating @Transaction annotations
 */
public class DefaultConfig {

	@Bean
	public DataSource dataSource() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2)
			.addScript("db/sql/create-db.sql")
			.build();
		return db;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
		/*
		 * PlatformTransactionManager is the interface used by spring to hide the complexity of implementations
		 * and to add a high level of abstraction
		 * the possible implementations are very numerous: for the local transactions we can use DataSourceTransactionManager,
		 * HibernateTransactionManager, JpaTransactionManager ... and for global transactions we can use JtaTransactionManager ...
		 * the default name of the bean used for transactions is transactionManager (method name) and you must not change it
		 * otherwise we have to make modifications in several places (used by the spring framework to make the config)
		 */
	}
	
}
