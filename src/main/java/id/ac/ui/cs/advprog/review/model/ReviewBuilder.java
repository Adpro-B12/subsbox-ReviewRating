package id.ac.ui.cs.advprog.review.model;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class ReviewBuilder {
    private String reviewId;
    private String status;
    private int ratingScore;
    private String review;
    private User user;
    private SubscriptionBox subscriptionBox;

    public ReviewBuilder setReviewId(String reviewId){
        this.reviewId = reviewId;
        return this;
    }

    public ReviewBuilder setStatus(String status){
        this.status = status;
        return this;
    }

    public ReviewBuilder setRatingScore(int ratingScore){
        this.ratingScore = ratingScore;
        return this;
    }

    public ReviewBuilder setReview(String review){
        this.review = review;
        return this;
    }

    public ReviewBuilder setUser(User user){
        this.user = user;
        return this;
    }

    public ReviewBuilder setSubscriptionBox(SubscriptionBox subscriptionBox){
        this.subscriptionBox = subscriptionBox;
        return this;
    }

    public Review build(){
        if(reviewId == null || reviewId.isEmpty()){
            throw new IllegalArgumentException("Id must not null");
        }

        else if(ratingScore < 1){
            throw new IllegalArgumentException("Rating must be bigger than 1");
        }

        else if (user == null) {
            throw new IllegalArgumentException("No user registered");
        }

        else if (review == null || review.isEmpty()){
            throw new IllegalArgumentException("Insert a review to give review");
        }
        return new Review(this);
    }
}
