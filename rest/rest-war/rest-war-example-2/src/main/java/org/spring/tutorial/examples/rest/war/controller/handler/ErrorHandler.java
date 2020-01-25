package org.spring.tutorial.examples.rest.war.controller.handler;

import org.spring.tutorial.examples.rest.war.exception.user.AccesDeniedUser;
import org.spring.tutorial.examples.rest.war.exception.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;

@RestControllerAdvice
public class ErrorHandler {

    // this method will be used across all controllers
    @ExceptionHandler(AccesDeniedUser.class)
    /*
     * in this case we will return a json object in the response
     */
    public ResponseEntity<AccesDeniedUser> handleAccesDeniedUserException(AccesDeniedUser adu) {

        return new ResponseEntity<>(adu, HttpStatus.NOT_FOUND);
    }

    // for multiple exceptions
    @ExceptionHandler({
            FileNotFoundException.class,
            UserNotFoundException.class
    })
    /*
     * in this case we will return a json object in the response
     */
    public ResponseEntity<Object> handleCustomException(Exception ex) {

        if (ex instanceof FileNotFoundException)
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        else if (ex instanceof UserNotFoundException)
            return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
