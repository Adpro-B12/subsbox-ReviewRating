package id.ac.ui.cs.advprog.review.controller;

import id.ac.ui.cs.advprog.review.model.Review;
import id.ac.ui.cs.advprog.review.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class ReviewPageControllerTest {

    @InjectMocks
    private ReviewPageController reviewPageController;

    @Mock
    private ReviewService reviewService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createReview() throws ExecutionException, InterruptedException {
        // Arrange
        Review review = new Review("1", 5, "Great product", "user1","PENDING");
        when(reviewService.create(any(Review.class))).thenReturn(review);

        // Act
        CompletableFuture<ResponseEntity<Review>> response = reviewPageController.createReview(review);
        ResponseEntity<Review> result = response.get();

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(review, result.getBody());
    }

    @Test
    void getAllReviews() throws ExecutionException, InterruptedException {
        // Arrange
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("1", 5, "Great product", "user1","PENDING"));
        reviews.add(new Review("2", 4, "Mantap", "user2","APPROVED"));
        when(reviewService.findAll()).thenReturn(reviews);

        // Act
        CompletableFuture<ResponseEntity<List<Review>>> response = reviewPageController.getAllReviews();
        ResponseEntity<List<Review>> result = response.get();

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(reviews, result.getBody());
    }

    @Test
    void deleteReview() throws ExecutionException, InterruptedException {
        // Arrange
        String reviewId = "1";
        when(reviewService.findReviewById(reviewId)).thenReturn(Optional.of(new Review("1", 5, "Great product", "user1","PENDING")));

        // Act
        CompletableFuture<ResponseEntity<Void>> response = reviewPageController.deleteReview(reviewId);
        ResponseEntity<Void> result = response.get();

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }

    @Test
    void getReviewByReviewId() throws ExecutionException, InterruptedException {
        // Arrange
        String reviewId = "1";
        Review review = new Review("1", 5, "Great product", "user1","PENDING");
        when(reviewService.findReviewById(reviewId)).thenReturn(Optional.of(review));

        // Act
        CompletableFuture<ResponseEntity<Review>> response = reviewPageController.getReviewByReviewId(reviewId);
        ResponseEntity<Review> result = response.get();

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(review, result.getBody());
    }

    @Test
    void updateReviewStatus() throws ExecutionException, InterruptedException {
        // Arrange
        String reviewId = "1";
        String status = "APPROVED";
        Review review = new Review("1", 5, "Great product", "user1","PENDING");
        when(reviewService.updateReviewStatus(reviewId, status)).thenReturn(review);

        // Act
        CompletableFuture<ResponseEntity<Review>> response = reviewPageController.updateReviewStatus(reviewId, status);
        ResponseEntity<Review> result = response.get();

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(review, result.getBody());
    }

    @Test
    void getAllReviewsByUserId() throws ExecutionException, InterruptedException {
        // Arrange
        String userId = "user1";
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("1", 5, "Great product", "user1","PENDING"));
        when(reviewService.findAllByUserId(userId)).thenReturn(reviews);

        // Act
        CompletableFuture<ResponseEntity<List<Review>>> response = reviewPageController.getAllReviewsByUserId(userId);
        ResponseEntity<List<Review>> result = response.get();

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(reviews, result.getBody());
    }
}