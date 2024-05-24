package id.ac.ui.cs.advprog.review.service;

import enums.Status;
import id.ac.ui.cs.advprog.review.model.Review;
import id.ac.ui.cs.advprog.review.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReviewServiceImplTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        Review review = new Review();
        when(reviewRepository.save(review)).thenReturn(review);

        Review createdReview = reviewService.create(review);

        assertNotNull(createdReview);
        verify(reviewRepository, times(1)).save(review);
    }

    @Test
    void testFindAll() {
        Review review1 = new Review();
        Review review2 = new Review();
        List<Review> reviews = Arrays.asList(review1, review2);
        when(reviewRepository.findAll()).thenReturn(reviews);

        List<Review> result = reviewService.findAll();

        assertEquals(2, result.size());
        verify(reviewRepository, times(1)).findAll();
    }

    @Test
    void testDelete() {
        String reviewId = "1";

        reviewService.delete(reviewId);

        verify(reviewRepository, times(1)).deleteById(reviewId);
    }

    @Test
    void testFindReviewById() {
        String reviewId = "1";
        Review review = new Review();
        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));

        Optional<Review> result = reviewService.findReviewById(reviewId);

        assertTrue(result.isPresent());
        assertEquals(review, result.get());
        verify(reviewRepository, times(1)).findById(reviewId);
    }

    @Test
    void testFindAllByUserId() {
        String userId = "user1";
        Review review1 = new Review();
        Review review2 = new Review();
        List<Review> reviews = Arrays.asList(review1, review2);
        when(reviewRepository.findAllByUserId(userId)).thenReturn(reviews);

        List<Review> result = reviewService.findAllByUserId(userId);

        assertEquals(2, result.size());
        verify(reviewRepository, times(1)).findAllByUserId(userId);
    }

    @Test
    void testUpdateReviewStatus_Approved() {
        String reviewId = "1";
        Review review = new Review();
        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));

        Review updatedReview = reviewService.updateReviewStatus(reviewId, "APPROVED");

        assertNotNull(updatedReview);
        verify(reviewRepository, times(1)).findById(reviewId);
        verify(reviewRepository, times(1)).save(review);
        assertEquals(Status.APPROVED, updatedReview.getReviewStatus());
    }

    @Test
    void testUpdateReviewStatus_Rejected() {
        String reviewId = "1";
        Review review = new Review();
        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));

        Review updatedReview = reviewService.updateReviewStatus(reviewId, "REJECTED");

        assertNotNull(updatedReview);
        verify(reviewRepository, times(1)).findById(reviewId);
        verify(reviewRepository, times(1)).save(review);
        assertEquals(Status.REJECTED, updatedReview.getReviewStatus());
    }

    @Test
    void testUpdateReviewStatus_InvalidStatus() {
        String reviewId = "1";
        Review review = new Review();
        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            reviewService.updateReviewStatus(reviewId, "INVALID_STATUS");
        });

        String expectedMessage = "Invalid status";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(reviewRepository, times(1)).findById(reviewId);
        verify(reviewRepository, times(0)).save(review);
    }
}
