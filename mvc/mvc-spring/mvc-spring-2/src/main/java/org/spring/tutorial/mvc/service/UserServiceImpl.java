package org.spring.tutorial.mvc.service;

import org.spring.tutorial.mvc.domain.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements IUserService {

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

    public User updateUser(User user) {

        for (User u : users) {
            if (Long.compare(u.getId(), user.getId()) == 0) {
                users.remove(u);
                users.add(user);
                return user;
            }
        }
        return addUser(user);
    }

    public List<User> getUsers() {

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
