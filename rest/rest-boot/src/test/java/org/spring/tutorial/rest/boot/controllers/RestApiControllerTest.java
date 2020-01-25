package org.spring.tutorial.rest.boot.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.rest.boot.models.User;
import org.spring.tutorial.rest.boot.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(RestApiController.class)
public class RestApiControllerTest {

    public static final String API_USER = "/api/user";
    @Autowired
    private MockMvc mvc;

    @MockBean
    UserServiceImpl userService;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void listAllUsersTest() throws Exception {

        when(userService.findAllUsers()).thenReturn(buildUsersList());
        this.mvc.perform(get(API_USER).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$.length()", is(3)));
    }

    @Test
    public void findExistUserTest() throws Exception {

        when(userService.findById(anyInt())).thenReturn(buildUsersList().get(0));
        this.mvc.perform(get(API_USER + "/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.login", is("mike")))
                .andExpect(jsonPath("$.password", is("password-mike")));
    }

    @Test
    public void findNotExistUserTest() throws Exception {

        this.mvc.perform(get(API_USER + "/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorMessage", is("User with id 1 not found")));
    }

    @Test
    public void createUserTest() throws Exception {

        User toCreateUser = new User(12,"hello","world");
        this.mvc.perform(
                post(API_USER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(toCreateUser))
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().string("Location",containsString(API_USER + "/12")));
    }

    @Test
    public void createAlreadyExistUserTest() throws Exception {

        when(userService.isUserExist(anyObject())).thenReturn(true);
        User toCreateUser = new User(12,"hello","world");
        this.mvc.perform(
                post(API_USER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(toCreateUser))
        )
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.errorMessage", is("Creation failed. A User with the same id already exist.")));
    }

    @Test
    public void updateUserTest() throws Exception {

        when(userService.findById(anyInt())).thenReturn(buildUsersList().get(1));
        User toUpdateUser = new User(2,"hello","world");
        this.mvc.perform(
                put(API_USER + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(toUpdateUser))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.login", is("hello")))
                .andExpect(jsonPath("$.password", is("world")));
    }

    @Test
    public void updateNotExistUserTest() throws Exception {

        when(userService.findById(anyInt())).thenReturn(null);
        this.mvc.perform(
                put(API_USER + "/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(new User()))
        )
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorMessage", is("Unable to update. User with id 99 not found.")));
    }

    @Test
    public void deleteUserTest() throws Exception {

        when(userService.findById(anyInt())).thenReturn(buildUsersList().get(2));
        this.mvc.perform(
                delete(API_USER + "/3")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteNotExistUserTest() throws Exception {

        when(userService.findById(anyInt())).thenReturn(null);
        this.mvc.perform(
                delete(API_USER + "/14")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorMessage", is("Unable to delete. User with id 14 not found.")));
    }

    @Test
    public void deleteAllTest() throws Exception {

        this.mvc.perform(
                delete(API_USER + "/")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isNoContent());
    }


    List<User> buildUsersList() {
        return Arrays.asList(
                new User(1, "mike", "password-mike"),
                new User(2, "benjamin", "password-benjamin"),
                new User(3, "paul", "password-paul")
        );
    }
}
