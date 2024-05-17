package org.alan.reviewsvc.review;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/review")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReview(@RequestBody Review review){
        return reviewService.save(review);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> findById(@PathVariable ObjectId id){
        return ResponseEntity.ok(reviewService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        return ResponseEntity.ok(reviewService.findAll());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable ObjectId id, @RequestBody Review review){

        if(id == null || review == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reviewService.update(id, review));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteReviewById(@PathVariable ObjectId id){
        reviewService.delete(id);
    }

}
