package com.zufar.repository;

import com.zufar.domain.Book;
import com.zufar.domain.Genre;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class GenreRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public GenreRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Genre genre) {
        sessionFactory.getCurrentSession().persist(genre);
    }

    public void delete(Genre genre) {
        sessionFactory.getCurrentSession().delete(genre);
    }

    public void update(Genre genre) {
        sessionFactory.getCurrentSession().update(genre);
    }

    public Genre get(Long id) {
        return sessionFactory.getCurrentSession().
                createQuery("from Genre where id =?1", Genre.class).
                setParameter(1, id).getSingleResult();
    }

    public List<Genre> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Genre", Genre.class).
                getResultList();
    }

    public List<Genre> getAll(Set<Long> genreIds) {
        return sessionFactory.getCurrentSession().
                createQuery("from Genre c where c.id in ?1", Genre.class).
                setParameter(1, genreIds).
                getResultList();
    }
}