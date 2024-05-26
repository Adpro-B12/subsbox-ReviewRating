package id.ac.ui.cs.advprog.review.service;

import enums.Status;
import id.ac.ui.cs.advprog.review.model.Review;
import id.ac.ui.cs.advprog.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void delete(String reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public Optional<Review> findReviewById(String reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public List<Review> findAllByUserId(String userId){
        return reviewRepository.findAllByUserId(userId);
    }

    @Override
    public Review updateReviewStatus(String reviewId, String status){
        Review review = reviewRepository.findById(reviewId)
            .orElseThrow(() -> new IllegalArgumentException("Review not found with ID: " + reviewId));
        if (status.equalsIgnoreCase(Status.APPROVED.toString())) {
            review.approve();
        } else if (status.equalsIgnoreCase(Status.REJECTED.toString())) {
            review.reject();
        } else {
            throw new IllegalArgumentException("Invalid status");
        }

        reviewRepository.save(review);
        return review;
    }

    @Override
    public List<Review> findAllBySubscriptionBoxId(String subscriptionBoxId) {
        return reviewRepository.findAllBySubscriptionBoxId(subscriptionBoxId);
    }
}