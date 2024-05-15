package id.ac.ui.cs.advprog.review.service;

import id.ac.ui.cs.advprog.review.model.Review;
import id.ac.ui.cs.advprog.review.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.Iterator;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Override
    @Async
    public CompletableFuture<Review> create(Review review) {
        return CompletableFuture.completedFuture(reviewRepository.create(review));
    }

    @Override
    @Async
    public CompletableFuture<Iterator<Review>> findAll() {
        return CompletableFuture.completedFuture(reviewRepository.findAll());
    }

    @Override
    @Async
    public CompletableFuture<Boolean> delete(String reviewId) {
        Review review = get(reviewId);
        if (review != null) {
            reviewRepository.deleteReview(review);
            return CompletableFuture.completedFuture(true);
        }
        return CompletableFuture.completedFuture(false);
    }

    public Review get(String reviewId){
        Iterator<Review> reviewIterator = reviewRepository.findAll();

        while (reviewIterator.hasNext()){
            Review current = reviewIterator.next();
            if(current.getReviewId().equals(reviewId)){
                return (current);
            }
        }
        return (null);
    }

    @Override
    @Async
    public CompletableFuture<Review> editReview(Review review, String reviewId) {
        Iterator<Review> reviewIterator = reviewRepository.findAll();

        int index = 0;
        while(reviewIterator.hasNext()){
            Review current = reviewIterator.next();
            if(current.getReviewId().equals(reviewId)){
                review.setReviewId(current.getReviewId());
                break;
            }
            index++;
        }
        return CompletableFuture.completedFuture(reviewRepository.edit(review, index));
    }
}
