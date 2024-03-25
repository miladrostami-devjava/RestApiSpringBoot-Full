package com.embarkx.firstjobapp.review.service;

import com.embarkx.firstjobapp.review.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);
boolean addReview(Review review,Long companyId);
Review getReview(Long companyId,Long reviewId);
boolean updateReview(Long companyId,Long reviewId,Review updatedReview);
    boolean deleteReview(Long companyId,Long reviewId);



}
