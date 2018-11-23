package com.zufar.repository;

import com.zufar.domain.Genre;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GenreRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public GenreRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Genre genre) {
        sessionFactory.getCurrentSession().saveOrUpdate(genre);
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

    public Genre get(long id) {
        return sessionFactory.getCurrentSession().
                createQuery("from Genre where id =?1", Genre.class).
                setParameter(1, id).getSingleResult();
    }

    @Transactional
    public List<Genre> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Genre", Genre.class).
                getResultList();
    }
}