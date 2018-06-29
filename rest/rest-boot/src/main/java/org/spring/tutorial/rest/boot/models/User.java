package org.spring.tutorial.rest.boot.models;


import java.util.Objects;

public class User {

    private int id;
    private String login;
    private String password;

    public User() {
        /*
            i had some problems with the create and the put requests because i didn't create this
            default constructor
         */
    }

    public User(int id, String login, String password) {
        super();
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
