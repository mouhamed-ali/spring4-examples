package org.spring.tutorial.mvc.controller.user;

import org.spring.tutorial.mvc.domain.User;
import org.spring.tutorial.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    IUserService userService;

    /*
     * http://localhost:8080/mvc-spring-1/hello-mvc/user/index
     */
    @RequestMapping(path = {"/index", "/index/"})
    public String returnIndex() {
        return "index";
    }

    @GetMapping(path = "/add")
    public String returnAddUserPage(Model model) {

        model.addAttribute("user", new User());
        return "add_user";
        /*
         * add_user is the name of the view; spring intercepts the request (by the dispatcher servlet of this url)
         *, provided us with the model to specify the data that we will send to the view and then he will
         * transfer this model to the view to use it
         * dispatcer servlet -> controller -> view Resolver (the one that will return the view based on the string
         * returned in our method) -> view -> dispatcher servlet: see image in the resources
         */
    }

    @PostMapping(path = {"", "/"})
    public String addNewUser(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {

        user = userService.createUser(user);
        model.addAttribute("message", user.toString() + " successfuly created");
        return "index";
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public String showUsers(Model model) {

        model.addAttribute("users", userService.getAll());
        return "show_users";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") long userId, Model model) {

        userService.removeById(userId);
        model.addAttribute("message", String.format("User [%s] was successfuly deleted", String.valueOf(userId)));
        return "index";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") long userId, @ModelAttribute User user, BindingResult errors, Model model) {

        if (Long.compare(userId, user.getId()) != 0) {
            userService.removeById(userId);
        }
        userService.updateUser(user);
        model.addAttribute("message", String.format("User[%s] was successfuly updated", String.valueOf(user.getId())));
        return "index";
    }

    @GetMapping("/{userId}")
    public String showUser(@PathVariable("userId") long userId, Model model) {

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "update_user";
    }
}
