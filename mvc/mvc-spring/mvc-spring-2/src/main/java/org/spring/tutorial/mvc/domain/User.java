package org.spring.tutorial.mvc.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {

    /*
     * validation of the fields below will be done by spring during the interception
     * of the GUI (guest user interface) fields
     */
    //TODO : spring validation doesn't work
    @NotNull(message = "User ID is required.")
    @Min(value = 999, message = "User ID must contains 4 digits at least.")
    private long id;

    @NotNull(message = "User name is required.")
    private String name;

    @NotNull(message = "User email is required.")
    private String email;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(long id, String name, String email) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
    }


}
