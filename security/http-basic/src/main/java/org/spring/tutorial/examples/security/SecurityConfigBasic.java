package org.spring.tutorial.examples.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfigBasic extends WebSecurityConfigurerAdapter {

    /*
     * @EnableWebSecurity Annotation is used to enable web security in any web application.
     * @EnableWebSecurity = @EnableWebMVCSecurity + Extra features.That's why @EnableWebMVCSecurity Annotation is deprecated in Spring 4.x Framework.
     * any class which is designated to configure Spring Security, should extend the WebSecurityConfigurerAdapter class or implement related interface.
     * configureGlobal() method is used to store and mange User Credentials.
     * In configureGlobal() method, we can use authorities() method to define our application Roles like ROLE_USER. We can also use roles() method for the same purpose.
     * Difference between authorities() and roles() methods:
     * authorities() needs complete role name like ROLE_USER , roles() needs role name like USER. It will automatically adds ROLE_ value to this USER role name.
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //web specific security settings
        //http basic authentication
        http
                .authorizeRequests()
                .anyRequest().authenticated()//authentication is required for every request
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//logout url is ./logout
                .and()
                .httpBasic();
        /*
         * There really isn't much to this configuration, but it does a lot.
         * Require authentication to every URL in your application
         * Generate a login form for you
         * Allow the user with the Username user and the Password password to authenticate with form based authentication
         * Allow the user to logout
         * CSRF attack prevention
         * Session Fixation protection
         */
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("super-admin").password("password").roles("ADMIN","SUPER_ADMIN");

    }
}
