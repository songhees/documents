package com.song.springjpatest;


import com.song.springjpatest.entity.Book;
import com.song.springjpatest.entity.Review;
import com.song.springjpatest.repository.book.BookJpaRepository;
import com.song.springjpatest.repository.review.ReviewJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class JpaRepositoryTest {

    @Autowired
    private ReviewJpaRepository reviewRepository;
    @Autowired
    private BookJpaRepository bookRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    @DisplayName("N:1 에러 테스트 all")
    void testJpaRepository() {
        Book book = Book.builder().title("book1")
                .build();

        bookRepository.save(book);


        Review review = Review.builder().book(book).text("review1").build();
        Review review2 = Review.builder().book(book).text("review1-2").build();

        reviewRepository.save(review);
        reviewRepository.save(review2);

        em.flush();
        em.clear();

        List<Review> result = reviewRepository.findAll();

        String test = result.stream().map(review1 -> review1.getBook().getTitle()).collect(Collectors.joining(", "));
        log.info(test);
        assertThat(result).isNotEmpty();
    }

    @Test
    @DisplayName("N:1 에러 테스트 all/fetch")
    void testJpaFetchRepository() {
        Book book = Book.builder().title("book1")
                .build();
        bookRepository.save(book);

        Review review = Review.builder().book(book).text("review1").build();
        Review review2 = Review.builder().book(book).text("review1-2").build();

        reviewRepository.save(review);
        reviewRepository.save(review2);

        em.flush();
        em.clear();

        List<Review> result = reviewRepository.findFetchAll();

        String test = result.stream().map(review1 -> review1.getBook().getTitle()).collect(Collectors.joining(", "));
        log.info(test);
        assertThat(result).isNotEmpty();
    }

    @Test
    @DisplayName("N:1 에러 테스트 detail")
    void testJpaDetailRepository() {
        Book book = Book.builder().title("book1")
                .build();

        bookRepository.save(book);

        Review review = Review.builder().book(book).text("review1").build();

        reviewRepository.save(review);

        em.flush();
        em.clear();

        Review result = reviewRepository.findAllAndBook(1L);

        log.info(result.getText());
        log.info(result.getBook().getTitle());
        assertThat(result).isNotNull();
    }
}
