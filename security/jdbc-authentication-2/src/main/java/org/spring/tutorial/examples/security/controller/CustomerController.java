package org.spring.tutorial.examples.security.controller;

import org.spring.tutorial.examples.security.domain.Customer;
import org.spring.tutorial.examples.security.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    /*
     * in this example we will add :
     * sha password encryption
     * business methods security
     */

    @PostMapping("/pwd")
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
     * http://localhost:8080/jdbc-authentication-2/
     */
    @RequestMapping("/")
    public String returnIndex() {
        return "index";
    }

    @GetMapping(path = "/customer/add")
    public String returnAddCustomerPage(Model model) {

        model.addAttribute("customer", new Customer());
        return "add_customer";
    }

    @PostMapping(path = {"/customer", "/customer/"})
    public String addNewCustomer(@ModelAttribute("customer") Customer customer, BindingResult result, ModelMap model) {

        customer = customerService.createCustomer(customer);
        model.addAttribute("message", customer.toString() + " successfully created");
        return "index";
    }

    @RequestMapping(path = {"/customer", "/customer/"}, method = RequestMethod.GET)
    public String showCustomers(Model model) {

        model.addAttribute("customers", customerService.getAll());
        return "show_customers";
    }

    //TODO : wrong redirection after deleting the customer [admin access]
    @DeleteMapping("/customer/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") long customerId, Model model) {

        customerService.removeById(customerId);
        model.addAttribute("message", String.format("customer [Number %s] successfully deleted", String.valueOf(customerId)));
        return "index";
    }

    //TODO : wrong redirection after updating the customer [admin access]
    @PutMapping("/customer/{customerId}")
    public String updateCustomer(@PathVariable("customerId") long customerId, @ModelAttribute Customer customer, BindingResult errors, Model model) {

        if (Long.compare(customerId, customer.getId()) != 0) {
            customerService.removeById(customerId);
        }
        customerService.updateCustomer(customer);
        model.addAttribute("message", String.format("customer [Number %s] successfully updated", String.valueOf(customer.getId())));
        return "index";
    }

    @GetMapping("/customer/{customerId}")
    public String showCustomer(@PathVariable("customerId") long customerId, Model model) {

        Customer customer = customerService.findCustomerById(customerId);
        model.addAttribute("customer", customer);
        return "update_customer";
    }
}