package id.ac.ui.cs.advprog.review.service;

import id.ac.ui.cs.advprog.review.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review create(Review review);
    List<Review> findAll();
    void delete(String reviewId);
    Optional<Review> findReviewById(String reviewId);
    List<Review> findAllByUserId(String userId);
    Review updateReviewStatus(String idReview, String status);

    List<Review> findAllBySubscriptionBoxId(String subscriptionBoxId);
}
