package id.ac.ui.cs.advprog.rating.service;

import id.ac.ui.cs.advprog.rating.model.Rating;
import id.ac.ui.cs.advprog.rating.repository.RatingRepository;
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
public class RatingServiceTest {
    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    RatingServiceImpl ratingService;
    Rating rating;

    @BeforeEach
    public void setUp(){
        rating.setRatingId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        rating.setRatingScore(5);
        rating.setReview("Barang bagus punya");
        rating.setUser(new User());
        rating.setSubscriptionBox(new SubscriptionBox());
    }

    @Test
    void testCreateRating(){
        when(ratingRepository.create(rating)).thenReturn(rating);
        Rating createRating = ratingService.create(rating);
        assertNotNull(createRating);
        assertEquals(rating.getRatingId(), createRating.getRatingId());
    }

    @Test
    void testFindAll(){
        List<Rating> ratingList = new ArrayList<>();
        Iterator<Rating> ratingIterator = ratingList.iterator();

        when(ratingRepository.findAll()).thenReturn(ratingIterator);
        List<Rating> result = ratingService.findAll();

        assertEquals(rating, result);
        verify(ratingRepository, times(1)).findAll();
    }

    @Test
    void testDelete(){
        ratingRepository.create(rating);

        when(ratingRepository.deleteRating(rating)).thenReturn(true);
        assertTrue(ratingRepository.deleteRating(rating));
    }
}
