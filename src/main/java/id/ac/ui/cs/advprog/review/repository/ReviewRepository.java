package id.ac.ui.cs.advprog.review.repository;

import id.ac.ui.cs.advprog.review.model.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
@Repository
public class ReviewRepository {

    private List<Review> reviewList = new ArrayList<>();

    public Review create(Review review){
        if(review.getReviewId() == null){
            review.setReviewId(UUID.randomUUID().toString());
        }
        reviewList.add(review);
        return review;
    }

    public Iterator<Review> findAll(){
        return reviewList.iterator();
    }

    public Review findById(String id){
        for(Review review: reviewList){
            if (review.getReviewId().equals(id)){
                return review;
            }
        }
        return null;
    }

    public boolean deleteReview(Review review){
        return reviewList.remove(review);
    }

    public Review edit(Review review, int index){
        return reviewList.set(index, review);
    }
}
