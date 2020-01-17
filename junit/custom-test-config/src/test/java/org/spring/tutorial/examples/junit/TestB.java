package org.spring.tutorial.examples.junit;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.junit.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestB {

    @Autowired
    User user;

    @Test
    public void verifyConfiguration() {
        assertNotNull(user);

        assertEquals(99, user.getId());
        assertEquals("Spring", user.getName());
        assertEquals("Tutorial", user.getEmail());
    }

}
