package org.spring.tutorial.examples.jdbc.dao;

import java.io.Serializable;
import java.util.List;

public interface AbstractDao<T, ID extends Serializable> {

    T findById(ID id);

    List<T> findAll();
}
