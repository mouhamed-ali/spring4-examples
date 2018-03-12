package org.spring.tutorial.examples.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.core.domain.User;
import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DevConfig.class,ProdConfig.class})
/*
 * according to the order of the declaration of config classes in annotation @ContextConfiguration
 * the profile will be selected (in our case the profile used is prod if
 * we reverse the class declaration it will be dev)
 */
@ActiveProfiles({"dev","prod"})
public class DevProdConfigTest {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PropertiesWrapper properties;
	
	@Test
	public void testProperties(){
		
		properties.showProperties();
	}
	
	@Test
	public void test(){
		String sql = "SELECT * FROM users WHERE ID = ?";
		/*
		 * If no database name is defined via EmbeddedDatabaseBuilder.setName(), Spring will assign a default database name testdb.
		 */
		User user = (User) jdbcTemplate.queryForObject(
		sql, new Object[] { 2 }, new BeanPropertyRowMapper(User.class));
		System.out.println(user);
	}
}
