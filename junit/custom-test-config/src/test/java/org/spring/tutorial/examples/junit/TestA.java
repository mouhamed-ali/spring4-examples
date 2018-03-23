package org.spring.tutorial.examples.junit;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestA {

    @Autowired
    private ConfigClass config;

    @Test
    public void verifyConfiguration() {
        /*
             by default spring will look for a an xml file named {test class}-Context.xml
             or any inner static classes annotated with @Configuration.
         */
        assertNotNull(config);
    }

    @Configuration
    static class ConfigClass {}

}
