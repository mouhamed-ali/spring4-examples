package org.spring.tutorial.examples.core.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherConfigClass {

	@Bean
    public SomeBean someBean() {
        return new SomeBean(999990009);
    }
}
