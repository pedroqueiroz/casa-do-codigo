package org.casadocodigo.store.dao;

import org.casadocodigo.store.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAO implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;

    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        List<User> users = manager.createQuery("select u from User u where u.email = :email", User.class)
            .setParameter("email", email)
            .getResultList();

        if (users.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User %s was not found", email));
        }

        return users.get(0);
    }
}
