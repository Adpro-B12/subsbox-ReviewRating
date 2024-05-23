package id.ac.ui.cs.advprog.review.controller;

import id.ac.ui.cs.advprog.review.model.Review;
import id.ac.ui.cs.advprog.review.service.ReviewServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReviewPageControllerTest {

    @Mock
    private ReviewServiceImpl reviewService;

    @InjectMocks
    private ReviewPageController reviewController;

    @Test
    public void testCreateReview() {
        Review review = new Review();
        when(reviewService.create(any(Review.class))).thenReturn(review);

        ResponseEntity<Review> responseEntity = reviewController.createReview(review);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(review, responseEntity.getBody());
    }

    @Test
    public void testGetAllReviews() {
        List<Review> reviews = new ArrayList<>();
        when(reviewService.findAll()).thenReturn(reviews);

        ResponseEntity<List<Review>> responseEntity = reviewController.getAllReviews();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(reviews, responseEntity.getBody());
    }

    @Test
    public void testDeleteReview() {
        String reviewId = "123";
        when(reviewService.findReviewById(reviewId)).thenReturn(Optional.of(new Review()));

        ResponseEntity<Void> responseEntity = reviewController.deleteReview(reviewId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(reviewService, times(1)).delete(reviewId);
    }

    @Test
    public void testDeleteReviewNotFound() {
        String reviewId = "123";
        when(reviewService.findReviewById(reviewId)).thenReturn(Optional.empty());

        ResponseEntity<Void> responseEntity = reviewController.deleteReview(reviewId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        verify(reviewService, never()).delete(anyString());
    }

    @Test
    public void testGetReviewByReviewId() {
        String reviewId = "123";
        Review review = new Review();
        when(reviewService.findReviewById(reviewId)).thenReturn(Optional.of(review));

        ResponseEntity<Review> responseEntity = reviewController.getReviewByReviewId(reviewId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(review, responseEntity.getBody());
    }

    @Test
    public void testGetReviewByReviewIdNotFound() {
        String reviewId = "123";
        when(reviewService.findReviewById(reviewId)).thenReturn(Optional.empty());

        ResponseEntity<Review> responseEntity = reviewController.getReviewByReviewId(reviewId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void testUpdateReviewStatus() {
        String reviewId = "123";
        String status = "APPROVED";
        Review review = new Review();
        when(reviewService.updateReviewStatus(reviewId, status)).thenReturn(review);

        ResponseEntity<Review> responseEntity = reviewController.updateReviewStatus(reviewId, status);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(review, responseEntity.getBody());
    }

    @Test
    public void testGetAllReviewsByUserId() {
        String userId = "user123";
        List<Review> reviews = new ArrayList<>();
        when(reviewService.findAllByUserId(userId)).thenReturn(reviews);

        ResponseEntity<List<Review>> responseEntity = reviewController.getAllReviewsByUserId(userId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(reviews, responseEntity.getBody());
    }
}
