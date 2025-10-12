package com.song.springjpatest.repository.review;

import com.song.springjpatest.entity.Review;

import java.util.List;

public interface ReviewRepository {

    List<Review> getReviewsByBook(Long bookId);


}
