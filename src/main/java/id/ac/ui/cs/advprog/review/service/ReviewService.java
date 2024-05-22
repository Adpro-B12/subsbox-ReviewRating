package id.ac.ui.cs.advprog.review.service;

import id.ac.ui.cs.advprog.review.model.Review;

import java.util.List;

public interface ReviewService {
    Review create(Review review);
    List<Review> findAll();
    boolean delete(String reviewId);
    Review findById(String reviewId);
}
