package id.ac.ui.cs.advprog.review.model;

import enums.Status;
import id.ac.ui.cs.advprog.review.state.PendingReviewState;
import id.ac.ui.cs.advprog.review.state.ReviewState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Review")
@Getter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "review_Id")
    private String reviewId;

    @Column(name = "status_Review")
    private String status;

    @Column(name = "rating_Score")
    private int ratingScore;

    @Column(name = "review_user")
    private String review;

    @Column(name = "user")
    private User user;

    @Column(name = "subscriptionBox")
    private SubscriptionBox subscriptionBox;

    // Constructor
    public Review(ReviewBuilder builder){
        this.reviewId = builder.getReviewId();
        this.ratingScore = builder.getRatingScore();
        this.review = builder.getReview();
        this.user = builder.getUser();
        this.subscriptionBox = builder.getSubscriptionBox();
        this.status = builder.getStatus();
    }

    // Setter for status
    public void setStatus(String status) {
        if (status.equals(Status.PENDING.getValue()) || status.equals(Status.APPROVED.getValue()) || status.equals(Status.REJECTED.getValue())) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status");
        }
    }

    public  Review(){}
}