package org.spring.tutorial.examples.jpa;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"org.spring.tutorial.examples.jpa.dao"})//our repository
@ComponentScan(basePackages = { "org.spring.tutorial.examples.jpa.dao", "org.spring.tutorial.examples.jpa.service" })
@EnableTransactionManagement
public class DefaultConfig {

	@Bean
	public DataSource dataSource() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2)
				.addScript("db/sql/create-db.sql")
				.build();
		return db;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "org.spring.tutorial.examples.jpa.domain" });
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setDatabase(Database.H2);
		em.setJpaVendorAdapter(vendorAdapter);

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.format_sql", "true");
		em.setJpaProperties(jpaProperties);
		
		return em;
	}
	

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
