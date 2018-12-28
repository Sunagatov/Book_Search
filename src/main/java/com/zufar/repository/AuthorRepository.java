package com.zufar.repository;

import com.zufar.domain.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaDelete;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Repository
public class AuthorRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public AuthorRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long persist(Author author) {
        return (Long) sessionFactory.getCurrentSession().save(author);
    }

    public void delete(Author author) {
        sessionFactory.getCurrentSession().delete(author);
    }

    public void update(Author author) {
        sessionFactory.getCurrentSession().update(author);
    }

    public Author get(Long id) {
        return sessionFactory.getCurrentSession().
                createQuery("from Author where id =?1", Author.class).
                setParameter(1, id).getSingleResult();
    }

    public List<Author> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Author", Author.class).
                getResultList();
    }

    public List<Author> getAll(Set<Long> authorIds) {
        return sessionFactory.getCurrentSession().
                createQuery("from Author c where c.id in ?1", Author.class).
                setParameter(1, authorIds).
                getResultList();
    }

//    public List<Author> getAll(Long bookId) {
//        return sessionFactory.getCurrentSession().
//                createQuery("from Author c where c.id in ?1", Author.class).
//                setParameter(1, authorIds).
//                getResultList();
//    }


}