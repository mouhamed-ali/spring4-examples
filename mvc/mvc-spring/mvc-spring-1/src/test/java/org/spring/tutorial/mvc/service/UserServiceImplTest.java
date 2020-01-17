package org.spring.tutorial.mvc.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.mvc.RootConfig;
import org.spring.tutorial.mvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Test
    @Sql(scripts = "/db/sql/insert-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Ignore
    // TODO resolve the dependencies problems of this project check https://docs.spring.io/platform/docs/Brussels-SR9/reference/html/appendix-dependency-versions.html
    public void testCreate() {

        //test of the insert-data.sqls sqls script integration
        assertThat(userService.getAll()).size().isEqualTo(4);

        //test create entity
        User user = new User(99, "AAA", "AAA@AAA.com");
        userService.createUser(user);
        assertThat(userService.getAll()).size().isEqualTo(5);

        //test find entity
        assertThat(userService.findUserById(99L)).isEqualTo(user);

        //test update entity
        user.setEmail("BBB@BBB.com");
        user.setName("BBB");
        assertThat(userService.updateUser(user)).isEqualTo(new User(99L, "BBB", "BBB@BBB.com"));

        //show table
        showUsers(userService.getAll());

        //test remove entity
        userService.removeById(99L);
        assertThat(userService.getAll()).size().isEqualTo(4);
        assertThat(userService.getAll()).doesNotContain(new User(99L, "BBB", "BBB@BBB.com"));

    }

    public void showUsers(List<User> list) {
        list.forEach(System.out::println);
    }
}
