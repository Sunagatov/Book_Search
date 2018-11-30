package com.zufar.service;

import com.zufar.domain.Author;
import com.zufar.domain.Book;
import com.zufar.domain.Country;
import com.zufar.domain.Genre;
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
        LocalDate publication_date = LocalDate.of(publication_dateDTO.getYear(), publication_dateDTO.getMonth(), publication_dateDTO.getDay());
        Long countryId = bookDTO.getCountryId();
        Country country = countryRepository.get(countryId);
        Set<Long> authorsIds = bookDTO.getAuthorsIds();
        List<Author> authors = authorRepository.getAll(authorsIds);
        Set<Long> genresIds = bookDTO.getGenresIds();
        List<Genre> genres = genreRepository.getAll(genresIds);

        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setPublication_date(publication_date);
        book.setPage_count(bookDTO.getPage_count());
        book.setCountry(country);
        book.setGenres(genres);
        book.setAuthors(authors);
        bookRepository.persist(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

    public void update(Book author) {
        bookRepository.update(author);
    }

    public Book get(Long id) {
        Book book = bookRepository.get(id);
        return book;
    }

    public List<Book> getAll() {
        return bookRepository.getAll();
    }
}