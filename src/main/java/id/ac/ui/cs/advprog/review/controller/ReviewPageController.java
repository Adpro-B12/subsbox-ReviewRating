package id.ac.ui.cs.advprog.review.controller;

import id.ac.ui.cs.advprog.review.model.Review;
import id.ac.ui.cs.advprog.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/reviews")
public class ReviewPageController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public CompletableFuture<ResponseEntity<Review>> createReview(@RequestBody Review review) {
        return CompletableFuture.supplyAsync(() -> {
            Review createdReview = reviewService.create(review);
            return ResponseEntity.ok(createdReview);
        });
    }

    @GetMapping("/all")
    public CompletableFuture<ResponseEntity<List<Review>>> getAllReviews() {
        return CompletableFuture.supplyAsync(() -> {
            List<Review> reviews = reviewService.findAll();
            return ResponseEntity.ok(reviews);
        });
    }

    @DeleteMapping("/delete/{reviewId}")
    public CompletableFuture<ResponseEntity<Void>> deleteReview(@PathVariable String reviewId) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<Review> review = reviewService.findReviewById(reviewId);
            if (review.isPresent()) {
                reviewService.delete(reviewId);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        });
    }

    @GetMapping("/{reviewId}")
    public CompletableFuture<ResponseEntity<Review>> getReviewByReviewId(@PathVariable String reviewId) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<Review> review = reviewService.findReviewById(reviewId);
            return review.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        });
    }

    @PatchMapping("/{reviewId}/status")
    public CompletableFuture<ResponseEntity<Review>> updateReviewStatus(@PathVariable String reviewId, @RequestParam String status) {
        return CompletableFuture.supplyAsync(() -> {
            Review updatedReview = reviewService.updateReviewStatus(reviewId, status);
            return ResponseEntity.ok(updatedReview);
        });
    }

    @GetMapping("/user/{userId}")
    public CompletableFuture<ResponseEntity<List<Review>>> getAllReviewsByUserId(@PathVariable String userId) {
        return CompletableFuture.supplyAsync(() -> {
            List<Review> reviews = reviewService.findAllByUserId(userId);
            return ResponseEntity.ok(reviews);
        });
    }

    @GetMapping("/subscription/{subscriptionBoxId}")
    public CompletableFuture<ResponseEntity<List<Review>>> getAllReviewsBySubscriptionBoxId(@PathVariable String subscriptionBoxId) {
        return CompletableFuture.supplyAsync(() -> {
            List<Review> reviews = reviewService.findAllBySubscriptionBoxId(subscriptionBoxId);
            return ResponseEntity.ok(reviews);
        });
    }
}
