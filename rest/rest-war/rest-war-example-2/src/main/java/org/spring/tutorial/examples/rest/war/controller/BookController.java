package org.spring.tutorial.examples.rest.war.controller;

import org.spring.tutorial.examples.rest.war.domain.Book;
import org.spring.tutorial.examples.rest.war.exception.book.BookNotFoundException;
import org.spring.tutorial.examples.rest.war.exception.book.NotAuthorizedException;
import org.spring.tutorial.examples.rest.war.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    /*
     * http://localhost:8080/rest-war-example-2/books
     * this will handle json and xml requests
     */
    @Autowired
    BookServiceImpl service;

    @GetMapping(path = {"/{name}"}, produces = {"application/json", "application/xml"})
    @ResponseBody
    public Book findOne(@PathVariable("name") String name) {

        return service.findBookByName(name);
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
     * another reason to separate methods. if we want to generate an exception in the case of the xml response
     * check this to know more about ResponseEntity<Void> : https://stackoverflow.com/questions/26550124/spring-returning-empty-http-responses-with-responseentityvoid-doesnt-work
     */
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {

        if (service.findBookById(id)==null) {
            throw new BookNotFoundException("not found book");
        }
        service.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}", produces = "application/xml")
    @ResponseStatus(value=HttpStatus.CONFLICT, reason="Well you are not authorized to get this resource")  // 409
    @ExceptionHandler(NotAuthorizedException.class)
    // use @ExceptionHandler with exceptions that don't have the @ResponseStatus. Gonna be always exceptions that you didn't create or you don't
    // have control on them like java exception
    /*
     * if the method generates the NotAuthorizedException exception we will generate an HttpStatus.CONFLICT as status
     */
    public ResponseEntity<Void> deleteXml(@PathVariable("id") Integer id) {

        if (service.findBookById(id)==null) {
            throw new NotAuthorizedException("Not authorized");
        }
        service.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
