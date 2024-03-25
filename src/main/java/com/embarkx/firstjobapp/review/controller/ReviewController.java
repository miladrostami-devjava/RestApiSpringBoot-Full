package com.embarkx.firstjobapp.review.controller;


import com.embarkx.firstjobapp.review.model.Review;
import com.embarkx.firstjobapp.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
public ResponseEntity<String> addReview(@PathVariable Long companyId,
                                        @RequestBody Review review){
    boolean isReviewSaved =    reviewService.addReview(review,companyId);
if (isReviewSaved){
    return new ResponseEntity<>("Review Added Successfully!",HttpStatus.CREATED);

}else {
    return new ResponseEntity<>("Review Not Saved!",HttpStatus.NOT_FOUND);

}
    }
@GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,
                                            @PathVariable Long reviewId){
return new ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.OK);

    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updatedReview(@PathVariable Long companyId,
                                                @PathVariable Long reviewId,
                                                @RequestBody Review review){
        boolean isReviewedUpdated = reviewService.updateReview(companyId, reviewId, review);
        if (isReviewedUpdated){
            return new ResponseEntity<>("Reviewed Updated Successfully!",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Reviewed Not Updated !",HttpStatus.NOT_FOUND);

        }
    }
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId){
boolean isDeletedReviewed = reviewService.deleteReview(companyId, reviewId);
if (isDeletedReviewed){
    return new ResponseEntity<>("Review Deleted Successfully!",HttpStatus.OK);
} else {
    return new ResponseEntity<>("Review Not Deleted! ",HttpStatus.NOT_FOUND);
}
    }





}
