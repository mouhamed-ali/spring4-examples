package org.spring.tutorial.examples.rest.template;

import org.spring.tutorial.examples.rest.template.api.user.UserRestApiConsumer;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RootConfig {

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

    @Bean
    public UserRestApiConsumer apiConsumer() {

        return new UserRestApiConsumer();
    }
}
