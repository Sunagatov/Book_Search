package com.zufar.repository;

import com.zufar.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void persist(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public User get(Long id) {
        return sessionFactory.getCurrentSession().
                createQuery("from User where id =?1", User.class).
                setParameter(1, id).getSingleResult();
    }

    public User get(String login, String password) {
        return sessionFactory.getCurrentSession().
                createQuery("from User where LOGIN =?1 and PASSWORD =?2", User.class).
                setParameter(1, login).setParameter(2, password).getSingleResult();
    }

    public List<User> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from User", User.class).
                getResultList();
    }

    public boolean isLoginUnique(String login) {
        String loginFromDB = sessionFactory.getCurrentSession().
                createQuery("select LOGIN from User where LOGIN =?1", String.class).
                setParameter(1, login).getSingleResult();
        return loginFromDB == null;
    }
}