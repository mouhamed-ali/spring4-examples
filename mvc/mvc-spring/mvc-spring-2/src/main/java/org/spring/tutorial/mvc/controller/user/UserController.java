package org.spring.tutorial.mvc.controller.user;

import org.spring.tutorial.mvc.domain.User;
import org.spring.tutorial.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    /*
     * http://localhost:8080/mvc-spring-2/user/index
     */
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String returnIndex() {
        return "index";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String returnAddUserPage(Model model) {

        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping(path = {"/", ""})
    /*
     * post request to add a resource
     * check : https://fr.wikipedia.org/wiki/Hypertext_Transfer_Protocol
     */
    public String addUser(@ModelAttribute User newUser, BindingResult errors, Model model) {

        if (!errors.hasErrors()) {
            User user = userService.addUser(newUser);
            model.addAttribute("message", String.format("User [id=%s , name=%s, email=%s] successfully created",
                    String.valueOf(user.getId()), user.getName(), user.getEmail()));
        }
        return ((errors.hasErrors()) ? "add_user" : "index");
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public String returnUser(@PathVariable("userId") long userId, Model model) {

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping(path = {"", "/"})
    public String showUsers(Model model) {

        model.addAttribute("users", userService.getUsers());
        return "show_users";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") long userId, Model model) {

        userService.deleteUser(userId);
        model.addAttribute("message", String.format("User Number %s successfully deleted", String.valueOf(userId)));
        return "index";
    }

    @PutMapping("/{userId}")
    /*
     * put request to update the resource
     */
    public String updateUser(@PathVariable("userId") long userId, @ModelAttribute User user, BindingResult errors, Model model) {

        User currentUser = userService.findUserById(userId);
        if (currentUser != null) {
            userService.deleteUser(userId);
        }
        user = userService.updateUser(user);
        model.addAttribute("message", String.format("User Number %s successfully updated", String.valueOf(user.getId())));
        return "index";
    }
}
