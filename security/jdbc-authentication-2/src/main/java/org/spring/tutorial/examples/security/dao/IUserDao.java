package org.spring.tutorial.examples.security.dao;

import org.spring.tutorial.examples.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface IUserDao extends JpaRepository<User, Long> {
}
