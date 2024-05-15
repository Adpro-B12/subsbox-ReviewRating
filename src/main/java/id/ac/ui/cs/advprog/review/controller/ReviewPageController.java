package id.ac.ui.cs.advprog.review.controller;

import id.ac.ui.cs.advprog.review.model.Review;
import id.ac.ui.cs.advprog.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/Review")
public class ReviewPageController {
    @Autowired
    private ReviewService reviewService;

    public CompletableFuture<ResponseEntity<Review>> saveReview(@RequestBody Review review){
        return reviewService.create(review)
                .thenApply(savedReview -> new ResponseEntity<>(savedReview, HttpStatus.CREATED));
    }
}
