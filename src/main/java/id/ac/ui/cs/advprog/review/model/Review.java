package id.ac.ui.cs.advprog.review.model;

import enums.Status;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Review {
    private String reviewId;
    private String status;
    private int ratingScore;
    private String review;
    private User user;
    private SubscriptionBox subscriptionBox;

    public Review(String ratingId, int ratingScore, String review, User user, SubscriptionBox subscriptionBox){
        this.ratingId = ratingId;
        this.ratingScore = ratingScore;
        this.review = review;
        this.user = user;
        this.subscriptionBox = subscriptionBox;
        this.status = Status.PENDING.getValue();
    }

    public Review(String ratingId, int ratingScore, String review, User user, SubscriptionBox subscriptionBox, String status){
        this(ratingId, ratingScore, review, user, subscriptionBox);
        this.setStatus(status);
    }

    public void setStatus(String status) {
        if (status.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
