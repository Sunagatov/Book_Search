package com.zufar.service;

import com.zufar.domain.Author;
import com.zufar.repository.AuthorRepository;
import com.zufar.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    public void save(Author author){
        countryRepository.saveOrUpdate(author.getCountry());
        authorRepository.save(author);
    }

    @Transactional
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Transactional
    public void update(Author author) {
        authorRepository.update(author);
    }

    public Author get(long id) {
        return authorRepository.get(id);
    }

    @Transactional
    public List<Author> getAll() {
        return authorRepository.getAll();
    }
}