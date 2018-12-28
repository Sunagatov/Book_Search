package com.zufar.service;

import com.zufar.domain.*;
import com.zufar.dto.AuthorDTO;
import com.zufar.dto.DateDTO;
import com.zufar.repository.AuthorRepository;
import com.zufar.repository.BookRepository;
import com.zufar.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
    }

    public Long save(AuthorDTO authorDTO) {
        DateDTO birthdayDTO = authorDTO.getBirthday();
        DateDTO deathdayDTO = authorDTO.getDeathday();
        LocalDate birthday = LocalDate.of(birthdayDTO.getYear(), birthdayDTO.getMonth(), birthdayDTO.getDay());
        LocalDate deathday = LocalDate.of(deathdayDTO.getYear(), deathdayDTO.getMonth(), deathdayDTO.getDay());
        Long countryId = authorDTO.getCountryId();
        Country country = countryRepository.get(countryId);

        Author author = new Author();
        author.setFirst_name(authorDTO.getFirst_name());
        author.setLast_name(authorDTO.getLast_name());
        author.setNick_name(authorDTO.getNick_name());
        author.setPatronymic(authorDTO.getPatronymic());
        author.setBirthday(birthday);
        author.setDeathday(deathday);
        author.setSex(Sex.MALE);
        author.setCountry(country);

        return authorRepository.persist(author);
    }

    public void delete(Author author) {
        authorRepository.delete(author);
        List<Long> bookIds = author.getBooks().stream().map(Book::getId).collect(Collectors.toList());
        bookRepository.delete(bookIds);
    }

    public void update(Author author) {
        authorRepository.update(author);
    }

    public Author get(Long id) {
        return authorRepository.get(id);
    }

    public List<Author> getAll() {
        return authorRepository.getAll();
    }

    public List<Author> getAll(Set<Long> authorIds) {
        return authorRepository.getAll(authorIds);
    }
}