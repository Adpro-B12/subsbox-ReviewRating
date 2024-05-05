package id.ac.ui.cs.advprog.rating.repository;

import id.ac.ui.cs.advprog.rating.model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RatingRepositoryTest {

    @InjectMocks
    RatingRepository ratingRepository;
    Rating rating1;
    Rating rating2;

    @BeforeEach
    public void setUp(){
        rating1.setRatingId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        rating1.setRatingScore(5);
        rating1.setReview("Barang bagus punya");
        rating1.setUser(new User());
        rating1.setSubscriptionBox(new SubscriptionBox());

        rating2.setRatingId("07f9b8b0-7257-4434-a5b9-79c9703f0760");
        rating2.setRatingScore(1);
        rating2.setReview("Gachanya jelek, jangan beli disini deh");
        rating2.setUser(new User());
        rating2.setSubscriptionBox(new SubscriptionBox());
    }

    @Test
    void testCreateAndFind(){
        ratingRepository.create(rating1);
        ratingRepository.create(rating2);

        assertNotNull(ratingRepository);

        Iterator<Rating> ratingIterator = ratingRepository.findAll();
        assertTrue(ratingIterator.hasNext());
        Rating savedRating = ratingIterator.next();
        assertEquals(rating1.getRatingId(), savedRating.getRatingId());
        assertEquals(rating1.getRatingScore(), savedRating.getRatingScore());
    }

    @Test
    void testFindAllEmpty(){
        Iterator<Rating> ratingIterator = ratingRepository.findAll();
        assertFalse(ratingIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct(){
        ratingRepository.create(rating1);
        ratingRepository.create(rating2);

        Iterator<Rating> ratingIterator = ratingRepository.findAll();
        assertTrue(ratingIterator.hasNext());
        Rating savedRating = ratingIterator.next();
        assertEquals(rating1.getRatingId(), savedRating.getRatingId());

        savedRating = ratingIterator.next();
        assertEquals(rating2.getRatingId(), savedRating.getRatingId());
    }

    @Test
    void testDeleteRepositoryRating(){
        ratingRepository.create(rating1);
        ratingRepository.create(rating2);

        ratingRepository.deleteRating(rating1);

        Iterator<Rating> ratingIterator = ratingRepository.findAll();
        assertTrue(ratingIterator.hasNext());
        Rating savedRating = ratingIterator.next();

        assertNotEquals(rating1.getRatingId(), savedRating.getRatingId());
        assertEquals(rating2.getRatingId(), savedRating.getRatingId());
    }
}
