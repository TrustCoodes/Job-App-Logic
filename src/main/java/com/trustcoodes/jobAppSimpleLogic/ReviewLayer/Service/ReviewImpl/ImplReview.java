package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Service.ReviewImpl;

import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity.ReviewEntity;
import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Repository.ReviewRepo;
import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImplReview implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Override
    public List<ReviewEntity> findAllReview(Long id) {
        return reviewRepo.findByCompanyEntity_Id(id);
    }

    @Override
    public Optional<ReviewEntity> findReviewById(Long id) {

        return reviewRepo.findById(id);
    }

    @Override
    public void addReview(ReviewEntity reviewEntity) {
        reviewRepo.save(reviewEntity);
    }

    @Override
    public boolean removeReviewById(Long id) {
        if (reviewRepo.existsById(id)) {
            reviewRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReviewById(Long id, ReviewEntity reviewEntity) {
        Optional<ReviewEntity> reviewEntities = reviewRepo.findById(id);
        if (reviewEntities.isPresent()){
            ReviewEntity review = reviewEntities.get();
            review.setHeading(review.getHeading());
            review.setInfo(review.getInfo());
            review.setReviewRating(review.getReviewRating());
            reviewRepo.save(review);
            return true;
        }
        return false;
    }
}