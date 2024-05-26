package id.ac.ui.cs.advprog.review.service;

import enums.Status;
import id.ac.ui.cs.advprog.review.model.Review;
import id.ac.ui.cs.advprog.review.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceImplTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @Test
    public void testCreateReview() {
        Review review = new Review();
        review.setReviewId("1");
        review.setUserId("user1");

        when(reviewRepository.save(review)).thenReturn(review);

        Review createdReview = reviewService.create(review);

        assertNotNull(createdReview);
        assertEquals("1", createdReview.getReviewId());
        assertEquals("user1", createdReview.getUserId());
    }

    @Test
    public void testFindAllReviews() {
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review());
        reviews.add(new Review());

        when(reviewRepository.findAll()).thenReturn(reviews);

        List<Review> foundReviews = reviewService.findAll();

        assertEquals(2, foundReviews.size());
    }

    @Test
    public void testDeleteReview() {
        String reviewId = "1";

        doNothing().when(reviewRepository).deleteById(reviewId);

        assertDoesNotThrow(() -> reviewService.delete(reviewId));
    }

    @Test
    public void testFindReviewById() {
        Review review = new Review();
        review.setReviewId("1");
        review.setUserId("user1");

        when(reviewRepository.findById("1")).thenReturn(Optional.of(review));

        Optional<Review> foundReview = reviewService.findReviewById("1");

        assertTrue(foundReview.isPresent());
        assertEquals("1", foundReview.get().getReviewId());
        assertEquals("user1", foundReview.get().getUserId());
    }

    @Test
    public void testUpdateReviewStatus() {
        Review review = new Review();
        review.setReviewId("1");
        review.setReviewStatus(Status.PENDING);

        when(reviewRepository.findById("1")).thenReturn(Optional.of(review));
        when(reviewRepository.save(review)).thenReturn(review);

        Review updatedReview = reviewService.updateReviewStatus("1", Status.APPROVED.toString());

        assertEquals(Status.APPROVED, updatedReview.getReviewStatus());
    }

    @Test
    public void testUpdateReviewStatus_InvalidStatus() {
        Review review = new Review();
        review.setReviewId("1");
        review.setReviewStatus(Status.PENDING);

        when(reviewRepository.findById("1")).thenReturn(Optional.of(review));

        assertThrows(IllegalArgumentException.class, () -> reviewService.updateReviewStatus("1", "INVALID"));
    }

    @Test
    public void testFindAllByUserId() {
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review());
        reviews.add(new Review());

        when(reviewRepository.findAllByUserId("user1")).thenReturn(reviews);

        List<Review> foundReviews = reviewService.findAllByUserId("user1");

        assertEquals(2, foundReviews.size());
    }

    @Test
    public void testFindAllBySubscriptionBoxId() {
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review());
        reviews.add(new Review());

        when(reviewRepository.findAllBySubscriptionBoxId("box1")).thenReturn(reviews);

        List<Review> foundReviews = reviewService.findAllBySubscriptionBoxId("box1");

        assertEquals(2, foundReviews.size());
    }
}
