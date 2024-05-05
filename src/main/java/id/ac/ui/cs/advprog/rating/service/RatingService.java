package id.ac.ui.cs.advprog.rating.service;

import id.ac.ui.cs.advprog.rating.model.Rating;

import java.util.List;

public interface RatingService {
    public Rating create(Rating rating);
    public List<Rating> findAll();
    public boolean delete(String ratingId);
    public Rating editRating(Rating rating, String ratingId);
    public Rating get(String ratingId);
}
