package id.ac.ui.cs.advprog.review.service;

import id.ac.ui.cs.advprog.review.model.Review;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ReviewService {
    public CompletableFuture<Review> create(Review review);
    public CompletableFuture<Iterator<Review>> findAll();
    public CompletableFuture<Boolean> delete(String reviewId);
    public Review get(String reviewId);
    public CompletableFuture<Review> editReview(Review review, String reviewId);
}
