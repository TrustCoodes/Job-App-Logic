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
}
