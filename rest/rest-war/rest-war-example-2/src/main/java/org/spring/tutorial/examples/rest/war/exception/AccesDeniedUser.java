package org.spring.tutorial.examples.rest.war.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)//404
/*
	we can also use an another status like NOT_ACCEPTABLE
	if we use this exception in our controller it will return the 404 status
	to the customer app
 */
public class AccesDeniedUser extends RuntimeException {

    private static final long serialVersionUID = -4250063119663086364L;

    public AccesDeniedUser(Exception e) {
        super(e);
    }

    public AccesDeniedUser(String message) {
        super(message);
    }
}
