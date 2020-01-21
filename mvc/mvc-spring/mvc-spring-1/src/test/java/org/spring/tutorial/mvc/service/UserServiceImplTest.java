package org.spring.tutorial.mvc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.mvc.RootConfig;
import org.spring.tutorial.mvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Test
    @Sql(scripts = "/db/sql/insert-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/db/sql/delete-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void globalTest() {

        //test of the insert-data.sql
        assertThat(userService.getAll()).size().isEqualTo(4);

        //test create entity
        User user = new User(99, "gerard", "gerard@gmail.com");
        userService.createUser(user);
        assertThat(userService.getAll()).size().isEqualTo(5);

        //test find entity
        assertThat(userService.findUserById(99L)).isEqualTo(user);

        //test update entity
        user.setEmail("mike@gmail.com");
        user.setName("mike");
        assertThat(userService.updateUser(user)).isEqualTo(new User(99L, "mike", "mike@gmail.com"));

        //test remove entity
        userService.removeById(99L);
        assertThat(userService.getAll()).size().isEqualTo(4);
        assertThat(userService.getAll()).doesNotContain(new User(99L, "mike", "mike@gmail.com"));

    }
}
