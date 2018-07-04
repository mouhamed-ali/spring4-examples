package org.spring.tutorial.mvc.dao;

import org.spring.tutorial.mvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface IUserDao extends JpaRepository<User, Long> {
}
