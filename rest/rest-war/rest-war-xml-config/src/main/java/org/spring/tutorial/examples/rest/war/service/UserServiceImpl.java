package org.spring.tutorial.examples.rest.war.service;

import org.spring.tutorial.examples.rest.war.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl {

    private List<User> users;

    @PostConstruct
    public void init() {

        users = new ArrayList<User>();
        users.add(new User(1, "Dummy", "dummy@dummy.com"));
        users.add(new User(2, "Raul", "Raul@Raul.com"));
        users.add(new User(3, "Leo", "Leo@Leo.com"));
        users.add(new User(4, "jean", "jean@jean.com"));
        users.add(new User(5, "francois", "francois@francois.com"));
    }

    public User addUser(User user) {

        users.add(user);
        return user;
    }

    public User updateUser(Long id, User user) {

        users.remove(findUserById(id));
        return addUser(user);
    }

    public List<User> findAll() {

        return users;
    }

    public boolean deleteUser(Long id) {

        boolean found = false;
        for (User u : users) {
            if (Long.compare(u.getId(), id) == 0) {
                users.remove(u);
                found = true;
                break;
            }
        }
        return found;
    }

    public User findUserById(Long id) {

        for (User u : users) {
            if (Long.compare(u.getId(), id) == 0) {
                return u;
            }
        }
        return null;
    }

}
