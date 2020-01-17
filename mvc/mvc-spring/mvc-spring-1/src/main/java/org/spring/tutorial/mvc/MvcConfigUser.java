package org.spring.tutorial.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
/*
 * this annotation is used to activate the default message converter.
 * message converters are used to marshall and unmarshall Java Objects to and from JSON, XML, etc over HTTP.
 * check this : http://www.baeldung.com/spring-httpmessageconverter-rest
 */
@EnableWebMvc
/*
 * controller (view resolver) package
 */
@ComponentScan("org.spring.tutorial.mvc.controller.user")
/*
 * this is the only dispatcher servlet in our application
 */
public class MvcConfigUser extends WebMvcConfigurerAdapter {


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        /*
         * we gonna use the JstlView in this cas. JstlView.class :
         * Exposes JSTL-specific request attributes specifying locale and resource bundle for JSTL's formatting and message tags, using Spring's locale and MessageSource.
         * even if we don't mention this it's gonna work because the InternalResourceViewResolver use ths JstlView by default
         */
        viewResolver.setPrefix("/WEB-INF/views/user/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
        /*
         * this view resolver will determine the view implementation after a dispatcher servlet call (this call
         * contains the view name)
         */
    }

    /*
     * all the WebMvcConfigurerAdapter methods are empty. we can override only methods that concerns us
     * WebMvnConfigurer according to documentation :
     * Defines callback methods to customize the Java-based configuration for Spring MVC enabled via @EnableWebMvc.
     * @EnableWebMvc-annotated configuration classes may implement this interface to be called back and given a chance to
     * customize the default configuration. Consider extending WebMvcConfigurerAdapter, which provides a stub implementation
     * of all interface methods.
     * for more details :
     * http://www.baeldung.com/spring-mvc-static-resources
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}
