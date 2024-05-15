package id.ac.ui.cs.advprog.review.model;

import enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Review")
@Setter@Getter
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

    public Review(String reviewId, int ratingScore, String review, User user, SubscriptionBox subscriptionBox){
        this.reviewId = reviewId;
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
