package org.spring.tutorial.rest.boot.services.impl;

import org.spring.tutorial.rest.boot.models.User;
import org.spring.tutorial.rest.boot.services.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private List<User> usersList;

    public UserServiceImpl() {

        usersList = new ArrayList<User>();
        usersList.add(new User(1, "user 1", "password 1"));
        usersList.add(new User(2, "user 2", "password 2"));
        usersList.add(new User(3, "user 3", "password 3"));
        usersList.add(new User(4, "user 4", "password 4"));
        usersList.add(new User(5, "user 5", "password 5"));
    }

    public List<User> findAllUsers() {
        return usersList;
    }

    public User findById(int id) {

        for (User user : usersList) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public boolean isUserExist(User user) {
        if (usersList.contains(user))
            return true;
        return false;
    }

    public void saveUser(User user) {

        usersList.add(user);
    }

    public void updateUser(User currentUser) {

    }

    public void deleteUserById(int id) {

        usersList.remove(findById(id));
    }

    public void deleteAllUsers() {

        usersList = new ArrayList<>();
    }


}
