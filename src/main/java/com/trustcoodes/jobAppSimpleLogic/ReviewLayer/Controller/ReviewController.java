package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Controller;

import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity.ReviewEntity;
import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/companies/{id}")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review")
    public ResponseEntity<List<ReviewEntity>> findAllReview(@PathVariable Long id){
        return new ResponseEntity<>(reviewService.findAllReview(id), HttpStatus.OK);
    }

    @PostMapping("/review")
    public ResponseEntity<String> addReview(@PathVariable Long id, @RequestBody ReviewEntity reviewEntity){
        boolean reviewIsAdded = reviewService.addReview(id, reviewEntity);
        if (reviewIsAdded) {
            return new ResponseEntity<>("Review Added to Id attached", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review Not Added To ID attached", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/review/{reviewEntityId}")
    public ResponseEntity<ReviewEntity> findReviewById(@PathVariable Long reviewEntityId,
                                                             @PathVariable Long id){

        return new ResponseEntity<>(reviewService
                .findReviewById(reviewEntityId, id), HttpStatus.OK);
    }

    @PutMapping("/review/{reviewEntityId}")
    public ResponseEntity<String> updateReviewId(@RequestBody ReviewEntity reviewEntity,
                                                 @PathVariable Long reviewEntityId,
                                                 @PathVariable Long id){

        boolean checkingReviewUpdate = reviewService.updateReviewById(reviewEntity, reviewEntityId, id);
        if (checkingReviewUpdate){
            return new ResponseEntity<>("Review Fetched and Updated, Thanks", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("ERROR: Review NOT Updated, Not Found on DB", HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/review/{reviewEntityId}")
    public ResponseEntity<String> deleteByReviewId(@PathVariable Long id,
                                                   @PathVariable Long reviewEntityId){

        boolean reviewRemoved = reviewService.removeReviewById(id, reviewEntityId);
        if (reviewRemoved){
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Info Not Found on Database",HttpStatus.NOT_FOUND);
        }
    }
}