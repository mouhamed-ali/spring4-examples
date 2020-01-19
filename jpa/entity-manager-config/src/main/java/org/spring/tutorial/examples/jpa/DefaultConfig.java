package org.spring.tutorial.examples.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = { "org.spring.tutorial.examples.jpa.dao", "org.spring.tutorial.examples.jpa.service" })
@EnableTransactionManagement
public class DefaultConfig {

	@Bean
	public DataSource dataSource() {

		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("db/sql/create-db.sql")
				.addScript("db/sql/insert-data.sql")
				.build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		/*
		 * This is the most powerful way to set
		 * up a shared JPA EntityManagerFactory in a Spring application context;
		 */
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		/*
		 * configuration of the domain package
		 */
		em.setPackagesToScan(new String[] { "org.spring.tutorial.examples.jpa.domain" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		/*
		 * a jpaVendorAdapter implementation
		 * SPI interface that allows to plug in vendor-specific behavior into Spring's EntityManagerFactory creators. 
		 * Serves as single configuration point for all vendor-specific properties.
		 */
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
	/*
	 * creating of the application transaction
	 */
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	/*
	What is persistence-unit?
	A persistence unit is a logical grouping that contains information like configuration of EntityManagerFactory, 
	a set of entity classes, mapping metadata (can be loaded by scanning mapping annotations or from persistence.xml/orm.xml 
	under META-INF directory). Each persistence-unit must have a unique name. An application can have one or more persistence units.
	<persistence>
	 <persistence-unit name="...." transaction-type="...">
	  <provider>...</provider>
	  <exclude-unlisted-classes>true/false</exclude-unlisted-classes>
	  <properties>
	   <property name="javax.persistence.schema-generation.database.action" value="..."/>
	   <property name="javax.persistence.jdbc.url" value="..."/>
	  </properties>
	  <mapping-file>...</mapping-file>
	  <class>...</class>
	  <class>...</class>
	 </persistence-unit>
	</persistence>
	
	EntityManager and persistence-context
	An instance of the interface EntityManager is used to initiate a persistence-context. We can obtain 
	What is persistence-context?
	An EntityManager instance is associated with a persistence-context. The persistence-context is a set of managed unique 
	entity instances. EntityManger interacts with this context to manage entity instances and their lifecycle.
	EntityManager is not thread-safe, so we should use only one instance per thread.
	Each EntityManagerFactory instance provides EntityManager instances that are all configured in the same manner, 
	i.e. all will be using the same persistence-unit. More than one EntityManagerFactory instances can be used per application 
	which would probably be pointing to different set of entities and data-sources etc.
	*/
}
