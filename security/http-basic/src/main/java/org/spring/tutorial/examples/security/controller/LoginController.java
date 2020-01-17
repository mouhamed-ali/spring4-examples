package org.spring.tutorial.examples.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    /*
     * http://localhost:8080/http-basic/index
     *
     * there is a problem when you logged out (http://localhost:8080/http-basic/login?logout) and then you logged
     * in. the application is supposed to redirect you to the http://localhost:8080/http-basic/index but in our
     * case it will redirect you to http://localhost:8080/http-basic/ TODO
     */
    @GetMapping(value = {"/index", "/index/"})
    public String index() {
        return "index";
    }

    /*
     * adding the logout url ?
     * When using the WebSecurityConfigurerAdapter, logout capabilities are automatically applied.
     * The default is that accessing the URL /logout . it will log the user out by:
     * 		Invalidating the HTTP Session
     * 		Cleaning up any RememberMe authentication that was configured
     * 		Clearing the SecurityContextHolder
     * 		Redirect to /login?logout
     * so it's automatically
     */
}
