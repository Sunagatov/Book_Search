package com.zufar.service;

import com.zufar.domain.Review;
import com.zufar.repository.BookRepository;
import com.zufar.repository.ReviewRepository;
import com.zufar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReviewService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(
            BookRepository bookRepository,
            UserRepository userRepository,
            ReviewRepository reviewRepository
    ) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }

    @Transactional
    public void save(Review review) {
        bookRepository.save(review.getBook());
        userRepository.save(review.getUser());
        reviewRepository.save(review);
    }

    @Transactional
    public void delete(Review review) {
        reviewRepository.delete(review);
    }

    @Transactional
    public void update(Review review) {
        reviewRepository.update(review);
    }

    public Review get(long id) {
        return reviewRepository.get(id);
    }

    @Transactional
    public List<Review> getAll() {
        return reviewRepository.getAll();
    }
}