package com.zufar.service;

import com.zufar.domain.Author;
import com.zufar.domain.Book;
import com.zufar.domain.Review;
import com.zufar.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ReviewRepository reviewRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public BookService(
            BookRepository bookRepository,
            AuthorRepository authorRepository,
            ReviewRepository reviewRepository,
            CountryRepository countryRepository
    ) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.reviewRepository = reviewRepository;
        this.countryRepository = countryRepository;
    }

    public void saveList(List<Book> books) {
        for (Book book : books) {
            bookRepository.save(book);
        }
    }

    public void save(Book book) {
        countryRepository.saveOrUpdate(book.getCountry());
        for (Author author : book.getAuthors()) {
            authorRepository.save(author);
        }
//        for (Review review : book.getReviews()) {
//            reviewRepository.save(review);
//        }
        bookRepository.save(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

    public void update(Book author) {
        bookRepository.update(author);
    }

    public Book get(long id) {
        return bookRepository.get(id);
    }

    public List<Book> getAll() {
        return bookRepository.getAll();
    }
}