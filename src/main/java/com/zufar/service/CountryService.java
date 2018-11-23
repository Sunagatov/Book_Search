package com.zufar.service;

import com.zufar.domain.Country;
import com.zufar.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void save(Country country){
        countryRepository.save(country);
    }

    @Transactional
    public void delete(Country country) {
        countryRepository.delete(country);
    }

    @Transactional
    public void update(Country country) {
        countryRepository.update(country);
    }

    public Country get(long id) {
        return countryRepository.get(id);
    }

    @Transactional
    public List<Country> getAll() {
        return countryRepository.getAll();
    }
}