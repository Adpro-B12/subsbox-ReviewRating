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
}
