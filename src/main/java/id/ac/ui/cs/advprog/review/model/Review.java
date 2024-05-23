package id.ac.ui.cs.advprog.review.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import enums.Status;
import id.ac.ui.cs.advprog.review.State.ApprovedState;
import id.ac.ui.cs.advprog.review.State.PendingState;
import id.ac.ui.cs.advprog.review.State.RejectedState;
import id.ac.ui.cs.advprog.review.State.ReviewState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review")
@Getter@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "review_Id")
    private String reviewId;

    @Column(name = "rating_Score")
    private int ratingScore;

    @Column(name = "review_user")
    private String review;

    @Column(name = "userId")
    private String userId;

    @Column(name = "subscriptionBox")
    private String subscriptionBoxId;

    @Transient
    @JsonIgnore
    private ReviewState state;

    @Column(name = "state", nullable = false)
    @JsonIgnore
    private String stateString;

    @Column(name = "review_status")
    private Status reviewStatus;

    public Review(){
        this.stateString = Status.PENDING.getValue();
        this.state = new PendingState();
    }

    public Review(String reviewId, int ratingScore, String review, String userId, String subscriptionBoxId){
        this.reviewId = reviewId;
        this.ratingScore = ratingScore;
        this.review = review;
        this.userId = userId;
        this.subscriptionBoxId = subscriptionBoxId;
        this.state = new PendingState();
        this. reviewStatus = Status.PENDING;
        this.stateString = Status.PENDING.toString();
    }

    public void approve(){
        state.approve(this);
        this.stateString = "APPROVED";
    }

    public void postload(){
        switch (stateString){
            case "APPROVED" -> this.state = new ApprovedState();
            case "REJECTED" -> this.state = new RejectedState();
            default -> this.state = new PendingState();
        }
    }

    public void reject(){
        state.reject(this);
        this.stateString = "REJECTED";
    }
}