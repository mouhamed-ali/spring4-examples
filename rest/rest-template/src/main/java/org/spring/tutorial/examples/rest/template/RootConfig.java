package org.spring.tutorial.examples.rest.template;

import org.spring.tutorial.examples.rest.template.api.user.UserRestApiConsumer;
import org.spring.tutorial.examples.rest.template.config.interceptors.LoggingRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class RootConfig {

    @Bean
    public RestTemplate restTemplate(Environment env) {

        /*
               create an Http interceptor to trace all the requests of our rest template
         */
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

        // for testing we will not use the logger
        if(!Arrays.asList(env.getActiveProfiles()).contains("test")){

            restTemplate.getInterceptors().add(new LoggingRequestInterceptor());
        }
        return restTemplate;
    }

    @Bean
    public UserRestApiConsumer apiConsumer() {

        return new UserRestApiConsumer();
    }
}
