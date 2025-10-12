package com.song.springjpatest.repository.review;

import com.song.springjpatest.entity.Review;

import java.util.List;

public class ReviewRepositoryImpl implements ReviewRepository {



    @Override
    public List<Review> getReviewsByBook(Long bookId) {


        return List.of();
    }
}
