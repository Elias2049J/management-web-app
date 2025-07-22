package org.elias.clase1jsp.usecase;

import org.elias.clase1jsp.entity.User;
import java.util.List;

public interface UserCrud {
    boolean create(User o);
    boolean update(User o);
    User findById(Integer id);
    User getByAttribute(String a);
    boolean delete(Integer id);
    List<User> findAll();
}