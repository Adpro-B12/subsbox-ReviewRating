package id.ac.ui.cs.advprog.rating.repository;

import id.ac.ui.cs.advprog.rating.model.Rating;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
@Repository
public class RatingRepository {

    private List<Rating> ratingList = new ArrayList<>();

    public Rating create(Rating rating){
        if(rating.getRatingId() == null){
            rating.setRatingId(UUID.randomUUID().toString());
        }
        ratingList.add(rating);
        return rating;
    }

    public Iterator<Rating> findAll(){
        return ratingList.iterator();
    }

    public Rating findById(String id){
        for(Rating rating: ratingList){
            if (rating.getRatingId().equals(id)){
                return rating;
            }
        }
        return null;
    }

    public boolean deleteRating(Rating rating){
        return ratingList.remove(rating);
    }
}
