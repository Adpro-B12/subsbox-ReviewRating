package id.ac.ui.cs.advprog.review.model;

import enums.Status;
import id.ac.ui.cs.advprog.review.State.ApprovedState;
import id.ac.ui.cs.advprog.review.State.PendingState;
import id.ac.ui.cs.advprog.review.State.RejectedState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewTest {

    private Review review;

    @BeforeEach
    public void setUp() {
        review = new Review("1", 5, "Barang bagus punya", "1321", "box456");
    }

    @Test
    public void testInitialState() {
        assertEquals(Status.PENDING, review.getReviewStatus());
        assertEquals("PENDING", review.getStateString());
        assertEquals(PendingState.class, review.getState().getClass());
    }

    @Test
    public void testApprove() {
        review.approve();
        assertEquals(Status.APPROVED, review.getReviewStatus());
        assertEquals("APPROVED", review.getStateString());
        assertEquals(ApprovedState.class, review.getState().getClass());
    }

    @Test
    public void testReject() {
        review.reject();
        assertEquals(Status.REJECTED, review.getReviewStatus());
        assertEquals("REJECTED", review.getStateString());
        assertEquals(RejectedState.class, review.getState().getClass());
    }

    @Test
    public void testGetId() {
        assertEquals("1", review.getReviewId());
    }

    @Test
    public void testGetRating() {
        assertEquals(5, review.getRatingScore());
    }

    @Test
    public void testGetComment() {
        assertEquals("Barang bagus punya", review.getReview());
    }

    @Test
    public void testGetUserId() {
        assertEquals("1321", review.getUserId());
    }

    @Test
    public void testGetSubscriptionBoxId() {
        assertEquals("box456", review.getSubscriptionBoxId());
    }

    @Test
    public void testSetId() {
        review.setReviewId("2");
        assertEquals("2", review.getReviewId());
    }

    @Test
    public void testSetRating() {
        review.setRatingScore(4);
        assertEquals(4, review.getRatingScore());
    }

    @Test
    public void testSetComment() {
        review.setReview("Barang bagus banget");
        assertEquals("Barang bagus banget", review.getReview());
    }

    @Test
    public void testSetUserId() {
        review.setUserId("1322");
        assertEquals("1322", review.getUserId());
    }

    @Test
    public void testSetSubscriptionBoxId() {
        review.setSubscriptionBoxId("box457");
        assertEquals("box457", review.getSubscriptionBoxId());
    }

}
