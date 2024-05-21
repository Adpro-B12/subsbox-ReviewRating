package id.ac.ui.cs.advprog.review.State;

import enums.Status;
import id.ac.ui.cs.advprog.review.model.Review;

public class PendingState implements ReviewState{
    @Override
    public void approve(Review review) {
        review.setReviewStatus(Status.APPROVED);
        review.setState(new ApprovedState());
    }

    @Override
    public void reject(Review review) {
        review.setReviewStatus(Status.REJECTED);
        review.setState(new RejectedState());
    }
}
