package org.spring.tutorial.examples.rest.war.controller;

import org.spring.tutorial.examples.rest.war.domain.Book;
import org.spring.tutorial.examples.rest.war.exception.BookNotFoundException;
import org.spring.tutorial.examples.rest.war.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    /*
        http://localhost:8080/rest-war-example-2/books
     */
    @Autowired
    BookServiceImpl service;

    @GetMapping(path = {"/{name}"}, produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Book findOne(@PathVariable("name") String id) {

        //TODO : add xml support to the Book entity
        return service.findBookById(id);
    }

    /*
     * why we use the product / consumes in a method ???
     * It is usually to separate rest clients and make our application more flexible. in this case for example, our application
     * responds to three types of client rest / json, rest / xml and browser / html. for the first two, the requests will be redirect
     * to the first method and for the last one the requests will be redirected to the below method since the first two
     * can not answer it.
     * this method is not operational because we have not configured the servlet dispatcher
     */
    @GetMapping(path = {"/{name}"})
    @ResponseBody
    public String findOne(Model model, @PathVariable("name") String name) {

        model.addAttribute("book", findOne(name));
        return "show_book";
    }

    /*
         another reason to separate methods. the reason for separation is that we
        want to generate an exception in the case of the xml response
     */
    @DeleteMapping(path = "/{name}", produces = "application/json")
    public void delete(@PathVariable("name") String name) {

        //TODO doest not work
        service.deleteBook(name);
    }

    @DeleteMapping(path = "/{name}", produces = "application/xml")
    public void deleteXml(@PathVariable("name") String name) throws BookNotFoundException {

        //TODO doest not work
        if (name.equals("Les miserables")) {
            throw new BookNotFoundException("not found book");
        }
        service.deleteBook(name);
    }

}
