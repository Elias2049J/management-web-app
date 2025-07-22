package org.elias.clase1jsp.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.elias.clase1jsp.entity.User;
import org.elias.clase1jsp.usecase.UserCrud;

import java.util.List;
import java.util.logging.Logger;

@AllArgsConstructor
@NoArgsConstructor
public class UserCrudService implements UserCrud {
    private SecurityService securityService;
    private List<User> users;
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public boolean create(User o) {
        o.setPassHashed(securityService.encrypt(o.getPassHashed()));
        log.info(String.format("New User created: %s \n",o));
        return users.add(o);
    }

    @Override
    public boolean update(User o) {
        return false;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User getByAttribute(String a) {
        return users.stream()
                .filter(user -> user.getName().equals(a))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
