package id.ac.ui.cs.advprog.rating.service;

import id.ac.ui.cs.advprog.rating.model.Rating;
import id.ac.ui.cs.advprog.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;
    @Override
    public Rating create(Rating rating) {
        ratingRepository.create(rating);
        return rating;
    }

    @Override
    public List<Rating> findAll() {
        Iterator<Rating> ratingIterator = ratingRepository.findAll();
        List<Rating> ratingList = new ArrayList<>();
        ratingIterator.forEachRemaining(ratingList::add);
        return ratingList;
    }

    @Override
    public boolean delete(String ratingId) {
        Rating rating = get(ratingId);

        if(rating != null){
            ratingRepository.deleteRating(rating);
            return true;
        }
        return false;
    }

    public Rating get(String ratingId){
        Iterator<Rating> ratingIterator = ratingRepository.findAll();

        while (ratingIterator.hasNext()){
            Rating current = ratingIterator.next();
            if(current.getRatingId().equals(ratingId)){
                return current;
            }
        }
        return null;
    }

    @Override
    public Rating findById(String ratingId) {
        return null;
    }
}
