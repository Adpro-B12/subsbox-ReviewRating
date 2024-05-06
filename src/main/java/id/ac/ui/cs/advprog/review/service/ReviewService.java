package id.ac.ui.cs.advprog.review.service;

import id.ac.ui.cs.advprog.review.model.Review;

import java.util.List;

public interface ReviewService {
    public Review create(Review review);
    public List<Review> findAll();
    public boolean delete(String reviewId);
    public Review editReview(Review review, String reviewId);
    public Review get(String reviewId);
}
