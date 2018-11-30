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

    public void save(Review review) {
        sessionFactory.getCurrentSession().saveOrUpdate(review);
    }

    public void delete(Review review) {
        sessionFactory.getCurrentSession().delete(review);
    }

    public void update(Review review) {
        sessionFactory.getCurrentSession().update(review);
    }

    public Review get(Long id) {
        return sessionFactory.getCurrentSession().
                createQuery("from Review where id =?1", Review.class).
                setParameter(1, id).getSingleResult();
    }

    public List<Review> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Review", Review.class).
                getResultList();
    }
}