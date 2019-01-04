package com.zufar.service;

import com.zufar.domain.*;
import com.zufar.dto.BookDTO;
import com.zufar.dto.DateDTO;
import com.zufar.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ReviewRepository reviewRepository;
    private final CountryRepository countryRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public BookService(
            BookRepository bookRepository,
            AuthorRepository authorRepository,
            ReviewRepository reviewRepository,
            CountryRepository countryRepository,
            GenreRepository genreRepository
    ) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.reviewRepository = reviewRepository;
        this.countryRepository = countryRepository;
        this.genreRepository = genreRepository;
    }

    public void save(BookDTO bookDTO) {
        DateDTO publication_dateDTO = bookDTO.getPublication_date();
        LocalDate publication_date = LocalDate.of(publication_dateDTO.getYear(), publication_dateDTO.getMonth(),
                publication_dateDTO.getDay());
        Long countryId = bookDTO.getCountryId();
        Country country = countryRepository.get(countryId);
        List<Author> authors = authorRepository.getAll(bookDTO.getAuthorsIds());
        List<Genre> genres = genreRepository.getAll(bookDTO.getGenresIds());
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setPublication_date(publication_date);
        book.setPage_count(bookDTO.getPage_count());
        book.setCountry(country);
        book.setGenres(genres);
        book.setAuthors(authors);
        bookRepository.persist(book);
        for (Author author : authors) {
            author.getBooks().add(book);
            authorRepository.update(author);
        }

    }

    public void delete(Book book) {
        for (Author author : book.getAuthors()) {
            author.getBooks().remove(book);
            authorRepository.update(author);
        }
        bookRepository.delete(book);
    }

    public void update(Book book) {
        bookRepository.update(book);
    }

    public Book get(Long id) {
        return bookRepository.get(id);
    }

    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    public List<Book> getAll(List<Long> bookIds) {
        return bookRepository.getAll(bookIds);
    }
}