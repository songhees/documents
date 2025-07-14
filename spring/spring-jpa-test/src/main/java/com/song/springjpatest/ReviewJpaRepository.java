package com.song.springjpatest;

import com.song.springjpatest.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewJpaRepository extends JpaRepository<Review, Long> {

    @Query("select r from Review r")
    List<Review> findAll();

    @Query("select r from Review r  JOIN FETCH r.book")
    List<Review> findFetchAll();

    @Query("select r, r.book from Review r where r.id = :id")
    Review findAllAndBook(@Param("id") Long id);
}
