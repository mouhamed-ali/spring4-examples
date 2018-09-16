package org.spring.tutorial.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
/*
    The @EnableCaching annotation triggers a post processor that inspects every Spring bean for the presence
    of caching annotations on public methods. If such an annotation is found, a proxy is automatically created
    to intercept the method call and handle the caching behavior accordingly.
    The annotations that are managed by this post processor are Cacheable, CachePut and CacheEvict
    Spring Boot automatically configures a suitable CacheManager to serve as a provider for the relevant cache.
    Our sample does not use a specific caching library so our cache store is the simple fallback that uses ConcurrentHashMap.
 */
public class SpringCacheTest {
    /*
     * check this example
     * https://spring.io/guides/gs/caching/
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringCacheTest.class, args);
    }
    /*
        @SpringBootApplication is a convenience annotation that adds all of the following:

        @Configuration tags the class as a source of bean definitions for the application context.

        @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
        Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.

        @ComponentScan tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers.
     */
}