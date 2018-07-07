package org.spring.tutorial.examples.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    /*
     * why it's important to use this empty class ?
     * we should register Spring Security with the existing ApplicationContext.For example, if we were using Spring MVC
     * our SecurityWebApplicationInitializer would look something like this class extends AbstractSecurityWebApplicationInitializer
     * check this : https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/
     *
     * This would simply only register the springSecurityFilterChain Filter for every URL in your application. After that we would ensure
     * that WebSecurityConfig was loaded in our existing ApplicationInitializer. For example, if we were using Spring MVC it would
     * be added in the getRootConfigClasses() -> check MyWebInitializerUser.java
     */
}
