package org.spring.tutorial.examples.rest.template;

import org.spring.tutorial.examples.rest.template.api.user.UserRestApiConsumer;
import org.spring.tutorial.examples.rest.template.config.interceptors.LoggingRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RootConfig {

    @Bean
    public RestTemplate restTemplate() {

        /*
               create an Http interceptor to trace all the requests of our rest template
         */
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new LoggingRequestInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    @Bean
    public UserRestApiConsumer apiConsumer() {

        return new UserRestApiConsumer();
    }
}
