package org.spring.tutorial.examples.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //web specific security settings
        http
                .authorizeRequests()
                .antMatchers("/static/**")
                .permitAll()
                .antMatchers("/login*")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/user/pwd")//@GetMapping(path="/user/add")
                .hasAnyRole("ADMIN", "USER")
                /*
                 * urls security is done in the UserServiceImpl class
                 */
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {

        //general settings
        authenticationMgr
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new StandardPasswordEncoder())
                .usersByUsernameQuery(
                        "select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");
    }
}
