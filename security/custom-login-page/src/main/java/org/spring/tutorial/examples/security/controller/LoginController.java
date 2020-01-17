package org.spring.tutorial.examples.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    /*
     * http://localhost:8080/custom-login-page/homePage
     */
    @RequestMapping(value = {"/homePage"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("homePage");
        return model;
    }

    /*
     * http://localhost:8080/custom-login-page/admin/show
     */
    @GetMapping("/admin/show")
    public String adminPage() {

        return "admin/index";
    }

    /*
     * http://localhost:8080/custom-login-page/customer/show
     */
    @GetMapping("/customer/show")
    public String customerPage() {

        return "customer/index";
    }

    /*
     * http://localhost:8080/custom-login-page/shared/show
     */
    @GetMapping("/shared/show")
    public String sharedPage() {

        return "shared/index";
    }

//	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
//	public ModelAndView welcomePage() {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("templates/loginPage");
//		return model;
//	}
}
