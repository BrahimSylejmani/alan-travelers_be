package org.alan.reviewsvc.review;

import org.bson.types.ObjectId;

import java.util.List;

public interface ReviewService {

    Review save(Review review);

    List<Review> findAll();

    Review findById(ObjectId id);

    Review update(ObjectId id, Review review);

    void delete(ObjectId id);
}
