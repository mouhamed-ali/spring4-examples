package org.spring.tutorial.mvc.controller.user;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.mvc.MvcConfigUser;
import org.spring.tutorial.mvc.RootConfig;
import org.spring.tutorial.mvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfigUser.class, RootConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@Sql(scripts = "/db/sql/insert-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/db/sql/delete-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
// these scripts will be executed before and after each of the tests methods
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testIndexPage() throws Exception {
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

        mockMvc.perform(get("/index/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testGetAddPage() throws Exception {
        mockMvc.perform(get("/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add_user"));
    }

    @Test
    public void testAddNewUser() throws Exception {
        User user = new User(99, "user", "user@email.com");
        mockMvc.perform(post("/")
                .contentType("application/x-www-form-urlencoded")
                .param("id", ""+user.getId())
                .param("name", user.getName())
                .param("email", user.getEmail())
        )
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("message", user.toString() + " successfully created"));
    }

    @Test
    public void testShowUsers() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("show_users"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("message", "User [3] was successfully deleted"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        // we gonna update the third user
        //INSERT INTO users VALUES (3, 'joel', 'joel@gmail.com');
        User user = new User(3, "mike", "mike@gmail.com");
        mockMvc.perform(put("/3")
                .contentType("application/x-www-form-urlencoded")
                .param("id", ""+user.getId())
                .param("name", user.getName())
                .param("email", user.getEmail())
        )
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("message", "User[3] was successfully updated"));
    }

    @Test
    public void testShowUser() throws Exception {
        // the first user is mkyong check the scripts files
        User mkyong = new User(1, "mkyong", "mkyong@gmail.com");
        mockMvc.perform(get("/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("update_user"))
                .andExpect(model().attribute("user", mkyong));
    }
}
