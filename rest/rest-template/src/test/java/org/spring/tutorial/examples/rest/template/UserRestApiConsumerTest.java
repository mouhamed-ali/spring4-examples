package org.spring.tutorial.examples.rest.template;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.rest.template.api.user.UserRestApiConsumer;
import org.spring.tutorial.examples.rest.template.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.spring.tutorial.examples.rest.template.api.user.UserRestApiConsumer.USER_URI;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@ActiveProfiles(profiles = "test")
public class UserRestApiConsumerTest {

    private MockRestServiceServer mockServer;
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private UserRestApiConsumer userRestConsumer;

    @Autowired
    private RestTemplate restTemplate;

    @Before
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testGetUserById() throws Exception {
        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI(USER_URI + "1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(
                        withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(getUsersList().get(0)))
                );

        User user = userRestConsumer.getUserById(1L);
        mockServer.verify();
        Assertions.assertThat(user).isEqualTo(getUsersList().get(0));
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User(88,"name","email");
        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI(USER_URI)))
                .andExpect(
                        content().string(mapper.writeValueAsString(
                                user
                        ))
                )
                .andExpect(method(HttpMethod.POST))
                .andRespond(
                        withStatus(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                );

        HttpStatus status = userRestConsumer.createUser(user);
        mockServer.verify();
        Assertions.assertThat(status).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User(99,"name","email");
        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI(USER_URI + "99")))
                .andExpect(
                        content().string(mapper.writeValueAsString(
                                user
                        ))
                )
                .andExpect(method(HttpMethod.PUT))
                .andRespond(
                        withStatus(HttpStatus.NO_CONTENT)
                                .contentType(MediaType.APPLICATION_JSON)
                );

        HttpStatus status = userRestConsumer.updateUser(99L,user);
        mockServer.verify();
        Assertions.assertThat(status).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    public void testDeleteUser() throws Exception {
        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI(USER_URI + "527")))
                .andExpect(method(HttpMethod.DELETE))
                .andRespond(
                        withStatus(HttpStatus.NO_CONTENT)
                                .contentType(MediaType.APPLICATION_JSON)
                );

        HttpStatus status = userRestConsumer.deleteUser(527L);
        mockServer.verify();
        Assertions.assertThat(status).isEqualTo(HttpStatus.NO_CONTENT);
    }

    public static List<User> getUsersList() {
        return Arrays.asList(
                new User(1, "Dummy", "dummy@dummy.com"),
                new User(2, "Raul", "Raul@Raul.com"),
                new User(3, "Leo", "Leo@Leo.com"),
                new User(4, "jean", "jean@jean.com"),
                new User(5, "francois", "francois@francois.com")
        );
    }
}
