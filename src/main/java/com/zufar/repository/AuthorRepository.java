package com.zufar.repository;

import com.zufar.domain.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthorRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public AuthorRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Author author) {
        sessionFactory.getCurrentSession().persist(author);
    }

    public void delete(Author author) {
        sessionFactory.getCurrentSession().delete(author);
    }

    public void update(Author author) {
        sessionFactory.getCurrentSession().update(author);
    }

    public Author get(long id) {
        return sessionFactory.getCurrentSession().
                createQuery("from Author where id =?1", Author.class).
                setParameter(1, id).getSingleResult();
    }

    public List<Author> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Author", Author.class).
                getResultList();
    }
}