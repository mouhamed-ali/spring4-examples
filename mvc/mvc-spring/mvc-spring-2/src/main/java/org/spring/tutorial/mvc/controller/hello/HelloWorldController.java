package org.spring.tutorial.mvc.controller.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    /*
     * http://host:port/context/servlet-mapping/view_name
     * will be :
     * http://localhost:8080/mvc-spring-2/example/hello
     * for this route
     */
    @RequestMapping("/hello")
    public String sayHelloAgain(Model model) {
        model.addAttribute("greeting", "Hello World with Model!!!");
        return "welcome";
    }

    /*
     * Access url  : http://localhost:8080/mvc-spring-2/example/ or http://localhost:8080/mvc-spring-2/example
     */
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(Model model) {
        model.addAttribute("greeting", "Hello World !!!");
        return "welcome";
    }

    /*
     *  http://localhost:8080/mvc-spring-2/example/helloo?name="user_name"
     */
    @RequestMapping("/welcome")
    public String sayHelloUser(@RequestParam("name") String userName, Model model) {
        /*
         * we can also inject other request parameters like : HttpRequest, HttpSession, RequestHeader, cookies, RequestBody ...
         * it depends on your needs
         */
        model.addAttribute("greeting", String.format("Welcome %s !!!", userName));
        return "welcome";
    }

    /*
     * http://localhost:8080/mvc-spring-2/example/hello/create/99
     * 99 is the user identifier
     */
    @RequestMapping("/hello/create/{userId}")
    public String sayHelloUserById(@PathVariable long userId, Model model) {

        model.addAttribute("greeting", String.format("Hello User Number %s !!!", String.valueOf(userId)));
        return "welcome";
    }

}
