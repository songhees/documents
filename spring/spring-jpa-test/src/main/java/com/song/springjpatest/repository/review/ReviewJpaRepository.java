package com.song.springjpatest.repository.review;

import com.song.springjpatest.entity.Review;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// JpaRepository를 확장했으므로 Jpa가 이를 인식함
public interface ReviewJpaRepository extends JpaRepository<Review, Long>, ReviewRepository {

    @Nonnull
    @Query("select r from Review r")
    List<Review> findAll();

    @Query("select r from Review r  JOIN FETCH r.book")
    List<Review> findFetchAll();

    @Query("select r, r.book from Review r where r.id = :id")
    Review findAllAndBook(@Param("id") Long id);
}
