package org.spring.tutorial.examples.jpa.service.extra;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.tutorial.examples.jpa.DefaultConfig;
import org.spring.tutorial.examples.jpa.domain.User;
import org.spring.tutorial.examples.jpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DefaultConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
// this annotation is used to run tests in the order (name ascending)
@DirtiesContext
public class TransactionalAnnotationTest {

    static List<User> users;

    @Autowired
    IUserService userService;

    @BeforeClass
    public static void setUp() {
        users = Arrays.asList(
                new User(1, "benjamin", "benjamin@gmail.com"),
                new User(2, "alex", "alex@yahoo.com")
        );
    }

    @Test
    @Sql("/db/sql/insert-data.sql") // this script will be rollback also
    @Transactional
    /*
     * by annotating the test with @Transactional a rollback will be raised at the end of the test so it is
     * not necessary to go and clean the data added by the test in the BDD
     */
    public void aTestCreate() throws Exception {

        User toCreateUser = new User(5, "Abraham", "Lincoln");
        userService.createUser(toCreateUser, false, false);
        Assert.assertEquals(toCreateUser, userService.findUserById(5L));
    }

    @Test
    public void bTestTransactional() {


        Assert.assertEquals(0, userService.getAll().size());
    }

    @Test
    public void cTestCreate() throws Exception {

        users.forEach(user -> {
            try {
                userService.createUser(user, false, false);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void dTestTransactional() {

        List<User> dbList = userService.getAll();
        Assert.assertEquals(users, dbList);
    }
}
