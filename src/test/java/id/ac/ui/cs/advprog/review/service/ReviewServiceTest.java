package id.ac.ui.cs.advprog.review.service;

import id.ac.ui.cs.advprog.review.model.Review;
import id.ac.ui.cs.advprog.review.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {
    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    ReviewServiceImpl reviewService;
    Review review;

    @BeforeEach
    public void setUp(){
        review.setReviewId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        review.setRatingScore(5);
        review.setReview("Barang bagus punya");
        review.setUser(new User());
        review.setSubscriptionBox(new SubscriptionBox());
    }

    @Test
    void testCreateReview(){
        when(reviewRepository.create(review)).thenReturn(review);
        Review createReview = reviewService.create(review);
        assertNotNull(createReview);
        assertEquals(review.getReviewId(), createReview.getReviewId());
    }

    @Test
    void testFindAll(){
        List<Review> reviewList = new ArrayList<>();
        Iterator<Review> reviewIterator = reviewList.iterator();

        when(reviewRepository.findAll()).thenReturn(reviewIterator);
        List<Review> result = reviewService.findAll();

        assertEquals(review, result);
        verify(reviewRepository, times(1)).findAll();
    }

    @Test
    void testDelete(){
        reviewRepository.create(review);

        when(reviewRepository.deleteReview(review)).thenReturn(true);
        assertTrue(reviewRepository.deleteReview(review));
    }
}
