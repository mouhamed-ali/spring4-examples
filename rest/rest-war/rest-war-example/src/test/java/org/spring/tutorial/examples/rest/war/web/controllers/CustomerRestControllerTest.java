package org.spring.tutorial.examples.rest.war.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.rest.war.config.AppConfig;
import org.spring.tutorial.examples.rest.war.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class CustomerRestControllerTest {

    public static final String CUSTOMERS_ENDPOINT = "/customers";
    private ObjectMapper mapper = new ObjectMapper();

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetCustomers() throws Exception {

        mockMvc.perform(get(CUSTOMERS_ENDPOINT).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testGetExistCustomer() throws Exception {

        mockMvc.perform(get(CUSTOMERS_ENDPOINT + "/{id}", 301L).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(301)))
                .andExpect(jsonPath("$.firstName", is("Kate")))
                .andExpect(jsonPath("$.lastName", is("Williams")))
                .andExpect(jsonPath("$.email", is("kwilliams@gmail.com")))
                .andExpect(jsonPath("$.mobile", is("876-237-2987")));
    }

    @Test
    public void testGetNotExistCustomer() throws Exception {

        mockMvc.perform(get(CUSTOMERS_ENDPOINT + "/{id}", 401L).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", is("No Customer found for ID 401")));
    }

    @Test
    public void testCreateCustomer() throws Exception {

        Customer customer = new Customer(909, "John", "Doe", "djohn@gmail.com", "121-232-3435");
        mockMvc.perform(
                post(CUSTOMERS_ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(customer))
        )
                .andExpect(status().isCreated());
    }

    @Test
    public void testDeleteCustomer() throws Exception {

        mockMvc.perform(delete(CUSTOMERS_ENDPOINT + "/{id}", 101L).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteNotExistCustomer() throws Exception {

        mockMvc.perform(delete(CUSTOMERS_ENDPOINT + "/{id}", 55L).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", is("No Customer found for ID 55")));
    }

    @Test
    public void testUpdateCustomer() throws Exception {

        Customer customer = new Customer(809, "Katy", "Perry", "katy@gmail.com", "121-232-3435");
        mockMvc.perform(
                put(CUSTOMERS_ENDPOINT + "/{id}", 201L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(customer))
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateNotExistCustomer() throws Exception {

        mockMvc.perform(
                put(CUSTOMERS_ENDPOINT + "/{id}", 22L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(new Customer()))
        )
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", is("No Customer found for ID 22")));
    }
}
