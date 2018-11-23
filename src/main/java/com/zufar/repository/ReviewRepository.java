package com.zufar.repository;

import com.zufar.domain.Review;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ReviewRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public ReviewRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(Review review) {
        sessionFactory.getCurrentSession().persist(review);
    }

    @Transactional
    public void delete(Review review) {
        sessionFactory.getCurrentSession().delete(review);
    }

    @Transactional
    public void update(Review review) {
        sessionFactory.getCurrentSession().update(review);
    }

    @Transactional(readOnly = true)
    public Review get(long id) {
        return sessionFactory.getCurrentSession().
                createQuery("from Review where id =?1", Review.class).
                setParameter(1, id).getSingleResult();
    }

    @Transactional
    public List<Review> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Review", Review.class).
                getResultList();
    }
}