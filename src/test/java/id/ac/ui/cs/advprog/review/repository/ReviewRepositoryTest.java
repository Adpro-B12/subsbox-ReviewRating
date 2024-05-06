package id.ac.ui.cs.advprog.review.repository;

import id.ac.ui.cs.advprog.review.model.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ReviewRepositoryTest {

    @InjectMocks
    ReviewRepository reviewRepository;
    Review review1;
    Review review2;

    @BeforeEach
    public void setUp(){
        review1.setReviewId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        review1.setRatingScore(5);
        review1.setReview("Barang bagus punya");
        review1.setUser(new User());
        review1.setSubscriptionBox(new SubscriptionBox());

        review2.setReviewId("07f9b8b0-7257-4434-a5b9-79c9703f0760");
        review2.setRatingScore(1);
        review2.setReview("Gachanya jelek, jangan beli disini deh");
        review2.setUser(new User());
        review2.setSubscriptionBox(new SubscriptionBox());
    }

    @Test
    void testCreateAndFind(){
        reviewRepository.create(review1);
        reviewRepository.create(review2);

        assertNotNull(reviewRepository);

        Iterator<Review> ratingIterator = reviewRepository.findAll();
        assertTrue(ratingIterator.hasNext());
        Review savedReview = ratingIterator.next();
        assertEquals(review1.getReviewId(), savedReview.getReviewId());
        assertEquals(review1.getRatingScore(), savedReview.getRatingScore());
    }

    @Test
    void testFindAllEmpty(){
        Iterator<Review> ratingIterator = reviewRepository.findAll();
        assertFalse(ratingIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct(){
        reviewRepository.create(review1);
        reviewRepository.create(review2);

        Iterator<Review> ratingIterator = reviewRepository.findAll();
        assertTrue(ratingIterator.hasNext());
        Review savedReview = ratingIterator.next();
        assertEquals(review1.getReviewId(), savedReview.getReviewId());

        savedReview = ratingIterator.next();
        assertEquals(review2.getReviewId(), savedReview.getReviewId());
    }

    @Test
    void testDeleteRepositoryReview(){
        reviewRepository.create(review1);
        reviewRepository.create(review2);

        reviewRepository.deleteReview(review1);

        Iterator<Review> ratingIterator = reviewRepository.findAll();
        assertTrue(ratingIterator.hasNext());
        Review savedReview = ratingIterator.next();

        assertNotEquals(review1.getReviewId(), savedReview.getReviewId());
        assertEquals(review2.getReviewId(), savedReview.getReviewId());
    }
}
