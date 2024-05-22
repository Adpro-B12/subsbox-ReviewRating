package id.ac.ui.cs.advprog.review.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RatingTest {
    private  Review rating;
//    private User user;
//    private SubscriptionBox subscriptionBox;

//    @BeforeEach
//    public void setUp(){
//        rating = new Review();
//        this.rating.setReviewId("eb558e9f-1c39-460e-8860-71af6af63bd6");
//        this.rating.setRatingScore(5);
//        this.rating.setReview("Barang bagus punya nih");
//        this.rating.setStatus("PENDING");
//        this.rating.setUser(new User());
//        this.rating.setSubscriptionBox(new SubscriptionBox());
//    }

    @Test
    public void testCreateReview(){
        assertNotNull(rating);
    }

    @Test
    public void testGetReviewId(){
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", rating.getReviewId());
    }

    @Test
    public void testGetRatingScore(){
        assertEquals(5, rating.getRatingScore());
    }

    @Test
    public void testGetReview(){
        assertEquals("Barang bagus punya nih", rating.getReview());
    }

    @Test
    public void testGetStatus(){
        assertEquals("PENDING", rating.getStatus());
    }
}