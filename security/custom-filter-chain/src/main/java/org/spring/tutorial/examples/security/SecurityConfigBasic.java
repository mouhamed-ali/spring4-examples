package org.spring.tutorial.examples.security;

import org.spring.tutorial.examples.security.filters.CustomFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.Filter;


@Configuration
@EnableWebSecurity
public class SecurityConfigBasic extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/static/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                .httpBasic()
                /*
                 * filter registration among the spring filter chain
                 */
                .and()
                .addFilterAfter(myFilter(), UsernamePasswordAuthenticationFilter.class);
        /*
         * our filter will be executed after the basic authentication filter
         * There are a couple of possible methods:
         * addFilterBefore(filter, class) > adds a filter before the position of the specified filter class
         * addFilterAfter(filter, class) > adds a filter after the position of the specified filter class
         * addFilterAt(filter, class) > adds a filter at the location of the specified filter class
         * addFilter(filter) > adds a filter that must be an instance of or extend one of the filters provided by Spring Security
         *
         * there is another way to do this .you must extend the UsernamePasswordAuthenticationFilter class and modify
         * the necessary methods then to make the recording in the same way (use addFilter instead of addFilerAfter)
         * So the UsernamePasswordAuthenticationFilter will be ignored and our custom filter will replace him
         */
    }

    @Bean
    public UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password("user").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("admin").roles("ADMIN").build());
        return manager;
    }

    @Bean
    public Filter myFilter() {
        return new CustomFilter();
    }
}
