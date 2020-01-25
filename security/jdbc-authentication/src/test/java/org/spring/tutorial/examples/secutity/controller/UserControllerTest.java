package org.spring.tutorial.examples.secutity.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.security.MvcConfig;
import org.spring.tutorial.examples.security.RootConfig;
import org.spring.tutorial.examples.security.SecurityConfig;
import org.spring.tutorial.examples.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, RootConfig.class, SecurityConfig.class})
@WebAppConfiguration
@ActiveProfiles(profiles = "test")
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser
    // The following test will be run as a user with the username "user", the password "password", and the roles "ROLE_USER"
    // it is not a problem if the password is not user because spring will make sure that the user will be logged in
    // all what we need is that the use has the role USER
    public void testIndexPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    @WithMockUser
    public void testGetAddPage() throws Exception {
        mockMvc.perform(get("/user/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add_user"));
    }

    @Test
    @WithMockUser(username="admin", password = "admin", roles={"USER","ADMIN"})
    public void testAddNewUser() throws Exception {
        User user = new User(99, "user", "user@email.com");
        mockMvc.perform(post("/user/")
                .contentType("application/x-www-form-urlencoded")
                .param("id", ""+user.getId())
                .param("name", user.getName())
                .param("email", user.getEmail())
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("message", user.toString() + " successfully created"));
    }

    @Test
    @WithMockUser
    public void testAddNewUserException() throws Exception {
        mockMvc.perform(post("/user/"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testShowUsersAdmin() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(view().name("show_users"));
    }

    @Test
    @WithMockUser
    public void testShowUsersUser() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(view().name("show_users"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/user/3"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("message", "User [Number 3] successfully deleted"));
    }

    @Test
    @WithMockUser
    public void testDeleteUserException() throws Exception {
        mockMvc.perform(delete("/user/3"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testUpdateUser() throws Exception {
        User user = new User(3, "mike", "mike@gmail.com");
        mockMvc.perform(put("/user/3")
                .contentType("application/x-www-form-urlencoded")
                .param("id", ""+user.getId())
                .param("name", user.getName())
                .param("email", user.getEmail())
        )
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("message", "User [Number 3] successfully updated"));
    }

    @Test
    @WithMockUser
    public void testUpdateUserException() throws Exception {
        User user = new User(3, "mike", "mike@gmail.com");
        mockMvc.perform(put("/user/3")
                .contentType("application/x-www-form-urlencoded")
                .param("id", ""+user.getId())
                .param("name", user.getName())
                .param("email", user.getEmail())
        )
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    public void testShowUser() throws Exception {
        User mkyong = new User(1, "Linus", "Torvalds");
        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("update_user"))
                .andExpect(model().attribute("user", mkyong));
    }
}
