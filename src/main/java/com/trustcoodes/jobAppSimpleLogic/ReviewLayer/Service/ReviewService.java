package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Service;

import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity.ReviewEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ReviewService {

    List<ReviewEntity> findAllReview(Long id);

    Optional<ReviewEntity> findReviewById(Long id);

    void addReview(ReviewEntity reviewEntity);

    boolean removeReviewById(Long id);

    boolean updateReviewById(Long id, ReviewEntity reviewEntity);
}
