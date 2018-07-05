package org.spring.tutorial.mvc.domain;

public class User {

    /*
     * la validation des champs ci dessous sera r�alis� par spring lors de l interception
     * des parametres depuis l IHM
     */
    //@NotNull(message = "User ID is required.")
    //@Min(value = 1000, message = "User ID must be at least 4 digits.")
    private long id;

    //@NotNull(message = "User name is required.")
    private String name;

    //@NotNull(message = "User email is required.")
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
