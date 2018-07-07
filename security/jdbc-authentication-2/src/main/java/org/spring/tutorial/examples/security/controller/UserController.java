package org.spring.tutorial.examples.security.controller;

import org.spring.tutorial.examples.security.domain.User;
import org.spring.tutorial.examples.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
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
     * in this example we will add :
     * sha password encryption
     * business methods security
     */

    @PostMapping("/user/pwd")
    public String getEncryptedPassword(@ModelAttribute("pwd") String password, Model model) {

        // SHA-256 encoding
        String encodedPassword = new StandardPasswordEncoder().encode(password);
        // SHA-256 encoding with salt : secure passwords with a well known string.
        //Known as salt, makes brut force attacks harder
        String encodedPasswordSalt = new StandardPasswordEncoder("sodium-chloride").encode(password);
        model.addAttribute("encPwd", String.format("password : %s <br/> SHA-256 : %s <br/> SHA-256 with salt : %s", password, encodedPassword, encodedPasswordSalt));
        return "index";
    }

    /*
     * http://localhost:8080/jdbc-authentication-2/user/index
     */
    @RequestMapping("/user/index")
    public String returnIndex() {
        return "index";
    }

    @GetMapping(path = "/user/add")
    public String returnAddUserPage(Model model) {

        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping(path = {"/user", "/user/"})
    public String addNewUser(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {

        user = userService.createUser(user);
        model.addAttribute("message", user.toString() + " successfuly created");
        return "index";
    }

    @RequestMapping(path = {"/user", "/user/"}, method = RequestMethod.GET)
    public String showUsers(Model model) {

        model.addAttribute("users", userService.getAll());
        return "show_users";
    }

    //TODO : wrong redirection after deleting the user [admin access]
    @DeleteMapping("/user/{userId}")
    public String deleteUser(@PathVariable("userId") long userId, Model model) {

        userService.removeById(userId);
        model.addAttribute("message", String.format("User [Number %s] successfully deleted", String.valueOf(userId)));
        return "index";
    }

    //TODO : wrong redirection after updating the user [admin access]
    @PutMapping("/user/{userId}")
    public String updateUser(@PathVariable("userId") long userId, @ModelAttribute User user, BindingResult errors, Model model) {

        if (Long.compare(userId, user.getId()) != 0) {
            userService.removeById(userId);
        }
        userService.updateUser(user);
        model.addAttribute("message", String.format("User [Number %s] successfully updated", String.valueOf(user.getId())));
        return "index";
    }

    @GetMapping("/user/{userId}")
    public String showUser(@PathVariable("userId") long userId, Model model) {

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "update_user";
    }
}