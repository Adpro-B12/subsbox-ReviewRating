package id.ac.ui.cs.advprog.rating.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RatingTest {
    private  Rating rating;
    private User user;
    private SubscriptionBox subscriptionBox;

    @BeforeEach
    public void setUp(){
        rating = new Rating();
        this.rating.setRatingId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        this.rating.setRatingScore(5);
        this.rating.setReview("Barang bagus punya nih");
        this.rating.setStatus("PENDING");

        user = new User();

        subscriptionBox = new SubscriptionBox();
    }

    @Test
    public void testCreateRating(){
        assertNotNull(rating);
    }

    @Test
    public void testGetRatingId(){
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", rating.getRatingId());
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