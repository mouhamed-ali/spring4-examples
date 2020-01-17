package org.spring.tutorial.examples.core;

import org.junit.Assert;
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
@ContextConfiguration(classes = {DefaultConfig.class, DevConfig.class})
@ActiveProfiles("dev")
/*
 * ActiveProfiles is a class-level annotation that is used to declare which active bean definition profiles should be used
 * when loading an ApplicationContext for test classes.
 */
public class DevConfigTest {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PropertiesWrapper properties;
	
	@Test
	public void testProperties() {

		properties.showProperties();
		Assert.assertEquals("localhost", properties.getPropertyValue("db.host"));
		Assert.assertEquals("dev-database", properties.getPropertyValue("db.name"));
		Assert.assertEquals("dev", properties.getPropertyValue("db.user"));
		Assert.assertEquals("dev@password", properties.getPropertyValue("db.password"));
	}

	@Test
	public void testDatabase() {
		String sql = "SELECT * FROM users WHERE ID = ?";
		/*
		 * If no database name is defined via EmbeddedDatabaseBuilder.setName(), Spring will assign a default database name testdb.
		 */
		User user = (User) jdbcTemplate.queryForObject(
				sql, new Object[]{2}, new BeanPropertyRowMapper(User.class));

		Assert.assertEquals(2, user.getId());
		Assert.assertEquals("dev2", user.getName());
		Assert.assertEquals("dev2@yahoo.com", user.getEmail());
	}
}
