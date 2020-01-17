package org.spring.tutorial.examples.core;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.core.domain.User;
import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {QualifConfig.class, DefaultConfig.class, DevConfig.class, ProdConfig.class})
/*
 * because we did not active any profile the selected profile will be the default profile even if we use all
 * the config files
 */
public class DefaultConfigTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PropertiesWrapper properties;

	@Test
	public void testProperties() {

		properties.showProperties();
		Assert.assertEquals("default@ipAdress", properties.getPropertyValue("db.host"));
		Assert.assertEquals("default-database", properties.getPropertyValue("db.name"));
		Assert.assertEquals("default-user", properties.getPropertyValue("db.user"));
		Assert.assertEquals("default-password", properties.getPropertyValue("db.password"));
	}

	@Test
	public void testDatabase() {
		String sql = "SELECT * FROM users WHERE ID = ?";
		/*
		 * If no database name is defined via EmbeddedDatabaseBuilder.setName(), Spring will assign a default database name testdb.
		 */
		User user = (User) jdbcTemplate.queryForObject(
				sql, new Object[]{1}, new BeanPropertyRowMapper(User.class));

		Assert.assertEquals(1, user.getId());
		Assert.assertEquals("default1", user.getName());
		Assert.assertEquals("default1@gmail.com", user.getEmail());
	}
}
