package org.spring.tutorial.rest.boot.services;

import org.spring.tutorial.rest.boot.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

        Optional<User> user = usersList.stream()
                .filter(u -> u.getId()==id)
                .findFirst();
        if(user.isPresent()){
            return user.get();
        }else{
            return null;
        }
    }

    public boolean isUserExist(User user) {

        if (usersList.contains(user))
            return true;
        return false;
    }

    public void saveUser(User user) {

        usersList.add(user);
    }

    public void updateUser(int lastUserID, User newUser) {

        int index = usersList.indexOf(findById(lastUserID));
        if(index>0){
            usersList.set(index, newUser);
        }
    }

    public void deleteUserById(int id) {

        usersList.remove(findById(id));
    }

    public void deleteAllUsers() {

        usersList.clear();
    }


}
