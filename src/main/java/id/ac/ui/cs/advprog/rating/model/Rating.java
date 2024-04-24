package id.ac.ui.cs.advprog.rating.model;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Rating {
    private String ratingId;
    private String status;
    private int ratingScore;
    private String review;
    private User user;
    private SubscriptionBox subscriptionBox;
}
