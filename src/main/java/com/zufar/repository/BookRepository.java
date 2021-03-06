package com.zufar.repository;

import com.zufar.domain.Author;
import com.zufar.domain.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public BookRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void persist(Book book) {
        sessionFactory.getCurrentSession().persist(book);
    }

    public void delete(Book book) {
        sessionFactory.getCurrentSession().delete(book);
    }

    public void delete(List<Long> bookIds) {
        sessionFactory.getCurrentSession().createQuery("from Book c where c.id in ?1", Book.class).
                setParameter(1, bookIds);
    }

    public void update(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }

    public Book get(Long id) {
        return sessionFactory.getCurrentSession().
                createQuery("from Book where id =?1", Book.class).
                setParameter(1, id).getSingleResult();
    }

    public List<Book> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Book", Book.class).
                getResultList();
    }

    public List<Book> getAll(List<Long> bookIds) {
        return sessionFactory.getCurrentSession().
                createQuery("from Book c where c.id in ?1", Book.class).
                setParameter(1, bookIds).
                getResultList();
    }
}