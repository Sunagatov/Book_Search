package com.zufar.repository;

import com.zufar.domain.Country;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CountryRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public CountryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Country country) {
        sessionFactory.getCurrentSession().saveOrUpdate(country);
    }

    public void save(Country country) {
        sessionFactory.getCurrentSession().persist(country);
    }

    public void delete(Country country) {
        sessionFactory.getCurrentSession().delete(country);
    }

    public void update(Country country) {
        sessionFactory.getCurrentSession().update(country);
    }

    public Country get(long id) {
        return sessionFactory.getCurrentSession().
                createQuery("from Country where id =?1", Country.class).
                setParameter(1, id).getSingleResult();
    }

    @Transactional
    public List<Country> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Review", Country.class).
                getResultList();
    }
}