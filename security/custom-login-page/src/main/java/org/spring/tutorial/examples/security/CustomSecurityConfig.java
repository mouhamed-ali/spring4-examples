package org.spring.tutorial.examples.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //web specific security settings
        http
                .authorizeRequests()
                .antMatchers("/static/**")//access to public resources
                .permitAll()
                .antMatchers("/admin/**")
                /*
                 *	/admin/** will map any url starting with /admin/ for example : /admin/edit , /admin/edit/show , /admin/edit/show/any
                 *  /admin/* will map any url starting with /admin/ followed by a single path example : /admin/edit
                 *  /admin/show and not /admin/edit/show
                 */
                .hasRole("ADMIN")
                .antMatchers("/customer/**")
                .hasRole("CUSTOMER")
                .antMatchers("/shared/**")
                .hasAnyRole("CUSTOMER", "ADMIN")
                .anyRequest().authenticated()//any other request will be authenticated
                .and()
                /*
                 * Urls must be distributed from the most specific to the most general. if for example
                 * you declare .anyRequest().authenticated() as the first statement then the
                 * .antMatchers(url).hasAnyRole(role). any authenticated user will have access to any page the
                 * .antMatchers(url).hasAnyRole(role) will be ignored
                 */
                .formLogin()
                .loginPage("/login")//login page url access
                .permitAll()//public resource
                .defaultSuccessUrl("/homePage")//after authentication the user will be redirected to /homePage
                .failureUrl("/login?error=true")//otherwise he will be redirected to /login?error=true
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout")//logout page
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");//access denied url
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {

        //general settings
        authenticationMgr.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .authorities("ROLE_ADMIN")
                .and()
                .withUser("user")
                .password("user")
                .roles("CUSTOMER");
    }
}
