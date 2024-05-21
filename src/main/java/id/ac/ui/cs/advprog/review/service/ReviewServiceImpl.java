package id.ac.ui.cs.advprog.review.service;

import id.ac.ui.cs.advprog.review.model.Review;
import id.ac.ui.cs.advprog.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Override
    public Review create(Review review) {
        reviewRepository.create(review);
        return review;
    }

    @Override
    public List<Review> findAll() {
        Iterator<Review> reviewIterator = reviewRepository.findAll();
        List<Review> reviewList = new ArrayList<>();
        reviewIterator.forEachRemaining(reviewList::add);
        return reviewList;
    }

    @Override
    public boolean delete(String reviewId) {
        Review review = findById(reviewId);

        if(review != null){
            reviewRepository.deleteReview(review);
            return true;
        }
        return false;
    }

    public Review findById(String reviewId){
        Iterator<Review> reviewIterator = reviewRepository.findAll();

        while (reviewIterator.hasNext()){
            Review current = reviewIterator.next();
            if(current.getReviewId().equals(reviewId)){
                return current;
            }
        }
        return null;
    }
}