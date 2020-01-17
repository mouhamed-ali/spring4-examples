package org.spring.tutorial.examples.security.service;

import org.spring.tutorial.examples.security.dao.IUserDao;
import org.spring.tutorial.examples.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
/*
 * the security of this layer methods can be done by the spring annotations or the jsr
 * if we are going to use the jsr
 * @EnableGlobalMethodSecurity (jsr250Enabled = true)
 * but in this case we will use the spring annotations
 */
@EnableGlobalMethodSecurity(securedEnabled = true)
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @PostConstruct
    private void init() {
        createUser(new User(1, "Daniel", "Alves"));
        createUser(new User(2, "Vladimir", "Botin"));
        createUser(new User(3, "Ivanka", "Trump"));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public User createUser(User user) {

        return userDao.save(user);
    }

    @Secured("ROLE_ADMIN")
    public User updateUser(User user) {

        return userDao.save(user);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public User findUserById(Long id) {

        return userDao.findOne(id);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<User> getAll() {

        return userDao.findAll();
    }

    @Secured("ROLE_ADMIN")
    public void removeById(Long id) {
        userDao.delete(id);
    }
}
