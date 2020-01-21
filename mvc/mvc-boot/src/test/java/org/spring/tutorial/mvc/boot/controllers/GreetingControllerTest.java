package org.spring.tutorial.mvc.boot.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.mvc.boot.config.SpringBootStandAloneApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
@ContextConfiguration(classes = {SpringBootStandAloneApp.class})
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDefaultPage() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))
                .andExpect(content().string(
                        containsString("Hello, World!"))
                );
    }

    @Test
    public void testPageWithParameter() throws Exception {
        mockMvc.perform(get("/greeting").param("name", "Wolf"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))
                .andExpect(content().string(
                        containsString("Hello, Wolf!"))
                );
    }
}
